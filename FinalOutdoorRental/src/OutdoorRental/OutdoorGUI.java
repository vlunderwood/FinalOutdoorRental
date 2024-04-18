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
import java.util.Queue;

public class OutdoorGUI extends JFrame {

	private JTextField outdoorRentalsTitle;
	private JTextField rentalsSubTitle;
	private JTextField customerSubTitle;
	private JTextField reportSubTitle;
	private JTextArea txtAreaReport;
	private RentalDriver rentalDriver;

	public OutdoorGUI(RentalDriver rentalDriver) {
		this.rentalDriver = rentalDriver;
		initialize();
	}

	private void initialize() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(244, 164, 96));
		setBounds(100, 100, 804, 835);
		getContentPane().setLayout(null);

		outdoorRentalsTitle = new JTextField();
		outdoorRentalsTitle.setBackground(new Color(210, 105, 30));
		outdoorRentalsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		outdoorRentalsTitle.setFont(new Font("Lucida Sans", Font.PLAIN, 21));
		outdoorRentalsTitle.setText("Outdoor Rentals");
		outdoorRentalsTitle.setBounds(135, 10, 199, 45);
		getContentPane().add(outdoorRentalsTitle);
		outdoorRentalsTitle.setColumns(10);

		rentalsSubTitle = new JTextField();
		rentalsSubTitle.setBackground(new Color(255, 0, 0));
		rentalsSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		rentalsSubTitle.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		rentalsSubTitle.setText("Rentals");
		rentalsSubTitle.setBounds(20, 78, 115, 35);
		getContentPane().add(rentalsSubTitle);
		rentalsSubTitle.setColumns(10);

		customerSubTitle = new JTextField();
		customerSubTitle.setBackground(new Color(255, 0, 0));
		customerSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		customerSubTitle.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		customerSubTitle.setText("Customers");
		customerSubTitle.setBounds(162, 78, 115, 35);
		getContentPane().add(customerSubTitle);
		customerSubTitle.setColumns(10);

		reportSubTitle = new JTextField();
		reportSubTitle.setBackground(new Color(255, 0, 0));
		reportSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		reportSubTitle.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		reportSubTitle.setText("Reports");
		reportSubTitle.setBounds(298, 78, 115, 35);
		getContentPane().add(reportSubTitle);
		reportSubTitle.setColumns(10);

		JButton buttonAddEquipment = new JButton("Add Equipment");
		buttonAddEquipment.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonAddEquipment.setBackground(new Color(204, 153, 51));
		buttonAddEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEquipmentItem();
			}
		});
		buttonAddEquipment.setBounds(10, 138, 115, 21);
		getContentPane().add(buttonAddEquipment);

		JButton buttonRemoveEquipment = new JButton("Remove Equipment");
		buttonRemoveEquipment.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonRemoveEquipment.setBackground(new Color(204, 153, 51));
		buttonRemoveEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeEquipmentItem();
			}
		});
		buttonRemoveEquipment.setBounds(10, 166, 123, 21);
		getContentPane().add(buttonRemoveEquipment);

		JButton buttonAddCustomer = new JButton("Add Customer");
		buttonAddCustomer.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonAddCustomer.setBackground(new Color(204, 153, 51));
		buttonAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomer();
			}
		});
		buttonAddCustomer.setBounds(154, 138, 123, 21);
		getContentPane().add(buttonAddCustomer);

		JButton buttonRemoveCustomer = new JButton("Remove Customer");
		buttonRemoveCustomer.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonRemoveCustomer.setBackground(new Color(204, 153, 51));
		buttonRemoveCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeCustomer();
			}
		});
		buttonRemoveCustomer.setBounds(145, 166, 132, 21);
		getContentPane().add(buttonRemoveCustomer);

		JButton buttonAddToWaitlist = new JButton("Add to Waitlist");
		buttonAddToWaitlist.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonAddToWaitlist.setBackground(new Color(204, 153, 51));
		buttonAddToWaitlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToWaitlist();
			}
		});
		buttonAddToWaitlist.setBounds(154, 195, 123, 21);
		getContentPane().add(buttonAddToWaitlist);

		JButton buttonRentEquipment = new JButton("Rent Equipment");
		buttonRentEquipment.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonRentEquipment.setBackground(new Color(204, 153, 51));
		buttonRentEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rentEquipment();
			}
		});
		buttonRentEquipment.setBounds(12, 195, 123, 21);
		getContentPane().add(buttonRentEquipment);
		
		JButton buttonReturnEquipment = new JButton("Return Equipment");
		buttonReturnEquipment.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonReturnEquipment.setBackground(new Color(204, 153, 51));
		buttonReturnEquipment.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        returnEquipment();
		    }
		});
		buttonReturnEquipment.setBounds(10, 226, 140, 21);
		getContentPane().add(buttonReturnEquipment);

		JButton buttonRentalReport = new JButton("Rental Report");
		buttonRentalReport.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonRentalReport.setBackground(new Color(255, 222, 173));
		buttonRentalReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rentalReport();
			}
		});
		buttonRentalReport.setBounds(297, 141, 140, 18);
		getContentPane().add(buttonRentalReport);

		txtAreaReport = new JTextArea();
		txtAreaReport.setTabSize(4);
		txtAreaReport.setBounds(20, 266, 565, 498);
		txtAreaReport.setEditable(false);
		getContentPane().add(txtAreaReport);

		JButton buttonEquipmentReport = new JButton("Equipment Report");
		buttonEquipmentReport.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonEquipmentReport.setBackground(new Color(255, 222, 173));
		buttonEquipmentReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equipmentReport();
			}
		});
		buttonEquipmentReport.setBounds(298, 166, 140, 21);
		getContentPane().add(buttonEquipmentReport);

		txtAreaReport = new JTextArea();
		txtAreaReport.setTabSize(4);
		txtAreaReport.setBounds(20, 266, 509, 498);
		txtAreaReport.setEditable(false);
		getContentPane().add(txtAreaReport);

		JButton buttonCustomerReport = new JButton("Customer Report");
		buttonCustomerReport.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonCustomerReport.setBackground(new Color(255, 222, 173));
		buttonCustomerReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerReport();
			}
		});
		buttonCustomerReport.setBounds(297, 197, 140, 21);
		getContentPane().add(buttonCustomerReport);

		txtAreaReport = new JTextArea();
		txtAreaReport.setTabSize(4);
		txtAreaReport.setBounds(20, 266, 509, 429);
		txtAreaReport.setEditable(false);
		getContentPane().add(txtAreaReport);

		JButton buttonWaitlistReport = new JButton("Waitlist Report");
		buttonWaitlistReport.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonWaitlistReport.setBackground(new Color(255, 222, 173));
		buttonWaitlistReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				waitlistReport();
			}
		});
		buttonWaitlistReport.setBounds(298, 226, 140, 21);
		getContentPane().add(buttonWaitlistReport);

		txtAreaReport = new JTextArea();
		txtAreaReport.setTabSize(4);
		txtAreaReport.setBounds(20, 266, 509, 429);
		txtAreaReport.setEditable(false);
		getContentPane().add(txtAreaReport);
		
		JButton buttonRemoveFromWaitlist = new JButton("Remove from Waitlist");
		buttonRemoveFromWaitlist.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonRemoveFromWaitlist.setBackground(new Color(204, 153, 51));
		buttonRemoveFromWaitlist.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        removeFromWaitlist();
		    }
		});
		buttonRemoveFromWaitlist.setBounds(145, 226, 140, 21);
		getContentPane().add(buttonRemoveFromWaitlist);
	}

	private void addEquipmentItem() {
		String rentalType = JOptionPane.showInputDialog(this, "Enter rental type");
		String name = JOptionPane.showInputDialog(this, "Enter equipment name");

		if (rentalType != null && name != null && !rentalType.isEmpty() && !name.isEmpty()) {
			if (rentalType.length() <= 30 && name.length() <= 30) {
				rentalDriver.addEquipment(rentalType, name);
				JOptionPane.showMessageDialog(this, "Rental item has been added successfully.", "Success",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Rental name must be less than 30 characters.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Rental item not added because of invalid input.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void removeEquipmentItem() {
		String rentalIdMessage = JOptionPane.showInputDialog(this, "Enter rental ID");
		if (rentalIdMessage != null && !rentalIdMessage.isEmpty()) {
			try {
				int rentalId = Integer.parseInt(rentalIdMessage);
				if (rentalDriver.removeEquipment(rentalId)) {
					JOptionPane.showMessageDialog(this, "Rental item removed successfully.", "Success",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "Rental item is not found.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Invalid rental ID. Please try again. ", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void addCustomer() {
		try {
			String name = JOptionPane.showInputDialog(null, "Enter customer name");
			int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter customer age"));
			String licenseId = JOptionPane.showInputDialog(null, "Enter customer license ID");
			String phoneNumber = JOptionPane.showInputDialog(null, "Enter customer phone number in format xxx-xxx-xxxx");
			if (name.length() > 50) {
				JOptionPane.showMessageDialog(null, "Customer name must be less than 50 characters.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (age <= 18 || age >= 100) {
				JOptionPane.showMessageDialog(null, "Customer age must be between 18 and 100.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (licenseId.length() > 10) {
				JOptionPane.showMessageDialog(null, "License ID must be less than 10 characters.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (phoneNumber.length() != 12) {
				JOptionPane.showMessageDialog(null,
						"Phone number must be 12 characters. Please use format xxx-xxx-xxxx.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			rentalDriver.addCustomer(name, age, licenseId, phoneNumber);
			JOptionPane.showMessageDialog(null, "Customer has been added successfully.", "Success",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Invalid input. Please try again. ", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void removeCustomer() {
		String customerIdMessage = JOptionPane.showInputDialog(null, "Enter customer ID");
		if (customerIdMessage != null && !customerIdMessage.isEmpty()) {
			try {
				int customerId = Integer.parseInt(customerIdMessage);
				if (rentalDriver.removeCustomer(customerId)) {
					JOptionPane.showMessageDialog(null, "Customer removed successfully.", "Success",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Customer is not found.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Invalid customer ID. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void rentEquipment() {
		try {
			int equipmentID = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter equipment ID"));
			int customerID = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter customer ID"));
			rentalDriver.rentEquipment(equipmentID, customerID);
			JOptionPane.showMessageDialog(this, "Equipment has been rented successfully.", "Success",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void returnEquipment() {
		try {
			int equipmentID = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter equipment ID"));
			Rental rental = getRentalById(equipmentID);
			if (rental != null && rental.isRented()) {
				rental.returnItem();

				if (rental.hasWaitlist()) {
					JOptionPane.showMessageDialog(this, "Item has a waitlist. Please notify the next customer in line.", "Success",
							JOptionPane.INFORMATION_MESSAGE);
				}

				JOptionPane.showMessageDialog(this, "Equipment returned successfully.", "Success",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Equipment is not found or not rented.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void addToWaitlist() {
		String equipmentIdMessage = JOptionPane.showInputDialog(null, "Enter equipment ID");
		if (equipmentIdMessage != null && !equipmentIdMessage.isEmpty()) {
			try {
				int equipmentId = Integer.parseInt(equipmentIdMessage);
				String customerIdMessage = JOptionPane.showInputDialog(null, "Enter customer ID");
				if (customerIdMessage != null && !customerIdMessage.isEmpty()) {
					int customerId = Integer.parseInt(customerIdMessage);
					rentalDriver.addToWaitlist(equipmentId, customerId);
					JOptionPane.showMessageDialog(null, "Customer has been added to the waitlist successfully.", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					waitlistReport();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid customer ID. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Invalid rental ID. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void removeFromWaitlist() {
		String equipmentIdMessage = JOptionPane.showInputDialog(null, "Enter equipment ID");
		if (equipmentIdMessage != null && !equipmentIdMessage.isEmpty()) {
			try {
				int equipmentId = Integer.parseInt(equipmentIdMessage);
				String customerIdMessage = JOptionPane.showInputDialog(null, "Enter customer ID");
				if (customerIdMessage != null && !customerIdMessage.isEmpty()) {
					int customerId = Integer.parseInt(customerIdMessage);
					
					rentalDriver.removeFromWaitlist(equipmentId, customerId);
					JOptionPane.showMessageDialog(null, "Customer has been removed from waitlist successfully.", "Success",
							JOptionPane.INFORMATION_MESSAGE);
				
					waitlistReport();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid customer ID. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private Rental getRentalById(int equipmentId) { // this was set as rentalID and changed it to equipmentID
		LinkedList<Rental> rentalList = rentalDriver.getEquipmentList();
		for (Rental rental : rentalList) {
			if (rental.getEquipmentID().peek() == equipmentId) {
				return rental;
			}
		}
		return null;
	}

	private void viewRentals() {
		StringBuilder report = new StringBuilder("Equipment -\n");
		for (Rental rental : rentalDriver.getEquipmentList()) {
			report.append(rental.toString()).append("\n");
		}
		JOptionPane.showMessageDialog(this, report.toString(), "Rentals Report", JOptionPane.PLAIN_MESSAGE);
	}

	private void viewCustomers() {
		StringBuilder report = new StringBuilder("Customers -\n");
		for (Map.Entry<Integer, List<Customer>> entry : rentalDriver.getRentalCustomerMap().entrySet()) {
			int equipmentId = entry.getKey();
			List<Customer> customers = entry.getValue();
			report.append("Equipment ID: ").append(equipmentId).append("\n");
			for (Customer customer : customers) {
				report.append(customer.toString()).append("\n");
			}
		}
		JOptionPane.showMessageDialog(this, report.toString(), "Customers Report", JOptionPane.PLAIN_MESSAGE);
	}

	private void viewWaitlist() {
		StringBuilder report = new StringBuilder("Waitlist -\n");
		for (Rental rental : rentalDriver.getEquipmentList()) {
			Integer equipmentId = rental.getEquipmentID().peek();
			Queue<Integer> customerIdsQueue = rental.getWaitlist().get(equipmentId);
			if (customerIdsQueue != null && !customerIdsQueue.isEmpty()) {
				report.append("Equipment ID: ").append(equipmentId).append("\n");
				report.append("Customers:\n");
				for (Integer customerId : customerIdsQueue) {
					Customer customer = Customer.getCustomerByID(customerId);
					if (customer != null) {
						report.append("Customer ID: ").append(customerId).append(", ");
						report.append(customer.toString()).append("\n");
					}
				}
				report.append("\n");
			}
		}
		JOptionPane.showMessageDialog(this, report.toString(), "Waitlist Report", JOptionPane.PLAIN_MESSAGE);
	}

	private void rentalReport() {
		rentalDriver.displayReport(txtAreaReport);
		txtAreaReport.setText("");

		txtAreaReport.append("Rented Items Report\n");
		txtAreaReport.append(rentalDriver.createRentedItemsReport() + "\n\n");

	}

	private void equipmentReport() {
		rentalDriver.displayReport(txtAreaReport);
		txtAreaReport.setText("");

		txtAreaReport.append("Equipment Report\n");
		txtAreaReport.append(rentalDriver.createEquipmentReport() + "\n\n");

	}

	private void customerReport() {
		rentalDriver.displayReport(txtAreaReport);
		txtAreaReport.setText("");

		txtAreaReport.append("Customer Report\n");
		txtAreaReport.append(rentalDriver.createCustomerReport() + "\n\n");

	}

	private void waitlistReport() {
		rentalDriver.displayReport(txtAreaReport);
		txtAreaReport.setText("");

		txtAreaReport.append("Waitlist Report\n");
		txtAreaReport.append(rentalDriver.createWaitlistReport() + "\n\n");

	}

	public static void main(String[] args) {
		RentalDriver rentalDriver = new RentalDriver();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutdoorGUI outdoorGUI = new OutdoorGUI(rentalDriver);
					outdoorGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}