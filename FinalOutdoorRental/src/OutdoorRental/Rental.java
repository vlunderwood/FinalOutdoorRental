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
    private LinkedList<Customer>customerList;
   

    public Rental(String equipmentType, String name) {
    	this.equipmentID = new LinkedList<>(); 
        this.equipmentID.add(lastEquipmentID++); 
        this.equipmentType = equipmentType;
        this.equipmentName = name;
        this.isRented = false;
        this.customerID = -1;  
    }

    //getters & setters
    public LinkedList<Integer> getEquipmentID() {
        return equipmentID;
    }

    public String getName() {
        return equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public boolean isRented() {
        return isRented;
    }
    
    public int getEquipmentIDList() {
        return equipmentID.peek();
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCustomerID() {
        return customerID;
    }
    
    
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
          return equipmentID.getFirst(); //should i use peek instead?
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


    public Map<Integer, Queue<Integer>> getWaitlist() {
        return waitlist;
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
            Customer nextCustomer = findCustomerByID(nextCustomerID);
        }
    }

    public void addToWaitlist(int equipmentId, int customerId) {
        if (waitlist.containsKey(equipmentId)) {
            waitlist.get(equipmentId).offer(customerId);
        } else {
            Queue<Integer> newWaitlist = new LinkedList<>();
            newWaitlist.offer(customerId);
            waitlist.put(equipmentId, newWaitlist);
        }
    }
    
    public void removeFromWaitlist(int customerId) {
        for (Queue<Integer> queue : waitlist.values()) {
            queue.remove(customerId);
        }
    }
    
    public boolean hasWaitlist() {
        return !waitlist.isEmpty(); 
    }
    public Customer findCustomerByID(int customerID) {
        for (Customer customer : customerList) {
            if (customer.getCustomerID() == customerID) { 
                return customer;
            }
        }
        return null; 
    }
    public Customer getNextCustomerOnWaitlist(int equipmentId) {
        Queue<Integer> customerQueue = waitlist.get(equipmentId);
        if (customerQueue != null && !customerQueue.isEmpty()) {
            int nextCustomerId = customerQueue.poll();
            return findCustomerByID(nextCustomerId);
        } else {
            return null;
        }
    }
    
  
    @Override
    public String toString() {
        return "Equipment ID: " + equipmentID.peek()  + "   Name: " + equipmentName  + "   Equipment Type: " + equipmentType  + "   Rented: " + isRented;
    }
    
    public String generateRentalReport() {
        if (isRented) {
            return "Equipment ID: " + getEquipmentID() + ", Equipment Name: " + getName() + ", Customer ID: " + customerID;
        }
        return "";
    }
 
}