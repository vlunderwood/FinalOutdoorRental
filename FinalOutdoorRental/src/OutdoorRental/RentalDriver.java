package OutdoorRental;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JTextArea;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class RentalDriver {

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

        Rental kayak2 = new Rental("Double Kayak", "Pelican2");
        equipmentList.add(kayak2);

        Rental bike1 = new Rental("Mountain Bike", "Giant");
        equipmentList.add(bike1);

        Rental bike2 = new Rental("Mountain Bike", "Trek");
        equipmentList.add(bike2);

        Rental tent = new Rental("Tent", "Coleman");
        equipmentList.add(tent);

        

        kayak1.rentOut(1);
        bike1.rentOut(5);
        tent.rentOut(1);
        
        kayak1.addToWaitlist(1,2);
        kayak1.addToWaitlist(1,3);
        
    }

    private void populateCustomerList() {
        customerList.add(new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234"));
        customerList.add(new Customer("Brandy Brown", 29, "YY456AA34", "641-555-2345"));
        customerList.add(new Customer("Thomas Underwood", 27, "YY789AA56", "641-555-4321"));
  
    }	


    public void addEquipment(String equipmentType, String equipmentName) {
        Rental equipment = new Rental(equipmentType, equipmentName); 
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
            rental.removeFromWaitlist(customerId);
        } else {
            System.out.println("Equipment is not found.");
        }
    }
    private Rental findRentalById(int equipmentId) {
        for (Rental rental : equipmentList) {
            if (rental.getEquipmentID().peek() == equipmentId) {
                return rental;
            }
        }
        return null;
    }
    
    private Customer findCustomerById(int customerId) {
        for (Customer customer : customerList) {
            if (customer.getCustomerID() == customerId) {
                return customer;
            }
        }
        return null;
    }
    
    
    
    public void displayReport(JTextArea txtAreaReport) {
        StringBuilder report = new StringBuilder();
       report.append("Rental Report:\n").append(createEquipmentReport()).append("\n");
       report.append("Customer Report:\n").append(createCustomerReport()).append("\n");
       report.append("Waitlist Report:\n").append(createWaitlistReport()).append("\n");
       txtAreaReport.setText(report.toString()); 
   
   }
    
    public String createRentedItemsReport() {		//should this be added to display reports instead?
        StringBuilder report = new StringBuilder("Rentals -\n");
        for (Rental rental : equipmentList) {
            if (rental.isRented()) {
                //report.append(rental.generateRentalReport()).append("\n");
            	report.append(rental.toString()).append("\n");
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


//Eclipse, "WindowBuilder User Guide." 2024, https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.wb.doc.user%2Fhtml%2Findex.html

//Vogella, "Eclipse WindowBuilder - Creating user interfaces - Tutorial." 2024, https://www.vogella.com/tutorials/EclipseWindowBuilder/article.html