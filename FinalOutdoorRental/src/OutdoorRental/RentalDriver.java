package OutdoorRental;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JTextArea;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class RentalDriver {

	private LinkedList<Rental> equipmentList;
	private LinkedList<Customer> customerList;
	private Map<Integer, List<Customer>> rentalCustomerMap;
	private Rental rental;

	public RentalDriver() {
		equipmentList = new LinkedList<>();
		customerList = new LinkedList<>();
		rentalCustomerMap = new HashMap<>();
		rental = new Rental("EquipmentType", "EquipmentName");
		populateEquipmentList();
		populateCustomerList();

		
	}

	public static void main(String[] args) {
		RentalDriver rentalDriver = new RentalDriver();
		rentalDriver.insertionSort();
		JTextArea textArea = new JTextArea();
		rentalDriver.displayReport(textArea);
	}

	public LinkedList<Rental> getEquipmentList() {
		return equipmentList;
	}

	public LinkedList<Customer> getCustomerList() {
		return customerList;
	}

	private void populateEquipmentList() {
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

		kayak1.rentOut(1);
		bike1.rentOut(5);
		cooler2.rentOut(3);
		canoe1.rentOut(4);
		tent.rentOut(1);
		generator2.rentOut(1);

		kayak1.addToWaitlist(1, 2);
		kayak1.addToWaitlist(1, 3);

		canoe1.addToWaitlist(11, 5);
		canoe1.addToWaitlist(11, 4);
		canoe1.addToWaitlist(11, 6);

		cooler2.addToWaitlist(8, 2);
		cooler2.addToWaitlist(1, 3);

	}

	private void populateCustomerList() {
		customerList.add(new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234"));
		customerList.add(new Customer("Brandy Brown", 29, "YY456AA34", "641-555-2345"));
		customerList.add(new Customer("Thomas Underwood", 27, "YY789AA56", "641-555-4321"));
		customerList.add(new Customer("Shawn McKanich", 30, "YY987AA78", "641-555-3456"));
		customerList.add(new Customer("Bobby Tutor", 23, "YY765AA89", "641-555-6543"));
		customerList.add(new Customer("Fletcher Flynn", 25, "YY654AA78", "641-555-5678"));
		customerList.add(new Customer("Bill Brown", 56, "YY543AA67", "641-555-8765"));
		customerList.add(new Customer("Valerie Underwood", 38, "YY432AA67", "641-555-9876"));
		customerList.add(new Customer("Linda Greiner", 49, "YY321AA54", "641-555-4836"));

	}

	public void addEquipment(int equipmentID, String equipmentType, String equipmentName) {
		Rental equipment = new Rental(equipmentType, equipmentName);
		equipment.setEquipmentID(equipmentID);
		equipmentList.add(equipment);
	}

	public boolean removeEquipment(int equipmentId) {
		for (Rental equipment : equipmentList) {
			if (equipment.getEquipmentID().peek() == equipmentId) {
				equipmentList.remove(equipment);
				return true;
			}
		}
		return false;
	}

	public void addCustomer(String customerName, int age, String licenseId, String phoneNumber) {
		Customer customer = new Customer(customerName, age, licenseId, phoneNumber);
		customerList.add(customer);
	}

	public boolean removeCustomer(int customerId) {
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == customerId) {
				customerList.remove(customer);
				return true;
			}
		}
		return false;
	}

	public void rentEquipment(int equipmentID, int customerID) {
		for (Rental rental : equipmentList) {
			if (rental.getEquipmentIDList() == equipmentID && !rental.isRented()) {
				rental.rentOut(customerID);
				return;
			}
		}
		System.out.println("Equipment is not found or already rented.");
	}

	public boolean equipmentID(int equipmentID) {
		for (Rental rental : equipmentList) {
			LinkedList<Integer> equipmentIDs = rental.getEquipmentID();
			for (Integer id : equipmentIDs) {
				if (id == equipmentID) {
					return false;
				}
			}
		}
		return true;
	}

	public void setCustomerList(LinkedList<Customer> customerList) {
		this.customerList = customerList;
	}

	public Map<Integer, List<Customer>> getRentalCustomerMap() {
		return rentalCustomerMap;
	}

	public void addToWaitlist(int equipmentId, int customerId) {
		Rental rental = findRentalById(equipmentId);
		if (rental != null) {
			rental.addToWaitlist(equipmentId, customerId);
		} else {
			System.out.println("Equipment is not found.");
		}
	}

	public void removeFromWaitlist(int equipmentId, int customerId) {
	    Rental rental = findRentalById(equipmentId);
	    if (rental != null) {
	        rental.removeFromWaitlist(equipmentId, customerId);
	    } else {
	        System.out.println("Equipment is not found.");
	    }
	}

	public Rental findRentalById(int equipmentId) {
		for (Rental rental : equipmentList) {
			if (rental.getEquipmentID().peek() == equipmentId) {
				return rental;
			}
		}
		return null;
	}

	public Customer findCustomerById(int customerId) {
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == customerId) {
				return customer;
			}
		}
		return null;
	}
	
	 void insertionSort() {
	 int n = equipmentList.size();
     for (int i = 1; i < n; ++i) {
         Rental key = equipmentList.get(i);
         int j = i - 1;

         while (j >= 0 && equipmentList.get(j).getEquipmentID().peek() > key.getEquipmentID().peek()) {
             equipmentList.set(j + 1, equipmentList.get(j));
             j = j - 1;
         }
         equipmentList.set(j + 1, key);
     }
 }

	public void displayReport(JTextArea txtAreaReport) {
		StringBuilder report = new StringBuilder();
		report.append("Rented Items:\n").append(createRentedItemsReport()).append("\n"); 
		report.append("Equipment Report:\n").append(createEquipmentReport()).append("\n");
		report.append("Customer Report:\n").append(createCustomerReport()).append("\n");
		report.append("Waitlist Report:\n").append(createWaitlistReport()).append("\n");
		txtAreaReport.setText(report.toString());

	}

	
	public String createRentedItemsReport() {
	    StringBuilder report = new StringBuilder("Rented Items -\n");
	    for (Rental rental : equipmentList) {
	        if (rental.isRented()) {
	            report.append(rental.generateRentalReport()).append("\n"); 
	        }
	    }
	    return report.toString();
	}

	public String createEquipmentReport() {
		StringBuilder report = new StringBuilder("Equipment -\n");
		for (Rental equipment : equipmentList) {
			report.append(equipment.toString()).append("\n");
		}
		return report.toString();
	}

	public String createCustomerReport() {
		StringBuilder report = new StringBuilder("Customers -\n");

		for (Customer customer : customerList) {
			report.append(customer.toString()).append("\n");
		}
		return report.toString();
	}

	public String createWaitlistReport() {
		StringBuilder report = new StringBuilder("Waitlist -\n");
		for (Rental rental : equipmentList) {
			Map<Integer, Queue<Integer>> waitlistMap = rental.getWaitlist();
			if (waitlistMap != null && !waitlistMap.isEmpty()) {
				report.append("Equipment ID: ").append(rental.getEquipmentID().peek()).append("\n");
				report.append("Customers:\n");
				for (Queue<Integer> customerQueue : waitlistMap.values()) {
					for (Integer customerId : customerQueue) {
						Customer customer = findCustomerById(customerId);
						if (customer != null) {
							report.append(customer.toString()).append("\n");
						}
					}
				}
				report.append("\n");
			}
		}
		return report.toString();
	}

}

//Medium, "Car Rental System using Java."  01 Oct, 2023, https://harshananayakkara.medium.com/car-rental-system-using-java-d5c6fd7e7f00

//Apache Software Foundation, https://svn.apache.org/repos/asf/pivot/trunk/core/test/org/apache/pivot/collections/test/HashMapTest.java

//GeeksforGeeks, "Insertion Sort – Data Structure and Algorithm Tutorials." 08 Apr, 2024, https://www.geeksforgeeks.org/insertion-sort/#

//Oracle, "Class HashMap<K,V>." 2024, https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html

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