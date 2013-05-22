package controllers;

import play.mvc.Result;
import static play.mvc.Results.ok;

public class Test {

	public static Result test() {
		String result = "";

		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++)
				result += i * j + "\t";
			result += "\n";
		}

		return ok(result);
	}
}
