package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	
	private String search = "input[name='search']";
	private String searchIcon = "span[class='input-group-btn']";
	private String searchPageHeader = "div#content h1";
	
	//Page constructor
	
	public HomePage(Page page) {
		this.page = page;
	}
	
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("Title is "+ title);
		return page.title();
		
	}
	
	public String getHomePageURL() {
		String url = page.url();
		System.out.println("URL is "+ url);
		return page.url();
	}
	
	
	public String doSearch(String productName) {
		
		page.fill(search, productName);
		page.click(searchIcon);
		//page.locator(searchPageHeader).waitFor();
		String header = page.textContent(searchPageHeader);
		System.out.println("Search Header is "+ header);
		
		return header;
	}
	
}
