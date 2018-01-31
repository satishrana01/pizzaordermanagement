package com.pizza.shop.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.pizza.shop.model.Order;

/***
 * Java file for handling file related operation
 * 
 * @author Satish
 *
 */
public class FileHandling {

	/***
	 * Write sorted output in file
	 * 
	 * @param orderList
	 * @param outputFileName
	 * @return boolean
	 */
	public boolean writeOutputFile(List<Order> orderList,String outputFileName) {

		boolean outPutFileStatus = true;
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		File file = new File(outputFileName);
		if(file.isDirectory())
		file.mkdir();
		try {
			file.createNewFile();
			fileWriter = new FileWriter(outputFileName);
			printWriter = new PrintWriter(fileWriter);
			printWriter.printf("%-20s %s\n","Order","Time");
			for (Order order : orderList) {
				printWriter.printf("%-20s %s\n", order.getName(),
						order.getTime());
			}

		} catch (IOException e) {
			outPutFileStatus = false;
			e.printStackTrace();
		} finally {
			if (fileWriter != null)
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (printWriter != null)
				printWriter.close();
		}
		if(outPutFileStatus)
			System.out.println("path : "+outputFileName);
		return outPutFileStatus;

	}
}
