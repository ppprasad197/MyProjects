//7. Write a program create Product class with members
//	Product Id
//	Product Name
//	Rate of Product
//	Quantity of Product
//	Amount of product
//	calculate the discount 10 % on Amount
//	calculate the net amount
//	perform for 3 objects

package InterviewPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product {

	private int id;
	private String prodName;
	private double price;
	private int quantity;
	private double amount;

	public Product() {
		super();
	}

	public Product(int id, String prodName, double price, int quantity, double amount) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", prodName=" + prodName + ", price=" + price + ", quantity=" + quantity
				+ ", amount=" + amount + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("How many products wants to add : ");
		int numberOfProducts = sc.nextInt();

		List<Product> productDetails = new ArrayList<>();

		for (int i = 0; i < numberOfProducts; i++) {
			System.out.println("Enter product id : ");
			int id = sc.nextInt();

			System.out.println("Enter product name : ");
			String name = sc.next();

			System.out.println("Enter product price : ");
			double price = sc.nextDouble();

			System.out.println("Enter product quantity : ");
			int quantity = sc.nextInt();

			double amount = price * quantity;

			productDetails.add(new Product(id, name, price, quantity, amount));

		}

		for (Product product : productDetails) {
			System.out.println(product);
			double discount = product.getAmount() * 0.10;
			System.out.println("Discount for " + product.getProdName() + " is " + discount);

			double netAmount = product.getAmount() - discount;
			System.out.println("Net amount for " + product.getProdName() + " is " + netAmount);
		}

	}

}
