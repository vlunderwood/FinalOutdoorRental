package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import OutdoorRental.Rental;
import OutdoorRental.RentalDriver;
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
	void testIsEmptyFalse(){
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
		//rental.enqueue(expected + 2);
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
	    assertEquals(expected, actual);	}
	
	@Test
	void testSizeNonZero() throws QueueEmptyException {
		// ARRANGE
		Rental rental = new Rental("Kayak", "Pelican");
		
		int actual, expected;
		expected = 2;
		// ACT
		rental.enqueue(expected + 1);
		rental.enqueue(expected+ 2);
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
	/*
	@Test
	void testPrintQueueEmptyQueue() {
		// ARRANGE
		Rental rental = new Rental("Kayak", "Pelican");
		// ACT
		// ASSERT
		assertThrows(QueueEmptyException.class, () -> rental.toString());
	}
	
	@Test
	void testPrintQueue() throws QueueEmptyException {
		// ARRANGE
		Rental rental = new Rental("Kayak", "Pelican");
		
		int actual, expected;
		expected = 1;
		// ACT
		rental.enqueue(expected + 1);
		rental.enqueue(expected + 2);
		actual = rental.toString();
		// ASSERT
		assertEquals(expected, actual);
	}
*/
}
