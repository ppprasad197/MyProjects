package HMSProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class Patient {
	private Connection connection;
	Scanner scanner = new Scanner(System.in);

	public Patient(Connection connection) {
		super();
		this.connection = connection;
	}

	public void addPatient() {

		System.out.println("Enter name : ");
		String name = scanner.next();

		System.out.println("Enter age : ");
		int age = scanner.nextInt();

		System.out.println("Enter gender : ");
		String gender = scanner.next();

		try {

			String query = " insert into patients (name,age,gender)values(?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, age);
			preparedStatement.setString(3, gender);

			int isAdded = preparedStatement.executeUpdate();

			if (isAdded > 0)
				System.out.println("Patient added successfully");
			else
				System.out.println("Patient not added ");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void viewPatient() {
		String query = "Select * from patients";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				int age = resultset.getInt("age");
				String gender = resultset.getString("gender");

				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Age: " + age);
				System.out.println("Gender: " + gender);
				System.out.println("---------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean getPatientById(int id) {
		String query = "select * from patients where id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void deletePatientById() {
		String query = "delete from patients where id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			System.out.println("Enter patients ID to delete");
			int id = scanner.nextInt();
			preparedStatement.setInt(1, id);
			int isDeleted = preparedStatement.executeUpdate();

			if (isDeleted > 0) {
				System.out.println("Patient deleted successfully");
			} else {
				System.out.println("No patient present against that ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePatientById() {
		String query = "UPDATE patients SET name = ?, age = ?, gender = ? WHERE id = ?";
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter patient ID: ");
		int patientId = sc.nextInt(); // Store the ID before checking

		// Check if patient exists
		if (getPatientById(patientId)) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				sc.nextLine(); // Clear the buffer after reading the integer

				System.out.println("Enter updated name: ");
				String updatedName = sc.nextLine();

				System.out.println("Enter updated age: ");
				int updatedAge = sc.nextInt();

				sc.nextLine(); // Clear the buffer before reading the next line

				System.out.println("Enter updated gender: ");
				String updatedGender = sc.nextLine();

				preparedStatement.setString(1, updatedName);
				preparedStatement.setInt(2, updatedAge);
				preparedStatement.setString(3, updatedGender);
				preparedStatement.setInt(4, patientId);

				int rowsUpdated = preparedStatement.executeUpdate();

				if (rowsUpdated > 0) {
					System.out.println("Patient's record updated successfully!");
				} else {
					System.out.println("No record found for the given ID.");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No patient found with ID " + patientId);
		}
	}

}
