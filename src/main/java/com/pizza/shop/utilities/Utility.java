package com.pizza.shop.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.pizza.shop.model.Order;

public class Utility {

	/***
	 * Method to parse input data and return list of object
	 * 
	 * @param inputFileName
	 * @return List<Order>
	 */
	public List<Order> getAllOrder( String inputFileName){
		
		List<Order> orderList = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(
				inputFileName))) {

			String line;
			int count = 0;
			Order order;
			while ((line = br.readLine()) != null && ! line.isEmpty()) {
				if (count != 0) {// skip the header row
					order = getOrder(line.toUpperCase());
					orderList.add(order);
				}

				count++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	return orderList;	
	}
	
	private Order getOrder(String inputText) {

		Order order = new Order();
		String[] inputOrderText = inputText.split("\\s+");
		if (inputOrderText.length > 0) {
			order.setName(inputOrderText[0].trim());
			try {
				order.setTime(Integer.parseInt(inputOrderText[1].trim()));
			} catch (Exception e) {
				order.setTime(0);
				e.printStackTrace();
			}

		}
		return order;

	}
	
}
