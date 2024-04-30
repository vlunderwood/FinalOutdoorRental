package OutdoorRental;

import java.util.LinkedList;

public class Rental {
	// variables
	private static int lastEquipmentID = 0;
	private LinkedList<Integer> equipmentID; // LinkedList for equipment IDs
	private String equipmentType;
	private String equipmentName;
	private boolean isRented;
	private int customerID;

	// constructor
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

	public boolean getIsRented() {
		return isRented;
	}

	// setters
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

	public void setIsRented(boolean isRented) {
		this.isRented = isRented;
	}

	// methods for LinkedList

	// isFull method
	public boolean isFull() {
		return false;
	}

	// isEmpty method
	public boolean isEmpty() {
		return equipmentID.isEmpty();
	}

	// size of LinkedList
	public int size() {
		return equipmentID.size();
	}

	// get peek of LinkedList
	public int peek() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue based Linked list is empty");
		}
		return equipmentID.peek();
	}

	// remove equipmentID
	public int dequeue() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue based Linked list is empty");
		}
		return equipmentID.removeFirst();
	}

	// add equipmentID
	public void enqueue(int item) {
		equipmentID.addLast(item);

	}

	// rents out equipment - changes isRented to true
	public boolean rentOutItem(int customerID) {
		if (!isRented) {
			isRented = true;
			this.customerID = customerID;
			return true;
		} else {
			return false;
		}
	}

	// returns equipment - changes isRented to false
	public void returnItem() {
		isRented = false;
	}

	// String print methods
	@Override
	public String toString() {
		return "Equipment ID: " + equipmentID.peek() + "   Name: " + equipmentName + "   Equipment Type: "
				+ equipmentType + "   Rented: " + isRented;
	}

	public String generateRentalReport() {
		if (isRented) {
			return "Equipment ID: " + getEquipmentID() + ", Equipment Name: " + getEquipmentName()
					+ ", Equipment Type: " + getEquipmentType() + ", Customer ID: " + customerID;
		}
		return "";
	}

}