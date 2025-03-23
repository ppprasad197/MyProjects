//Create a class telephone containing name, telephone number & city and write necessary member functions for the following:
//	- Search the telephone number with given name. - Search the name with given telephone number. - Search all customers in a given city. 
//	(Use function overloading)

package InterviewPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Telephone {

	private String name;
	private long telephoneNum;
	private String city;

	public Telephone() {
		super();
	}

	public Telephone(String name, long telephoneNum, String city) {
		super();
		this.name = name;
		this.telephoneNum = telephoneNum;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTelephoneNum() {
		return telephoneNum;
	}

	public void setTelephoneNum(int telephoneNum) {
		this.telephoneNum = telephoneNum;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void searchByName(List<Telephone> telephoneList, String name) {
		for (Telephone telephone : telephoneList) {
			if (name.equalsIgnoreCase(telephone.getName())) {
				System.out.println(
						"Your name is " + name + " and your telephone number is : " + telephone.getTelephoneNum());
			}
		}
	}

	public void searchByTelephoneNumber(List<Telephone> telephoneList, long telephoneNum) {
		for (Telephone telephone : telephoneList) {
			if (telephoneNum == telephone.getTelephoneNum()) {
				System.out.println(
						"Your name is " + telephone.getName() + " and your telephone number is : " + telephoneNum);
			}
		}
	}

	public void searchByCity(List<Telephone> telephoneList, String city) {
		for (Telephone telephone : telephoneList) {
			if (city.equalsIgnoreCase(telephone.getCity())) {
				System.out.println(telephone);
			}
		}
	}

	@Override
	public String toString() {
		return "Telephone [name=" + name + ", telephoneNum=" + telephoneNum + ", city=" + city + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("How many telephone numbers you wants to add : ");
		int numberOfTelephoneNumbers = sc.nextInt();

		List<Telephone> telephoneList = new ArrayList<>();

		for (int i = 0; i < numberOfTelephoneNumbers; i++) {
			System.out.println("Enter telephone number holder name : ");
			String name = sc.next();

			System.out.println("Enter telephone number : ");
			long telephoneNum = sc.nextLong();

			System.out.println("Enter the city : ");
			String city = sc.next();

			telephoneList.add(new Telephone(name, telephoneNum, city));
		}

		Telephone telephone = new Telephone();

		while (true) {

			System.out.println("1. Search by name");
			System.out.println("2. Search by number");
			System.out.println("3. Search by city");
			System.out.println("4. Exit");
			System.out.println("Enter choice : ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Enter name to search details : ");
				String name = sc.next();
				telephone.searchByName(telephoneList, name);
				break;
			case 2:
				System.out.println("Enter telephone number to search details : ");
				long telephoneNum = sc.nextLong();
				telephone.searchByTelephoneNumber(telephoneList, telephoneNum);
				break;
			case 3:
				System.out.println("Enter city to search details : ");
				String city = sc.next();
				telephone.searchByCity(telephoneList, city);
				break;
			case 4:
				System.out.println("You are exiting ...!");
				return;
			default:
				System.out.println("Wrong choice");
				break;
			}
		}

	}

}
