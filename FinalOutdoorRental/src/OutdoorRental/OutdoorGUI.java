package OutdoorRental;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JTextArea;
import java.util.List;

//GUI that manages rentals
public class OutdoorGUI extends JFrame {

	// text fields for title and subtitles
	private JTextField outdoorRentalsTitle;
	private JTextField rentalsSubTitle;
	private JTextField customerSubTitle;
	private JTextField reportSubTitle;

	// text areas for displaying reports
	private JTextArea rentaltxtAreaReport;
	private JTextArea equipmenttxtAreaReport;
	private JTextArea customertxtAreaReport;

	// Reference to the RentalDriver for managing rentals
	private RentalDriver rentalDriver;

	// constructor
	public OutdoorGUI(RentalDriver rentalDriver) {
		this.rentalDriver = rentalDriver;
		initialize();
	}

	private void initialize() {
		// set JFrame properties
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(85, 107, 47));
		setBounds(100, 100, 804, 835);
		getContentPane().setLayout(null);

		// title properties
		outdoorRentalsTitle = new JTextField();
		outdoorRentalsTitle.setBackground(new Color(210, 105, 30));
		outdoorRentalsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		outdoorRentalsTitle.setFont(new Font("Lucida Sans", Font.PLAIN, 21));
		outdoorRentalsTitle.setText("Outdoor Rentals");
		outdoorRentalsTitle.setBounds(259, 10, 274, 45);
		getContentPane().add(outdoorRentalsTitle);
		outdoorRentalsTitle.setColumns(10);

		// subtitle properties
		rentalsSubTitle = new JTextField();
		rentalsSubTitle.setBackground(new Color(184, 134, 11));
		rentalsSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		rentalsSubTitle.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		rentalsSubTitle.setText("Rentals");
		rentalsSubTitle.setBounds(78, 78, 115, 35);
		getContentPane().add(rentalsSubTitle);
		rentalsSubTitle.setColumns(10);

		customerSubTitle = new JTextField();
		customerSubTitle.setBackground(new Color(184, 134, 11));
		customerSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		customerSubTitle.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		customerSubTitle.setText("Customers");
		customerSubTitle.setBounds(342, 78, 115, 35);
		getContentPane().add(customerSubTitle);
		customerSubTitle.setColumns(10);

		reportSubTitle = new JTextField();
		reportSubTitle.setBackground(new Color(184, 134, 11));
		reportSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		reportSubTitle.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		reportSubTitle.setText("Reports");
		reportSubTitle.setBounds(585, 78, 115, 35);
		getContentPane().add(reportSubTitle);
		reportSubTitle.setColumns(10);

		// JButton to add equipment
		JButton buttonAddEquipment = new JButton("Add Equipment"); // formatting button
		buttonAddEquipment.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonAddEquipment.setBackground(new Color(255, 228, 181));
		buttonAddEquipment.addActionListener(new ActionListener() { // handles click events
			public void actionPerformed(ActionEvent e) { // actionPerformed method when clicked
				addEquipment(); // calling addEquipment() method from OutdoorGUI class
			}
		});
		buttonAddEquipment.setBounds(61, 135, 149, 21); // adds and sets where button goes in JFrame
		getContentPane().add(buttonAddEquipment);

		// JButton to remove equipment
		JButton buttonRemoveEquipment = new JButton("Remove Equipment");// formatting button
		buttonRemoveEquipment.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonRemoveEquipment.setBackground(new Color(255, 228, 181));
		buttonRemoveEquipment.addActionListener(new ActionListener() { // handles click events
			public void actionPerformed(ActionEvent e) { // actionPerformed method when clicked
				removeEquipment(); // calling removeEquipment() method from OutdoorGUI class
			}
		});
		buttonRemoveEquipment.setBounds(61, 166, 149, 21);// adds and sets where button goes in JFrame
		getContentPane().add(buttonRemoveEquipment);

		// JButton to rent equipment
		JButton buttonRentEquipment = new JButton("Rent Equipment");// formatting button
		buttonRentEquipment.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonRentEquipment.setBackground(new Color(255, 228, 181));
		buttonRentEquipment.addActionListener(new ActionListener() { // handles click events
			public void actionPerformed(ActionEvent e) { // actionPerformed method when clicked
				rentEquipment(); // calling rentEquipment() method from OutdoorGUI class
			}
		});
		buttonRentEquipment.setBounds(61, 197, 149, 21);// adds and sets where button goes in JFrame
		getContentPane().add(buttonRentEquipment);

