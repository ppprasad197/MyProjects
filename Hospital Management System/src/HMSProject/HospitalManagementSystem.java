package HMSProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalManagementSystem {

	private static final String url = "jdbc:mysql://localhost:3306/Hospital_Management_System";
	private static final String username = "root";
	private static final String password = "root";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			Patient patient = new Patient(connection);
			Doctor doctor = new Doctor(connection);

			while (true) {
				System.out.println("*****HOSPITAL MANAGEMENT SYSTEM*****");
				System.out.println("1.Add patient");
				System.out.println("2.View patients");
				System.out.println("3.Add doctor");
				System.out.println("4.View doctors");
				System.out.println("5.Book appointments");
				System.out.println("6.View appointments");
				System.out.println("7.Delete patient");
				System.out.println("8.Delete doctor");
				System.out.println("9.Update patient");
				System.out.println("10.Update doctor");

				System.out.println("11.Exit");

				Scanner sc = new Scanner(System.in);

				System.out.println("Please enter your choice : ");
				int ch = sc.nextInt();

				switch (ch) {
				case 1:
					patient.addPatient();
					break;
				case 2:
					patient.viewPatient();
					break;
				case 3:
					doctor.addDoctor();
					break;
				case 4:
					doctor.viewDoctors();
					break;
				case 5:
					bookAppointment(connection, patient, doctor);
					break;
				case 6:
					viewAppointment(connection);
					break;

				case 7:
					patient.deletePatientById();
					break;

				case 8:
					doctor.deleteDoctorById();
					break;

				case 9:
					patient.updatePatientById();
					break;

				case 10:
					doctor.updateDoctorById();
					break;
				case 11:
					System.out.println("You are exiting...");
					return;
				default:
					System.out.println("Thank you for using Hospital Management System !!!");
					break;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void bookAppointment(Connection connection, Patient patient, Doctor doctor) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter patient id : ");
		int patientId = sc.nextInt();

		System.out.println("Enter doctor id : ");
		int doctorId = sc.nextInt();

		System.out.println("Enter appointment date (YYYY-MM-DD) :");
		String appointmentDate = sc.next();

		if (patient.getPatientById(patientId) && doctor.getDoctorById(doctorId)) {
			if (isDoctorAvailable(doctorId, appointmentDate, connection)) {
				String appointmentQuery = "INSERT INTO appointments(patient_id, doctor_id, appointmentDate) VALUES (?, ?, ?)";
				try (PreparedStatement preparedStatement = connection.prepareStatement(appointmentQuery)) {
					preparedStatement.setInt(1, patientId);
					preparedStatement.setInt(2, doctorId);
					preparedStatement.setString(3, appointmentDate);
					int isAdded = preparedStatement.executeUpdate();

					if (isAdded > 0)
						System.out.println("Appointment booked successfully.");
					else
						System.out.println("Failed to book appointment.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Doctor is not available on this date.");
			}
		} else {
			System.out.println("Invalid patient or doctor ID.");
		}
	}

	public static boolean isDoctorAvailable(int doctorId, String appointmentDate, Connection connection) {
		String query = "SELECT COUNT(*) FROM appointments WHERE doctor_id = ? AND appointmentDate = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, doctorId);
			preparedStatement.setString(2, appointmentDate);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					int count = resultSet.getInt(1);
					return count == 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void viewAppointment(Connection connection) {
		String query = "SELECT * FROM appointments";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				int patient_id = resultSet.getInt("patient_id");
				int doctor_id = resultSet.getInt("doctor_id");
				String appointmentDate = resultSet.getString("appointmentDate");

				System.out.println("patient_id : " + patient_id);
				System.out.println("doctor_id : " + doctor_id);
				System.out.println("Appointment Date : " + appointmentDate);
				System.out.println("---------------------------");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
