package com.virtualpairprogrammers.isbntools;

public class StockManager {
	
	private ExternalISBNDataService webService;
	private ExternalISBNDataService databaseService;
	

	public void setDatabaseService(ExternalISBNDataService databaseService) {
		this.databaseService = databaseService;
	}

	public void setWebService(ExternalISBNDataService service) {
		this.webService = service;
	}

	public String getLocatorCode(String isbn) {
		Book book = databaseService.lookUp(isbn);
		
		if(book == null) book = webService.lookUp(isbn);
		
		StringBuilder locator = new StringBuilder();
		locator.append(isbn.substring(isbn.length() - 4));
		locator.append(book.getAuthor().substring(0, 1));
		locator.append(book.getTitle().split(" ").length);
		return locator.toString();
	}

}