		// JButton to return equipment
		JButton buttonReturnEquipment = new JButton("Return Equipment");// formatting button
		buttonReturnEquipment.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonReturnEquipment.setBackground(new Color(255, 228, 181));
		buttonReturnEquipment.addActionListener(new ActionListener() { // handles click events
			public void actionPerformed(ActionEvent e) { // actionPerformed method when clicked
				returnEquipment(); // calling returnEquipment() method from OutdoorGUI class
			}
		});
		buttonReturnEquipment.setBounds(61, 226, 149, 21);// adds and sets where button goes in JFrame
		getContentPane().add(buttonReturnEquipment);

		// JButton to add a customer
		JButton buttonAddCustomer = new JButton("Add Customer");// formatting button
		buttonAddCustomer.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonAddCustomer.setBackground(new Color(255, 228, 181));
		buttonAddCustomer.addActionListener(new ActionListener() { // handles click events
			public void actionPerformed(ActionEvent e) { // actionPerformed method when clicked
				addCustomer(); // calling addCustomer() method from OutdoorGUI class
			}
		});
		buttonAddCustomer.setBounds(327, 135, 147, 21);// adds and sets where button goes in JFrame
		getContentPane().add(buttonAddCustomer);

		// JButton to remove a customer
		JButton buttonRemoveCustomer = new JButton("Remove Customer");// formatting button
		buttonRemoveCustomer.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonRemoveCustomer.setBackground(new Color(255, 228, 181));
		buttonRemoveCustomer.addActionListener(new ActionListener() { // handles click events
			public void actionPerformed(ActionEvent e) { // actionPerformed method when clicked
				removeCustomer(); // calling removeCustomer() method from OutdoorGUI class
			}
		});
		buttonRemoveCustomer.setBounds(327, 166, 147, 21);// adds and sets where button goes in JFrame
		getContentPane().add(buttonRemoveCustomer);

		// JButton to view rental report
		JButton buttonRentalReport = new JButton("Rental Report"); // formatting button
		buttonRentalReport.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonRentalReport.setBackground(new Color(255, 222, 173));
		buttonRentalReport.addActionListener(new ActionListener() { // handles click events
			public void actionPerformed(ActionEvent e) { // actionPerformed method when clicked
				rentalReport(); // calling rentalReport() method from OutdoorGUI class
			}
		});
		buttonRentalReport.setBounds(575, 134, 147, 22);// adds and sets where button goes in JFrame
		getContentPane().add(buttonRentalReport);

		rentaltxtAreaReport = new JTextArea();// creates and formats text area for report
		rentaltxtAreaReport.setTabSize(4);
		rentaltxtAreaReport.setBounds(20, 266, 745, 498);
		rentaltxtAreaReport.setEditable(false);
		getContentPane().add(rentaltxtAreaReport);

		// JButton to view equipment report
		JButton buttonEquipmentReport = new JButton("Equipment Report"); // formatting button
		buttonEquipmentReport.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonEquipmentReport.setBackground(new Color(255, 222, 173));
		buttonEquipmentReport.addActionListener(new ActionListener() { // handles click events
			public void actionPerformed(ActionEvent e) { // actionPerformed method when clicked
				equipmentReport(); // calling equipmentReport() method from OutdoorGUI class
			}
		});
		buttonEquipmentReport.setBounds(575, 166, 147, 21);// adds and sets where button goes in JFrame
		getContentPane().add(buttonEquipmentReport);

		equipmenttxtAreaReport = new JTextArea();// creates and formats text area for report
		equipmenttxtAreaReport.setTabSize(4);
		equipmenttxtAreaReport.setBounds(20, 266, 745, 498);
		equipmenttxtAreaReport.setEditable(false);
		getContentPane().add(equipmenttxtAreaReport);

		// JButton to view equipment report
		JButton buttonCustomerReport = new JButton("Customer Report"); // formatting button
		buttonCustomerReport.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonCustomerReport.setBackground(new Color(255, 222, 173));
		buttonCustomerReport.addActionListener(new ActionListener() { // handles click events
			public void actionPerformed(ActionEvent e) { // actionPerformed method when clicked
				customerReport(); // calling customerReport() method from OutdoorGUI class
			}
		});
		buttonCustomerReport.setBounds(575, 197, 147, 21);// adds and sets where button goes in JFrame
		getContentPane().add(buttonCustomerReport);

