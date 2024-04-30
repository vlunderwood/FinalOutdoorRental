package OutdoorRental;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JTextArea;
import java.util.HashMap;
import java.util.Map;

public class RentalDriver {

	private LinkedList<Rental> equipmentList; // list of equipment available for rental
	private Map<Integer, List<Customer>> rentalCustomerMap; // map of equipment IDs to lists of customers
	private Rental rental; // rental object for managing rentals

	// constructor
	public RentalDriver() {
		equipmentList = new LinkedList<>();
		rental = new Rental("EquipmentType", "EquipmentName");
		rentalCustomerMap = new HashMap<>();
		Customer.customerMap = Customer.getCustomerMap(); // gets customer map from Customer class
		populateEquipmentList(); // populate equipment and customer lists
		populateCustomerMap();
	}

	public LinkedList<Rental> getEquipmentList() { // gets list of equipment
		return equipmentList;
	}

	public Map<Integer, List<Customer>> getRentalCustomerMap() { // gets customer map
		return rentalCustomerMap;
	}

	public void populateEquipmentList() { // adds to equipment list, sets equipmentID's, adds name and type
		Rental kayak1 = new Rental("Single Kayak", "Pelican");
		equipmentList.add(kayak1);
		kayak1.setEquipmentID(14);

		Rental kayak2 = new Rental("Double Kayak", "Pelican2");
		equipmentList.add(kayak2);
		kayak2.setEquipmentID(2);

		Rental bike1 = new Rental("Mountain Bike", "Giant");
		equipmentList.add(bike1);
		bike1.setEquipmentID(1);

		Rental bike2 = new Rental("Mountain Bike", "Trek");
		equipmentList.add(bike2);
		bike2.setEquipmentID(15);

		Rental tent = new Rental("Tent", "Coleman");
		equipmentList.add(tent);
		tent.setEquipmentID(3);

		Rental cooler1 = new Rental("Cooler", "RTIC");
		equipmentList.add(cooler1);
		cooler1.setEquipmentID(6);

		Rental cooler2 = new Rental("Cooler", "Yeti");
		equipmentList.add(cooler2);
		cooler2.setEquipmentID(12);

		Rental generator1 = new Rental("Portable Generator", "Yamaha");
		equipmentList.add(generator1);
		generator1.setEquipmentID(7);

		Rental generator2 = new Rental("Portable Generator", "Generac");
		equipmentList.add(generator2);
		generator2.setEquipmentID(9);

		Rental canoe1 = new Rental("Canoe", "Clipper");
		equipmentList.add(canoe1);
		canoe1.setEquipmentID(5);

		Rental canoe2 = new Rental("Canoe", "Old Town");
		equipmentList.add(canoe2);
		canoe2.setEquipmentID(11);

		Rental canoe3 = new Rental("Canoe", "Mad River");
		equipmentList.add(canoe3);
		canoe3.setEquipmentID(8);

		kayak1.rentOutItem(1); // rents out items, num in () is customerID
		bike1.rentOutItem(5);
		cooler2.rentOutItem(3);
		canoe1.rentOutItem(4);
		tent.rentOutItem(1);
		generator2.rentOutItem(1);
	}

