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
	private JTextArea rentaltxtAreaReport;
	private JTextArea equipmenttxtAreaReport;
	private JTextArea customertxtAreaReport;
	private JTextArea waitlisttxtAreaReport;
	private RentalDriver rentalDriver;
	

	public OutdoorGUI(RentalDriver rentalDriver) {
		this.rentalDriver = rentalDriver;

		initialize();
	}

	private void initialize() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(85, 107, 47));
		setBounds(100, 100, 804, 835);
		getContentPane().setLayout(null);

		outdoorRentalsTitle = new JTextField();
		outdoorRentalsTitle.setBackground(new Color(210, 105, 30));
		outdoorRentalsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		outdoorRentalsTitle.setFont(new Font("Lucida Sans", Font.PLAIN, 21));
		outdoorRentalsTitle.setText("Outdoor Rentals");
		outdoorRentalsTitle.setBounds(259, 10, 274, 45);
		getContentPane().add(outdoorRentalsTitle);
		outdoorRentalsTitle.setColumns(10);

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

		JButton buttonAddEquipment = new JButton("Add Equipment");
		buttonAddEquipment.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonAddEquipment.setBackground(new Color(255, 228, 181));
		buttonAddEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEquipmentItem();
			}
		});
		buttonAddEquipment.setBounds(61, 135, 149, 21);
		getContentPane().add(buttonAddEquipment);

		JButton buttonRemoveEquipment = new JButton("Remove Equipment");
		buttonRemoveEquipment.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonRemoveEquipment.setBackground(new Color(255, 228, 181));
		buttonRemoveEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeEquipmentItem();
			}
		});
		buttonRemoveEquipment.setBounds(61, 166, 149, 21);
		getContentPane().add(buttonRemoveEquipment);

		JButton buttonAddCustomer = new JButton("Add Customer");
		buttonAddCustomer.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonAddCustomer.setBackground(new Color(255, 228, 181));
		buttonAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomer();
			}
		});
		buttonAddCustomer.setBounds(327, 135, 147, 21);
		getContentPane().add(buttonAddCustomer);

		JButton buttonRemoveCustomer = new JButton("Remove Customer");
		buttonRemoveCustomer.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonRemoveCustomer.setBackground(new Color(255, 228, 181));
		buttonRemoveCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeCustomer();
			}
		});
		buttonRemoveCustomer.setBounds(327, 166, 147, 21);
		getContentPane().add(buttonRemoveCustomer);

		JButton buttonAddToWaitlist = new JButton("Add to Waitlist");
		buttonAddToWaitlist.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonAddToWaitlist.setBackground(new Color(255, 228, 181));
		buttonAddToWaitlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToWaitlist();
			}
		});
		buttonAddToWaitlist.setBounds(327, 197, 147, 21);
		getContentPane().add(buttonAddToWaitlist);

		JButton buttonRentEquipment = new JButton("Rent Equipment");
		buttonRentEquipment.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonRentEquipment.setBackground(new Color(255, 228, 181));
		buttonRentEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rentEquipment();
			}
		});
		buttonRentEquipment.setBounds(61, 197, 149, 21);
		getContentPane().add(buttonRentEquipment);
		
		JButton buttonReturnEquipment = new JButton("Return Equipment");
		buttonReturnEquipment.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonReturnEquipment.setBackground(new Color(255, 228, 181));
		buttonReturnEquipment.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        returnEquipment();
		    }
		});
		buttonReturnEquipment.setBounds(61, 226, 149, 21);
		getContentPane().add(buttonReturnEquipment);

		JButton buttonRentalReport = new JButton("Rental Report");
		buttonRentalReport.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonRentalReport.setBackground(new Color(255, 222, 173));
		buttonRentalReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rentalReport();
			}
		});
		buttonRentalReport.setBounds(575, 134, 147, 22);
		getContentPane().add(buttonRentalReport);

		rentaltxtAreaReport = new JTextArea();
		rentaltxtAreaReport.setTabSize(4);
		rentaltxtAreaReport.setBounds(20, 266, 745, 498);
		rentaltxtAreaReport.setEditable(false);
		getContentPane().add(rentaltxtAreaReport);
		
		JButton buttonEquipmentReport = new JButton("Equipment Report");
		buttonEquipmentReport.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonEquipmentReport.setBackground(new Color(255, 222, 173));
		buttonEquipmentReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equipmentReport();
			}
		});
		buttonEquipmentReport.setBounds(575, 166, 147, 21);
		getContentPane().add(buttonEquipmentReport);

		equipmenttxtAreaReport = new JTextArea();
		equipmenttxtAreaReport.setTabSize(4);
		equipmenttxtAreaReport.setBounds(20, 266, 745, 498);
		equipmenttxtAreaReport.setEditable(false);
		getContentPane().add(equipmenttxtAreaReport);

		JButton buttonCustomerReport = new JButton("Customer Report");
		buttonCustomerReport.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonCustomerReport.setBackground(new Color(255, 222, 173));
		buttonCustomerReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerReport();
			}
		});
		buttonCustomerReport.setBounds(575, 197, 147, 21);
		getContentPane().add(buttonCustomerReport);

		customertxtAreaReport = new JTextArea();
		customertxtAreaReport.setTabSize(4);
		customertxtAreaReport.setBounds(20, 266, 745, 498);
		customertxtAreaReport.setEditable(false);
		getContentPane().add(customertxtAreaReport);

		JButton buttonWaitlistReport = new JButton("Waitlist Report");
		buttonWaitlistReport.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonWaitlistReport.setBackground(new Color(255, 222, 173));
		buttonWaitlistReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				waitlistReport();
			}
		});
		buttonWaitlistReport.setBounds(575, 226, 147, 21);
		getContentPane().add(buttonWaitlistReport);

		waitlisttxtAreaReport = new JTextArea();
		waitlisttxtAreaReport.setTabSize(4);
		waitlisttxtAreaReport.setBounds(20, 266, 745, 498);
		waitlisttxtAreaReport.setEditable(false);
		getContentPane().add(waitlisttxtAreaReport);
		
		JButton buttonRemoveFromWaitlist = new JButton("Remove from Waitlist");
		buttonRemoveFromWaitlist.setFont(new Font("Lucida Sans", Font.PLAIN, 10));
		buttonRemoveFromWaitlist.setBackground(new Color(255, 228, 181));
		buttonRemoveFromWaitlist.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        removeFromWaitlist();
		    }
		});
		buttonRemoveFromWaitlist.setBounds(327, 228, 147, 21);
		getContentPane().add(buttonRemoveFromWaitlist);
	}
	
	private void addEquipmentItem() {
	    String equipmentIDString = JOptionPane.showInputDialog(this, "Enter equipment ID");
	    String rentalType = JOptionPane.showInputDialog(this, "Enter rental type");
	    String name = JOptionPane.showInputDialog(this, "Enter equipment name");

	    if (equipmentIDString != null && rentalType != null && name != null && !equipmentIDString.isEmpty() && !rentalType.isEmpty() && !name.isEmpty()) {
	        try {
	            int equipmentID = Integer.parseInt(equipmentIDString);
	            if (equipmentID > 0 && rentalType.length() <= 30 && name.length() <= 30) {
	                
	                if (rentalDriver.equipmentID(equipmentID)) {
	                    
	                    rentalDriver.addEquipment(equipmentID, rentalType, name);
	                    JOptionPane.showMessageDialog(this, "Rental item has been added successfully.", "Success",
	                            JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    
	                    JOptionPane.showMessageDialog(this, "Equipment ID is already used. Please choose a different one.", "Error",
	                            JOptionPane.ERROR_MESSAGE);
	                }
	            } else {
	                JOptionPane.showMessageDialog(this, "Equipment ID must be above zero and rental & type must be less than 30 characters.", "Error",
	                        JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "Equipment ID must be a positive number.", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Invalid input, item not added.", "Error",
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

	        Rental rental = rentalDriver.findRentalById(equipmentID);
	        if (rental == null) {
	            JOptionPane.showMessageDialog(this, "Equipment with ID " + equipmentID + " does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
	            return; 
	        }
	        Customer customer = rentalDriver.findCustomerById(customerID);
	        if (customer == null) {
	            JOptionPane.showMessageDialog(this, "Customer with ID " + customerID + " does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
	            return; 
	        }
	        if (rental.isRented()) {
	            JOptionPane.showMessageDialog(this, "Equipment is already rented.", "Error", JOptionPane.ERROR_MESSAGE);
	            return; 
	        }

	        rentalDriver.rentEquipment(equipmentID, customerID);
	        JOptionPane.showMessageDialog(this, "Equipment has been rented successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers for equipment ID and customer ID.", "Error", JOptionPane.ERROR_MESSAGE);
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
	            Rental rental = rentalDriver.findRentalById(equipmentId);
	            if (rental == null) {
	                JOptionPane.showMessageDialog(null, "Equipment with ID " + equipmentId + " does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
	                return; 
	            }

	            String customerIdMessage = JOptionPane.showInputDialog(null, "Enter customer ID");
	            if (customerIdMessage != null && !customerIdMessage.isEmpty()) {
	                try {
	                    int customerId = Integer.parseInt(customerIdMessage);
	                    Customer customer = rentalDriver.findCustomerById(customerId);
	                    if (customer == null) {
	                        JOptionPane.showMessageDialog(null, "Customer with ID " + customerId + " does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
	                        return; 
	                    }
	                    rentalDriver.addToWaitlist(equipmentId, customerId);
	                    JOptionPane.showMessageDialog(null, "Customer has been added to the waitlist successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	                    waitlistReport();
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Invalid customer ID. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Invalid customer ID. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Invalid equipment ID. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}

	private void removeFromWaitlist() {
	    String equipmentIdMessage = JOptionPane.showInputDialog(null, "Enter equipment ID");
	    if (equipmentIdMessage != null && !equipmentIdMessage.isEmpty()) {
	        try {
	            int equipmentId = Integer.parseInt(equipmentIdMessage);
	            Rental rental = rentalDriver.findRentalById(equipmentId);
	            if (rental == null) {
	                JOptionPane.showMessageDialog(null, "Equipment with ID " + equipmentId + " does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
	                return; 	            }

	            String customerIdMessage = JOptionPane.showInputDialog(null, "Enter customer ID");
	            if (customerIdMessage != null && !customerIdMessage.isEmpty()) {
	                try {
	                    int customerId = Integer.parseInt(customerIdMessage);
	                    Customer customer = rentalDriver.findCustomerById(customerId);
	                    if (customer == null) {
	                        JOptionPane.showMessageDialog(null, "Customer with ID " + customerId + " does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
	                        return; 
	                    }

	                    if (!rental.hasWaitlist()) {
	                        JOptionPane.showMessageDialog(null, "Equipment with ID " + equipmentId + " does not have a waitlist.", "Error", JOptionPane.ERROR_MESSAGE);
	                        return; 
	                    }
	                    if (!rental.removeFromWaitlist(equipmentId, customerId)) {
	                        JOptionPane.showMessageDialog(null, "Customer is not on the waitlist for this equipment.", "Error", JOptionPane.ERROR_MESSAGE);
	                    }
	                    if (!rental.removeFromWaitlist(equipmentId, customerId)) {
	                        JOptionPane.showMessageDialog(null, "Customer with ID " + customerId + " is not in the waitlist for equipment with ID " + equipmentId + ".", "Error", JOptionPane.ERROR_MESSAGE);
	                        return; 
	                    }

	                    JOptionPane.showMessageDialog(null, "Customer has been removed from the waitlist successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	                    waitlistReport();
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Invalid customer ID. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Invalid customer ID. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Invalid equipment ID. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}

	private Rental getRentalById(int equipmentId) { 
		LinkedList<Rental> rentalList = rentalDriver.getEquipmentList();
		for (Rental rental : rentalList) {
			if (rental.getEquipmentID().contains(equipmentId)) {
				
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
		rentalDriver.displayReport(rentaltxtAreaReport);
		rentaltxtAreaReport.setText("");

		rentaltxtAreaReport.append("Rented Items Report\n");
		rentaltxtAreaReport.append(rentalDriver.createRentedItemsReport() + "\n\n");

	}

	private void equipmentReport() {
		rentalDriver.displayReport(equipmenttxtAreaReport);
		equipmenttxtAreaReport.setText("");

		equipmenttxtAreaReport.append("Equipment Report\n");
		equipmenttxtAreaReport.append(rentalDriver.createEquipmentReport() + "\n\n");

	}

	private void customerReport() {
		rentalDriver.displayReport(customertxtAreaReport);
		customertxtAreaReport.setText("");

		customertxtAreaReport.append("Customer Report\n");
		customertxtAreaReport.append(rentalDriver.createCustomerReport() + "\n\n");

	}

	private void waitlistReport() {
		rentalDriver.displayReport(waitlisttxtAreaReport);
		waitlisttxtAreaReport.setText("");

		waitlisttxtAreaReport.append("Waitlist Report\n");
		waitlisttxtAreaReport.append(rentalDriver.createWaitlistReport() + "\n\n");

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