		customertxtAreaReport = new JTextArea();// creates and formats text area for report
		customertxtAreaReport.setTabSize(4);
		customertxtAreaReport.setBounds(20, 266, 745, 498);
		customertxtAreaReport.setEditable(false);
		getContentPane().add(customertxtAreaReport);

	}

	// add equipment method
	public void addEquipment() {
		// prompts user to input equipment ID, rental type, and equipment name
		String equipmentIDString = JOptionPane.showInputDialog(this, "Enter equipment ID");
		String rentalType = JOptionPane.showInputDialog(this, "Enter rental type");
		String name = JOptionPane.showInputDialog(this, "Enter equipment name");

		// makes sure input fields are filled and not empty
		if (equipmentIDString != null && rentalType != null && name != null && !equipmentIDString.isEmpty()
				&& !rentalType.isEmpty() && !name.isEmpty()) {
			try {
				int equipmentID = Integer.parseInt(equipmentIDString); // changes equipment ID string to integer
				// validate equipment ID greater than 0, rental type length, and name length
				if (equipmentID > 0 && rentalType.length() <= 30 && name.length() <= 30) {

					if (rentalDriver.equipmentID(equipmentID)) {
						// adds the equipment
						rentalDriver.addEquipment(equipmentID, rentalType, name);
						// displays success method
						JOptionPane.showMessageDialog(this, "Rental item has been added successfully.", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						// displays error message if equipment ID is used
						JOptionPane.showMessageDialog(this,
								"Equipment ID is already used. Please choose a different one.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					// displays error message for invalid for equipment ID, rental type, and name
					JOptionPane.showMessageDialog(this,
							"Equipment ID must be above zero and rental & type must be less than 30 characters.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
				// displays error message for invalid equipment ID
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Equipment ID must be a positive number.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			// displays error message if any input field is empty
		} else {
			JOptionPane.showMessageDialog(this, "Invalid input, item not added.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// remove equipment method
	public void removeEquipment() {
		// prompts user to input rental ID
		String rentalIdMessage = JOptionPane.showInputDialog(this, "Enter rental ID");
		// makes sure input fields are filled and not empty
		if (rentalIdMessage != null && !rentalIdMessage.isEmpty()) {
			try {
				int rentalId = Integer.parseInt(rentalIdMessage); // changes rental ID string to integer
				if (rentalDriver.removeEquipment(rentalId)) { // checks if the equipment is successfully removed
					// displays success message if equipment is removed
					JOptionPane.showMessageDialog(this, "Rental item removed successfully.", "Success",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					// displays error message if equipment is not found
					JOptionPane.showMessageDialog(this, "Rental item is not found.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				// displays error message for invalid rental ID format
				JOptionPane.showMessageDialog(this, "Invalid rental ID. Please try again. ", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// rent equipment method
	public void rentEquipment() {
		try {
			// prompts user to input equipment ID and customer ID
			int equipmentID = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter equipment ID"));
			int customerID = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter customer ID"));

			// finds the rental attached to the equipment ID
			Rental rental = rentalDriver.findRentalByID(equipmentID);
			if (rental == null) {
				// displays error message if equipment does not exist
				JOptionPane.showMessageDialog(this, "Equipment with ID " + equipmentID + " does not exist.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			// finds the customer attached to the customer ID
			Customer customer = rentalDriver.findCustomerByID(customerID);
			if (customer == null) {
				// displays error message if customer does not exist
				JOptionPane.showMessageDialog(this, "Customer with ID " + customerID + " does not exist.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			// checks if equipment is already rented
			if (rental.getIsRented()) {
				// displays error message if equipment is already rented
				JOptionPane.showMessageDialog(this, "Equipment is already rented.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// rent the equipment to the customer
			rentalDriver.rentEquipment(equipmentID, customerID);
			// displays success message
			JOptionPane.showMessageDialog(this, "Equipment has been rented successfully.", "Success",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException ex) {
			// displays error message for invalid input format
			JOptionPane.showMessageDialog(this,
					"Invalid input. Please enter valid numbers for equipment ID and customer ID.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// return equipment method
	public void returnEquipment() {
		try {
			// prompts user to input equipment ID
			int equipmentID = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter equipment ID"));
			Rental rental = getRentalById(equipmentID); // find the rental corresponding to the equipment ID
			if (rental != null && rental.getIsRented()) { // checks if rental exists and if equipment is rented
				rental.returnItem(); // calls return item method and changes equipment to returned
				// displays success message after returning the equipment
				JOptionPane.showMessageDialog(this, "Equipment returned successfully.", "Success",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				// displays error message if equipment is not found or not rented
				JOptionPane.showMessageDialog(this, "Equipment is not found or not rented.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException ex) {
			// displays error message for invalid input format
			JOptionPane.showMessageDialog(this, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// gets the rental by equipmentID method
	public Rental getRentalById(int equipmentId) {
		LinkedList<Rental> rentalList = rentalDriver.getEquipmentList(); // gets the list of rentals
		for (Rental rental : rentalList) {
			if (rental.getEquipmentID().contains(equipmentId)) { // checks if the rental contains the equipment ID

				return rental; // return the corresponding rental object
			}
		}
		return null;
	}

	// method to view rentals in report
	public void viewRentals() {
		StringBuilder report = new StringBuilder("Equipment -\n"); // using StringBuilder to make report
		for (Rental rental : rentalDriver.getEquipmentList()) { // iterate through the list of rentals
			report.append(rental.toString()).append("\n"); // add rental details to report
		}
		// display report
		JOptionPane.showMessageDialog(this, report.toString(), "Rentals Report", JOptionPane.PLAIN_MESSAGE);
	}

	// add customer method
	public void addCustomer() {
		try {
			// prompts user to input customer details
			String name = JOptionPane.showInputDialog(null, "Enter customer name");
			int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter customer age"));
			String licenseId = JOptionPane.showInputDialog(null, "Enter customer license ID");
			String phoneNumber = JOptionPane.showInputDialog(null,
					"Enter customer phone number in format xxx-xxx-xxxx");

			// validate input data
			if (name.length() > 50) {
				// displays message if fails validation
				JOptionPane.showMessageDialog(null, "Customer name must be less than 50 characters.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (age <= 18 || age >= 100) {
				// displays message if fails validation
				JOptionPane.showMessageDialog(null, "Customer age must be between 18 and 100.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (licenseId.length() > 10) {
				// displays message if fails validation
				JOptionPane.showMessageDialog(null, "License ID must be less than 10 characters.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (phoneNumber.length() != 12) {
				// displays message if fails validation
				JOptionPane.showMessageDialog(null,
						"Phone number must be 12 characters. Please use format xxx-xxx-xxxx.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			// add the customer
			rentalDriver.addCustomer(name, age, licenseId, phoneNumber);
			// displays success message after adding customer
			JOptionPane.showMessageDialog(null, "Customer has been added successfully.", "Success",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException ex) {
			// displays error message for invalid input format
			JOptionPane.showMessageDialog(null, "Invalid input. Please try again. ", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// remove customer method
	public void removeCustomer() {
		// prompts user to input customer ID
		String customerIdMessage = JOptionPane.showInputDialog(null, "Enter customer ID");
		if (customerIdMessage != null && !customerIdMessage.isEmpty()) { // makes sure input is not empty
			try {
				int customerId = Integer.parseInt(customerIdMessage);
				if (rentalDriver.removeCustomer(customerId)) { // removes the customer
					// displays success message if customer is removed
					JOptionPane.showMessageDialog(null, "Customer removed successfully.", "Success",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					// displays error message if customer is not found
					JOptionPane.showMessageDialog(null, "Customer is not found.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				// displays error message for invalid customerID
				JOptionPane.showMessageDialog(null, "Invalid customer ID. Please try again.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// method to view customers in report
	public void viewCustomers() {
		StringBuilder report = new StringBuilder("Customers -\n"); // using StringBuilder to make report
		// loop that goes over all customers in map
		for (Map.Entry<Integer, List<Customer>> entry : rentalDriver.getRentalCustomerMap().entrySet()) {
			int equipmentId = entry.getKey(); // get key
			List<Customer> customers = entry.getValue(); // gets value
			// appends string of equipmentIDs and details
			report.append("Equipment ID: ").append(equipmentId).append("\n");
			for (Customer customer : customers) {
				report.append(customer.toString()).append("\n");
			}
		}
		JOptionPane.showMessageDialog(this, report.toString(), "Customers Report", JOptionPane.PLAIN_MESSAGE);
	}

	// generates and displays report for rented items
	private void rentalReport() {
		rentalDriver.displayReport(rentaltxtAreaReport); // displays the report in text area
		rentaltxtAreaReport.setText("");

		rentaltxtAreaReport.append("Rented Items Report\n");
		rentaltxtAreaReport.append(rentalDriver.createRentedItemsReport() + "\n\n");

	}

	// generates and displays report for equipment
	private void equipmentReport() {
		rentalDriver.displayReport(equipmenttxtAreaReport); // displays the report in text area
		equipmenttxtAreaReport.setText(""); // clears text area for new content

		equipmenttxtAreaReport.append("Equipment Report\n");
		equipmenttxtAreaReport.append(rentalDriver.createEquipmentReport() + "\n\n");

	}

	// generates and displays report for customers
	private void customerReport() {
		rentalDriver.displayReport(customertxtAreaReport); // displays the report in text area
		customertxtAreaReport.setText(""); // clears text area for new content

		customertxtAreaReport.append("Customer Report\n");
		customertxtAreaReport.append(rentalDriver.createCustomerReport() + "\n\n");

	}

	// main method
	public static void main(String[] args) {
		RentalDriver rentalDriver = new RentalDriver(); // creates new instance of RentalDriver to manage rentals.

		EventQueue.invokeLater(new Runnable() { // invokes the GUI creation
			public void run() {
				try {
					OutdoorGUI outdoorGUI = new OutdoorGUI(rentalDriver); // creates instance of OutdoorGUI & passes
																			// rentalDriver instance to it
					outdoorGUI.setVisible(true);
				} catch (Exception e) { // handles exceptions that occur during GUI creation and prints the stack trace.
					e.printStackTrace();
				}
			}
		});
	}
}