	public void populateCustomerMap() { // adds customers to customer map, adds name, age, lisence #, and phone number
		Customer.addCustomer(new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234"));
		Customer.addCustomer(new Customer("Brandy Brown", 29, "YY456AA34", "641-555-2345"));
		Customer.addCustomer(new Customer("Thomas Underwood", 27, "YY789AA56", "641-555-4321"));
		Customer.addCustomer(new Customer("Shawn McKanich", 30, "YY987AA78", "641-555-3456"));
		Customer.addCustomer(new Customer("Bobby Tutor", 23, "YY765AA89", "641-555-6543"));
		Customer.addCustomer(new Customer("Fletcher Flynn", 25, "YY654AA78", "641-555-5678"));
		Customer.addCustomer(new Customer("Bill Brown", 56, "YY543AA67", "641-555-8765"));
		Customer.addCustomer(new Customer("Valerie Underwood", 38, "YY432AA67", "641-555-9876"));
		Customer.addCustomer(new Customer("Linda Greiner", 49, "YY321AA54", "641-555-4836"));
	}

	// method to add equipment
	public void addEquipment(int equipmentID, String equipmentType, String equipmentName) {
		Rental equipment = new Rental(equipmentType, equipmentName); // creates new Rental object with type and name
		equipment.setEquipmentID(equipmentID); // set ID's of equipment
		equipmentList.add(equipment); // adds equipment to equipment list
	}

	// method to remove equipment
	public boolean removeEquipment(int equipmentId) {
		for (Rental equipment : equipmentList) { // iterates through equipment list
			if (equipment.getEquipmentID().peek() == equipmentId) { // makes sure ID of the equipment matches ID entered
				equipmentList.remove(equipment); // removes equipment from the list
				return true;
			}
		}
		return false;
	}

	// method to add customer
	public void addCustomer(String customerName, int age, String licenseId, String phoneNumber) {
		Customer customer = new Customer(customerName, age, licenseId, phoneNumber); // creates new Customer object with
																						// customer parameters
		Customer.addCustomer(customer); // adds customer to the customer map, calls addCustomer from Customer class
	}

	// method to remove customer
	public boolean removeCustomer(int customerId) {
		return Customer.removeCustomer(customerId) != null; // removes customer, calls removeCustomer method from
															// Customer class
	}

	// method to rent equipment
	public void rentEquipment(int equipmentID, int customerID) {
		for (Rental rental : equipmentList) { // iterates through list of equipment
			if (rental.getEquipmentIDList() == equipmentID && !rental.getIsRented()) { // makes sure equipment matches
																						// the ID entered and is not
																						// rented
				rental.rentOutItem(customerID); // rents out equipment to customer
				return;
			}
		}
		System.out.println("Equipment is not found or already rented."); // prints a message if the equipment is not
																			// found or already rented
	}

	// method to check if equipment is available
	public boolean equipmentID(int equipmentID) {
		for (Rental rental : equipmentList) { // iterates through list of equipment
			LinkedList<Integer> equipmentIDs = rental.getEquipmentID(); // gets list of equipment IDs that matches
																		// current equipment
			for (Integer id : equipmentIDs) {
				if (id == equipmentID) {// if match is found, equipmentID is already assigned to another equipment &
										// returns false
					return false;
				}
			}
		}
		return true; // if no match is found, the equipment ID is available & returns true
	}

	// method to find rental by equipmentID
	public Rental findRentalByID(int equipmentId) {
		for (Rental rental : equipmentList) {
			if (rental.getEquipmentID().peek() == equipmentId) { // checks if equipmentID of rental matches ID entered
				return rental;// returns rental if found
			}
		}
		return null;// returns null if rental is not found
	}

	// method to find customer by ID
	public Customer findCustomerByID(int customerId) {
		return Customer.getCustomerByID(customerId); // call to getCustomerByID method in Customer class
	}

	// method to sort equipmentList, uses Insertion sort on equipment ID's
	public void insertionSort() {
		int n = equipmentList.size(); // gets size of equipment list
		for (int i = 1; i < n; ++i) { // iterates over elements
			Rental key = equipmentList.get(i); // gets element to be inserted
			int j = i - 1;
			// moves elements that are greater than key to one position ahead
			while (j >= 0 && equipmentList.get(j).getEquipmentID().peek() > key.getEquipmentID().peek()) {
				equipmentList.set(j + 1, equipmentList.get(j));
				j = j - 1;
			}
			equipmentList.set(j + 1, key); // inserts element
		}
	}
	// method to sort equipmentList, uses Insertion sort on equipment names
	/*
	 * public void insertionSort() { int n = equipmentList.size(); for (int i = 1; i
	 * < n; ++i) { Rental key = equipmentList.get(i); String keyName =
	 * key.getEquipmentName(); int j = i - 1;
	 * 
	 * // moves elements that are greater than key to one position ahead while (j >=
	 * 0 && equipmentList.get(j).getEquipmentName().compareTo(keyName) > 0) {
	 * equipmentList.set(j + 1, equipmentList.get(j)); j = j - 1; }
	 * equipmentList.set(j + 1, key); } }
	 */

	// method to display reports
	public void displayReport(JTextArea txtAreaReport) {
		StringBuilder report = new StringBuilder(); // initializes StringBuilder to build report
		report.append("Rented Items:\n").append(createRentedItemsReport()).append("\n");
		report.append("Equipment Report:\n").append(createEquipmentReport()).append("\n");
		report.append("Customer Report:\n").append(createCustomerReport()).append("\n");
		// report.append("Waitlist
		// Report:\n").append(createWaitlistReport()).append("\n");
		txtAreaReport.setText(report.toString());
	}

	// creates rented items report
	public String createRentedItemsReport() {
		StringBuilder report = new StringBuilder("Rented Items -\n"); // initializes StringBuilder to construct report
		for (Rental rental : equipmentList) { // iterates through each rental in the equipment list
			if (rental.getIsRented()) { // sees if rental is rented
				report.append(rental.generateRentalReport()).append("\n"); // appends the rental report
			}
		}
		return report.toString();
	}

	// creates equipment report
	public String createEquipmentReport() {
		StringBuilder report = new StringBuilder("Equipment -\n"); // initializes StringBuilder to construct report
		for (Rental equipment : equipmentList) { // iterates through each equipment in the equipment list
			report.append(equipment.toString()).append("\n"); // appends the equipment details
		}
		return report.toString();
	}

	// creates customer report
	public String createCustomerReport() {
		StringBuilder report = new StringBuilder("Customers -\n"); // initializes StringBuilder to construct report
		for (Customer customer : Customer.getCustomerMap().values()) { // iterates through each customer in the customer
																		// map
			report.append(customer.toString()).append("\n"); // appends the customer details
		}
		return report.toString();
	}

	public static void main(String[] args) {
		RentalDriver rentalDriver = new RentalDriver(); // initializes a new RentalDriver instance
		rentalDriver.insertionSort(); // sorts equipment list calling insertionSort method
		JTextArea textArea = new JTextArea(); // initializes JTextArea to display the report
		rentalDriver.displayReport(textArea); // displays report in the JTextArea
	}
}
//Medium, "Combining a hash map with a linked list to boost performance." 25, Jan 2022,  https://medium.com/@rebizant/combining-a-hash-map-with-a-linked-list-to-boost-performance-9ce19873bbdf

//Medium, "Car Rental System using Java."  01 Oct, 2023, https://harshananayakkara.medium.com/car-rental-system-using-java-d5c6fd7e7f00

//Apache Software Foundation, https://svn.apache.org/repos/asf/pivot/trunk/core/test/org/apache/pivot/collections/test/HashMapTest.java

//GeeksforGeeks, "Insertion Sort – Data Structure and Algorithm Tutorials." 08 Apr, 2024, https://www.geeksforgeeks.org/insertion-sort/#

//Oracle, "Class HashMap<K,V>." 2024, https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html

//GeeksforGeeks, "Hashmap methods in Java with Examples | Set 2 (keySet(), values(), containsKey()..)." 14 Oct, 2019, https://www.geeksforgeeks.org/hashmap-methods-java-examples-set-2-keyset-values-containskey/?ref=header_search#

//GeeksforGeeks, "HashMap in Java." 13 Dec, 2023, https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/#

//W3Schools, "Java LinkedList." 2024, https://www.w3schools.com/java/java_linkedlist.asp

//Digital Ocean, "Java LinkedList - LinkedList In Java." 3 August, 2022, https://www.digitalocean.com/community/tutorials/java-linkedlist-linkedlist-java

//GeeksforGeeks, "LinkedList in Java." 12 Jun, 2023, https://www.geeksforgeeks.org/linked-list-in-java/

//Eclipse, "WindowBuilder User Guide." 2024, https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.wb.doc.user%2Fhtml%2Findex.html

//Vogella, "Eclipse WindowBuilder - Creating user interfaces - Tutorial." 2024, https://www.vogella.com/tutorials/EclipseWindowBuilder/article.html

//Javatpoint, "Java Swing Tutorial." 2021, https://www.javatpoint.com/java-swing

//YouTube, "Java Swing For Beginners | What is Java Swing | Java Swing Tutorial | Intellipaat." https://www.youtube.com/watch?v=6zm8c6QFmjo

//Oracle, "The Java™ Tutorials." 2022,  https://docs.oracle.com/javase/tutorial/uiswing/

//GeeksforGeeks, "Introduction to Java Swing." 09 Jan, 2024, https://www.geeksforgeeks.org/introduction-to-java-swing/