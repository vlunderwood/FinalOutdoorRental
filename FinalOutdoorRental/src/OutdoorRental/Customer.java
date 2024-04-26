package OutdoorRental;

import java.util.HashMap;
import java.util.Map;

public class Customer {
	//variables
	private static int lastCustomerID = 0;	
	private int customerID;
	private String customerName;
	private int age;
	private String licenseId;
	private String phoneNumber;
	private static Map<Integer, Customer> customerMap = new HashMap<>(); //map to store customers with IDs as keys

	//constructor
	public Customer(String customerName, int age, String licenseId, String phoneNumber) {
		this.customerID = ++lastCustomerID;
		this.customerName = customerName;
		this.age = age;
		this.licenseId = licenseId;
		this.phoneNumber = phoneNumber;
		customerMap.put(customerID, this);
	}

	//getters
	public static int getLastCustomerID() {
		return lastCustomerID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getAge() {
		return age;
	}

	public String getLicenseId() {
		return licenseId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public static Map<Integer, Customer> getCustomerMap() {
		return customerMap;
	}

	public static Customer getCustomerByID(int customerID) {
		return customerMap.get(customerID);
	}

	//setters
	public static void setLastCustomerID(int lastCustomerID) {
		Customer.lastCustomerID = lastCustomerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static void setCustomerMap(Map<Integer, Customer> customerMap) {
		Customer.customerMap = customerMap;
	}

	public void setCustomerByID(Customer customer) {
		customerMap.put(customer.getCustomerID(), customer);
	}

	//map methods
	
	//adding a customer to the map
	public static void addCustomer(Customer customer) {
		customerMap.put(customer.getCustomerID(), customer);
	}

	//removing a customer from the map
	public static Customer removeCustomer(int customerID) {
		return customerMap.remove(customerID);
	}

	 //count of customers in map
	public static int getCount() {
		return customerMap.size();
	}

	 //checking if a customer ID exists in map
	public static boolean containsKey(int customerID) {
		return customerMap.containsKey(customerID);
	}

	//finding a customer by ID in the map
	public Customer findCustomerByID(int customerID) {
		return customerMap.get(customerID);
	}

	@Override		//string print method of customer info
	public String toString() {
		return "Customer ID: " + customerID + ", Name: " + customerName + ", Age: " + age + ", License ID: " + licenseId
				+ ", Phone Number: " + phoneNumber;
	}
}