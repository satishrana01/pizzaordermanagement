package com.pizza.shop;

import java.util.Collections;
import java.util.List;

import com.pizza.shop.model.Order;
import com.pizza.shop.utilities.FileHandling;
import com.pizza.shop.utilities.Utility;
import com.pizza.shop.utilities.ValidateInput;

public class RunMain {

	public static void main(String[] args) {
		
		ValidateInput valiationObj = new ValidateInput();
		
		String outputMessage = valiationObj.validateInput(args);
		
		if (outputMessage.isEmpty()) {
			
			String inputFileName = args[0];
			String destinationFileName = args[1];
			
			Utility utillity = new Utility();
			FileHandling fileOperationObject = new FileHandling();

			// get list of order object
			List<Order> pizzaOrderList = utillity.getAllOrder(inputFileName);
			// sort the order object in lexicographical
			Collections.sort(pizzaOrderList);
			// write the output file
			boolean status = fileOperationObject.writeOutputFile(
					pizzaOrderList, destinationFileName);

			if (status) {

				System.out.println("Output file created successfully ");
			} else {
				System.out
						.println("Something went wrong ! Please verify the log file");
			}
		} else{
			
			System.out.println(outputMessage);
		}
		

	}
	 
}
