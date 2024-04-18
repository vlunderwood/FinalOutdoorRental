package OutdoorRental;


import java.util.HashMap;
import java.util.Map;

public class Customer {
    private static int lastCustomerID = 0;
    private int customerID;
    private String customerName;
    private int age;
    private String licenseId;
    private String phoneNumber;
    private static Map<Integer, Customer> customerMap = new HashMap<>();

    public Customer(String name, int age, String licenseId, String phoneNumber) {
        this.customerID = ++lastCustomerID;
        this.customerName = name;
        this.age = age;
        this.licenseId = licenseId;
        this.phoneNumber = phoneNumber;
        customerMap.put(customerID, this);
    }
    
    //getters & setters
    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
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
    

    public static Customer getCustomerByID(int customerID) {
        return customerMap.get(customerID);
    }
    
    @Override
    public String toString() {
        return "Customer ID: " + customerID + ", Name: " + customerName + ", Age: " + age + ", License ID: " + licenseId
                + ", Phone Number: " + phoneNumber;
    }
}