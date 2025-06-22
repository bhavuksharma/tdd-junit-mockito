package com.virtualpairprogrammers.isbntools;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockManagementTests {
	
	ExternalISBNDataService testWebService;
	StockManager stockManager;
	ExternalISBNDataService testDatabaseService;
	
	
	@BeforeEach
	public void setup() {
		testWebService = mock(ExternalISBNDataService.class);
		stockManager = new StockManager();
		stockManager.setWebService(testWebService);
		testDatabaseService = mock(ExternalISBNDataService.class);
		stockManager.setDatabaseService(testDatabaseService);
	}

	@Test
	public void testCanGetACorrectLocatorCode() {
		
		when(testWebService.lookUp(anyString())).thenReturn(new Book("0140177396","Of Mice And Men","J.Steinbeck"));	
		when(testDatabaseService.lookUp(anyString())).thenReturn(null);
		
		String isbn = "0140177396";		
		String locatorCode = stockManager.getLocatorCode(isbn);
		assertEquals("7396J4", locatorCode);
	}
	
	@Test
	public void databaseIsUsedIfDataIsPresent() {
		
		when(testDatabaseService.lookUp("0140177396")).thenReturn(new Book("0140177396","abc","abc"));
		
		String isbn = "0140177396";		
		String locatorCode = stockManager.getLocatorCode(isbn);

		verify(testDatabaseService).lookUp("0140177396");
		verify(testWebService, never()).lookUp(anyString());
	}
	
	@Test
	public void webserviceIsUsedIfDataIsNotPresentInDatabase() {
		
		when(testDatabaseService.lookUp("0140177396")).thenReturn(null);
		when(testWebService.lookUp("0140177396")).thenReturn(new Book("0140177396","abc","abc"));
		
		String isbn = "0140177396";		
		String locatorCode = stockManager.getLocatorCode(isbn);

		verify(testDatabaseService).lookUp("0140177396");
		verify(testWebService).lookUp("0140177396");
	}

}
