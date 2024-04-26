package OutdoorRental;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.swing.JOptionPane;

public class Rental {

	private static int lastEquipmentID = 0;
	private LinkedList<Integer> equipmentID;
	private String equipmentType;
	private String equipmentName;
	private boolean isRented;
	private Map<Integer, Queue<Integer>> waitlist = new HashMap<>();
	private int customerID;


	public Rental(String equipmentType, String equipmentName) {
		this.equipmentID = new LinkedList<>();
		this.equipmentType = equipmentType;
		this.equipmentName = equipmentName;
		this.isRented = false;
		this.customerID = -1;
	}

	// getters 
	public static int getLastEquipmentID() {
		return lastEquipmentID;
	}

	public LinkedList<Integer> getEquipmentID() {
		return equipmentID;
	}

	public String getEquipmentName() {
		return equipmentName;
	}
	public String getEquipmentType() {
		return equipmentType;
	}
	
	public int getEquipmentIDList() {	
		return equipmentID.peek();
	}
	
	public Map<Integer, Queue<Integer>> getWaitlist() {
		return waitlist;
	}
	
	public boolean getIsRented() {
	    return isRented;
	}
	
	//setters
	public static void setLastEquipmentID(int lastEquipmentID) {
		Rental.lastEquipmentID = lastEquipmentID;
	}
	
	public void setEquipmentID(int newEquipmentID) {
	    this.equipmentID.add(newEquipmentID); 
	    lastEquipmentID++; 
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	
	public void setWaitlist(Map<Integer, Queue<Integer>> waitlist) {
		this.waitlist = waitlist;
	}

	public void setIsRented(boolean isRented) {
		this.isRented = isRented;
	}


	//methods for LinkedList
	public boolean isFull() {
		return false;
	}

	public boolean isEmpty() {
		return equipmentID.isEmpty();
	}

	public int size() {
		return equipmentID.size();
	}

	public int peek() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue based Linked list is empty");
		}
		return equipmentID.peek(); 
	}

	public int dequeue() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue based Linked list is empty");
		}
		return equipmentID.removeFirst();
	}

	public void enqueue(int item) {
		equipmentID.addLast(item);
		
	}
	
	public boolean rentOut(int customerID) {
		if (!isRented) {
			isRented = true;
			this.customerID = customerID;
			return true;
		} else {
			return false;
		}
	}

	public void returnItem() {
		isRented = false;
		Queue<Integer> customerQueue = waitlist.get(getEquipmentID().peek());
		if (customerQueue != null && !customerQueue.isEmpty()) {
			int nextCustomerID = customerQueue.poll();
			Customer nextCustomer = Customer.getCustomerByID(nextCustomerID); ;
		}
	}
	
//Hashmap methods
	public void addToWaitlist(int equipmentId, int customerId) {
		if (waitlist.containsKey(equipmentId)) {
			waitlist.get(equipmentId).offer(customerId);
		} else {
			Queue<Integer> newWaitlist = new LinkedList<>();
			newWaitlist.offer(customerId);
			waitlist.put(equipmentId, newWaitlist);
		}
	}
	
	public boolean removeFromWaitlist(int equipmentId, int customerId) {
	    Queue<Integer> queue = waitlist.get(equipmentId);
	    if (queue != null) {
	        queue.remove(customerId);
	    } else {
	        System.out.println("Equipment ID not found or customer is not on the waitlist for this equipment.");
	    }
	    return true; 
	}
	public boolean hasWaitlist() {
		return !waitlist.isEmpty();
	}

	

	public Customer getNextCustomerOnWaitlist(int equipmentId) {
		Queue<Integer> customerQueue = waitlist.get(equipmentId);
		if (customerQueue != null && !customerQueue.isEmpty()) {
			int nextCustomerID = customerQueue.poll();
			return Customer.getCustomerByID(nextCustomerID); 
		} else {
			return null;
		}
	}
	
	public int getWaitlistCount() {
        return waitlist.size();
    }

    public boolean waitlistContainsKey(int customerID) {
        return waitlist.containsKey(customerID);
    }

	//print methods
	@Override
	public String toString() {
		return "Equipment ID: " + equipmentID.peek() + "   Name: " + equipmentName + "   Equipment Type: "
				+ equipmentType + "   Rented: " + isRented;
	}
	
	public String generateRentalReport() {
		if (isRented) {
			return "Equipment ID: " + getEquipmentID() + ", Equipment Name: " + getEquipmentName() +  ", Equipment Type: " + getEquipmentType() +", Customer ID: "
					+ customerID;
		}
		return "";
	}

}