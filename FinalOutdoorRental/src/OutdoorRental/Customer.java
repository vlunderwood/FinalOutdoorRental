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

    public Customer(String customerName, int age, String licenseId, String phoneNumber) {
        this.customerID = ++lastCustomerID;
        this.customerName = customerName;
        this.age = age;
        this.licenseId = licenseId;
        this.phoneNumber = phoneNumber;
        customerMap.put(customerID, this);
    }
    
    
  //getters & setters
    public static int getLastCustomerID() {
		return lastCustomerID;
	}

	public static void setLastCustomerID(int lastCustomerID) {
		Customer.lastCustomerID = lastCustomerID;
	}

    public int getCustomerID() {
        return customerID;
    }
    
    public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
    
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getAge() {
        return age;
    }
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getLicenseId() {
        return licenseId;
    }
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
    
	public static Map<Integer, Customer> getCustomerMap() {
		return customerMap;
	}

	public static void setCustomerMap(Map<Integer, Customer> customerMap) {
		Customer.customerMap = customerMap;
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