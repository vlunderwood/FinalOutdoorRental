package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import OutdoorRental.Rental;
import OutdoorRental.RentalDriver;
import OutdoorRental.Customer;
import OutdoorRental.QueueEmptyException;

class OutdoorTests {

	@Test
	void testCreateList() {
		// ARRANGE
		LinkedList<Integer> myList = new LinkedList<>();
		boolean actual;
		// ACT
		actual = myList.isEmpty();
		// ASSERT
		assertTrue(actual);
	}

	@Test
	void testIsEmptyTrue() {
		// ARRANGE
		LinkedList<Integer> myList = new LinkedList<>();
		boolean actual;
		// ACT
		actual = myList.isEmpty();
		// ASSERT
		assertTrue(actual);
	}

	@Test
	void testIsEmptyFalse() {
		// ARRANGE
		Rental rental = new Rental("Kayak", "Pelican");
		int item = 13; // equipment ID
		// ACT
		rental.enqueue(item);
		boolean actual = rental.isEmpty();
		// ASSERT
		assertFalse(actual);
	}

	@Test
	void testEnqueue() throws QueueEmptyException {
		// ARRANGE
		Rental rental = new Rental("Kayak", "Pelican");
		int expected = 1;
		// ACT
		rental.enqueue(expected);
		int actual = rental.peek();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testEnqueueDequeue() throws QueueEmptyException {
		// ARRANGE
		Rental rental = new Rental("Kayak", "Pelican");
		int expected = 2;
		// ACT
		rental.enqueue(1);
		rental.enqueue(2);
		// rental.enqueue(expected + 2);
		rental.dequeue();

		int actual = rental.peek();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testDequeue() throws QueueEmptyException {
		// ARRANGE
		Rental rental = new Rental("Kayak", "Pelican");
		int expected = 1;
		int actual;
		rental.enqueue(1);

		// ACT
		actual = rental.dequeue();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testDequeueEmptyQueue() {
		// ARRANGE
		Rental rental = new Rental("Kayak", "Pelican");

		// ACT & ASSERT
		assertThrows(QueueEmptyException.class, () -> rental.dequeue());
	}

	@Test
	void testSizeZero() {
		// ARRANGE
		Rental rental = new Rental("Kayak", "Pelican");
		int actual, expected;
		expected = 0;
		// ACT
		actual = rental.size();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testSizeNonZero() throws QueueEmptyException {
		// ARRANGE
		Rental rental = new Rental("Kayak", "Pelican");

		int actual, expected;
		expected = 2;
		// ACT
		rental.enqueue(expected + 1);
		rental.enqueue(expected + 2);
		rental.enqueue(expected + 3);
		rental.dequeue();
		actual = rental.size();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testPeek() throws QueueEmptyException {
		// ARRANGE
		Rental rental = new Rental("Kayak", "Pelican");

		int actual, expected;
		expected = 1;
		// ACT
		rental.enqueue(expected);

		actual = rental.peek();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testPeekEmptyQueue() {
		// ARRANGE
		Rental rental = new Rental("Kayak", "Pelican");
		// ACT
		// ASSERT
		assertThrows(QueueEmptyException.class, () -> rental.peek());
	}

	@Test
	public void testToString() {
		// ARRANGE
		Rental rental = new Rental("Kayak", "Pelican");
		rental.setEquipmentID(1);
		rental.setIsRented(true);

		// ACT
		String result = rental.toString();

		// ASSERT
		assertEquals("Equipment ID: 1   Name: Pelican   Equipment Type: Kayak   Rented: true", result);
	}

	@Test
	public void testRentalReport() {
		// ARRANGE
		Rental rental = new Rental("Kayak", "Pelican");
		rental.setEquipmentID(1);
		rental.setIsRented(true);

		// ACT
		String result = rental.generateRentalReport();

		// ASSERT
		assertEquals("Equipment ID: [1], Equipment Name: Pelican, Equipment Type: Kayak, Customer ID: -1", result);
	}

	/*
	 * @Test void testPrintQueueEmptyQueue() { // ARRANGE Rental rental = new
	 * Rental("Kayak", "Pelican"); // ACT // ASSERT
	 * assertThrows(QueueEmptyException.class, () -> rental.toString()); }
	 * 
	 * @Test void testPrintQueue() throws QueueEmptyException { // ARRANGE Rental
	 * rental = new Rental("Kayak", "Pelican");
	 * 
	 * int actual, expected; expected = 1; // ACT rental.enqueue(expected + 1);
	 * rental.enqueue(expected + 2); actual = rental.toString(); // ASSERT
	 * assertEquals(expected, actual); }
	 */
	@Test
	public void testAddCustomer() {
		// ARRANGE
		Customer customer = new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234");
		// ACT
		Customer.addCustomer(customer);
		// ASSERT
		assertTrue(Customer.containsKey(customer.getCustomerID()));
	}

	@Test
	public void testRemoveCustomer() {
		// ARRANGE
		Customer customer = new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234");
		// ACT
		Customer.addCustomer(customer);
		assertNotNull(Customer.removeCustomer(customer.getCustomerID()));
		// ASSERT
		assertFalse(Customer.containsKey(customer.getCustomerID()));
	}

	@Test
	public void testGetCount() {
		// ARRANGE
		Customer customer1 = new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234");
		Customer customer2 = new Customer("Brandy Brown", 29, "YY456AA34", "641-555-2345");
		// ACT
		Customer.addCustomer(customer1);
		Customer.addCustomer(customer2);
		// ASSERT
		assertEquals(2, Customer.getCount());
	}

	@Test
	public void testContainsKey() {
		// ARRANGE
		Customer customer = new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234");
		// ACT
		Customer.addCustomer(customer);
		// ASSERT
		assertTrue(Customer.containsKey(customer.getCustomerID()));
		assertFalse(Customer.containsKey(999));

	}

	@Test
	public void hashMapBasicTest() {

		Map<Integer, Customer> customerMap = new HashMap<>();

		assertTrue(customerMap.isEmpty());
		assertEquals(0, customerMap.size());
		assertFalse(customerMap.containsKey(1));
		assertNotNull(customerMap.toString());

		assertNull(customerMap.put(1, new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234")));

		assertEquals(1, customerMap.size());

		assertEquals("Leslie Hill", customerMap.get(1).getCustomerName());

		assertEquals(1, customerMap.size());

		assertEquals("Leslie Hill", customerMap.remove(1).getCustomerName());

		assertEquals(0, customerMap.size());

		customerMap.put(1, new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234"));
		customerMap.put(2, new Customer("Brandy Brown", 29, "YY456AA34", "641-555-2345"));
		customerMap.put(3, new Customer("Thomas Underwood", 27, "YY789AA56", "641-555-4321"));

		assertEquals(3, customerMap.size());

		assertEquals("Leslie Hill", customerMap.get(1).getCustomerName());
		assertEquals("Brandy Brown", customerMap.get(2).getCustomerName());
		assertEquals("Thomas Underwood", customerMap.get(3).getCustomerName());

		Iterator<Integer> iter = customerMap.keySet().iterator();
		int count = 0;
		while (iter.hasNext()) {
			int key = iter.next();
			if (!customerMap.containsKey(key)) {
				throw new AssertionError("Unknown element in map with key " + key);
			}
			count++;
		}
		assertEquals(3, count);

		iter = customerMap.keySet().iterator();
		while (iter.hasNext()) {
			iter.next();
			iter.remove();
		}
		assertEquals(0, customerMap.size());

		customerMap.put(1, new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234"));
		customerMap.put(2, new Customer("Brandy Brown", 29, "YY456AA34", "641-555-2345"));
		customerMap.put(3, new Customer("Thomas Underwood", 27, "YY789AA56", "641-555-4321"));
		customerMap.clear();

		assertEquals(0, customerMap.size());

		assertNull(customerMap.get(1));
		assertNull(customerMap.get(2));
		assertNull(customerMap.get(3));
	}

	@Test
	public void hashMapConstructorTests() {
		Customer customer = new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234");

		assertEquals("Leslie Hill", customer.getCustomerName());
		assertEquals(37, customer.getAge());
		assertEquals("YY123AA12", customer.getLicenseId());
		assertEquals("641-555-1234", customer.getPhoneNumber());
	}

	@Test
	public void equalsTest() {

		Customer customer1 = new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234");
		Customer customer2 = new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234");

		assertTrue(customer1.equals(customer2));

		customer2.setAge(31);
		assertFalse(customer1.equals(customer2));

		customer2.setAge(37);

		assertFalse(customer1.equals(null));

		assertFalse(customer1.equals("Leslie Hill"));

		Customer customer3 = new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234");
		assertTrue(customer1.equals(customer3));

		Customer customer4 = new Customer("Brandy Brown", 29, "YY456AA34", "641-555-2345");
		assertFalse(customer1.equals(customer4));
	}

	@Test
	public void testCustomerToString() {
		// ARRANGE
		Customer customer = new Customer("Leslie Hill", 37, "YY123AA12", "641-555-1234");
		customer.setCustomerID(15);
		// ACT
		String result = customer.toString();

		// ASSERT
		assertEquals("Customer ID: 15, Name: Leslie Hill, Age: 37, License ID: YY123AA12, Phone Number: 641-555-1234",
				result);
	}

	@Test
	public void testWaitlistContainsKey() {
		// ARRANGE
		Map<Integer, Queue<Integer>> waitlist = new HashMap<>();
		int equipmentId = 1;
		Queue<Integer> customerQueue = new LinkedList<>();
		customerQueue.offer(10);
		waitlist.put(equipmentId, customerQueue);

		// ACT & ASSERT
		assertTrue(waitlist.containsKey(equipmentId));
		assertFalse(waitlist.containsKey(45));
	}

	@Test
	public void testWaitlistBasicOperations() {
		// ARRANGE
		Map<Integer, Queue<Integer>> waitlist = new HashMap<>();
		int equipmentId = 1;
		Queue<Integer> customerQueue = new LinkedList<>();
		customerQueue.offer(10);
		waitlist.put(equipmentId, customerQueue);

		// ASSERT
		assertTrue(waitlist.isEmpty());
		assertEquals(1, waitlist.size());
		assertTrue(waitlist.containsKey(equipmentId));
		assertNotNull(waitlist.toString());

		// ACT & ASSERT
		assertNull(waitlist.put(2, new LinkedList<Integer>()));
		assertEquals(2, waitlist.size());

		// ACT & ASSERT
		assertEquals(1, waitlist.get(equipmentId).size());
		assertEquals(10, (int) waitlist.get(equipmentId).peek());
		// ACT & ASSERT
		assertEquals(1, waitlist.size());
		assertEquals(1, waitlist.remove(equipmentId).size());
		assertEquals(0, waitlist.size());

		// ACT & ASSERT
		assertFalse(waitlist.containsKey(equipmentId));
	}

}
