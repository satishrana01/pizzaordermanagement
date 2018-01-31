package com.pizza.shop.utilities;

import java.io.File;
import java.io.IOException;


/***
 * Helper class to perform all the validation
 * 
 * @author Satish
 *
 */
public class ValidateInput {

	public String validateInput(String... args) {

		String message = "";
		if (args.length == 0)
			message = Constant.MISSING_ARGS;
		else if (args.length == 1)
			message = Constant.MISSING_OUTPUT;
		else if (!args[0].endsWith(".txt"))
			message = Constant.EXTENSION;
		else if (!args[1].endsWith(".txt"))
			message = Constant.EXTENSION;
		else if (!validatePath(args[0])) {
			message = Constant.INVALID_SOURCEPATH;
		}
		return message;

	}

	private boolean validatePath(String path) {

		boolean pathExists = false;

		File file = new File(path);
		if (file.exists()) {
			pathExists = true;
		}
		return pathExists;

	}
}
