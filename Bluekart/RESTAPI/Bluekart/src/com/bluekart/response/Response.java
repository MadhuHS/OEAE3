package com.bluekart.response;

import java.util.ArrayList;

import com.bluekart.model.Product;

public class Response {
	
	private int results;
	
	public ArrayList<Product> productlist = new ArrayList<Product>();

	public int getResults() 
	{
		return results;
	}

	public void setResults(int results)
	{
		this.results = results;
	}

}
