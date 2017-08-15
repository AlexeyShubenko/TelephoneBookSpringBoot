package com.test.javaproject.mvc.domains;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static boolean checkValidLogin(String login) {
		Pattern p = Pattern.compile("^[A-z]+[0-9]+$");
        Matcher m = p.matcher(login);
		return m.matches();
	}
	
	public static boolean checkValidTelNumber(String number){
		String condition = "^\\+(380)\\([0-9]{2}\\)[0-9]{7}$";
		Pattern p = Pattern.compile(condition);
		Matcher m = p.matcher(number);
		return m.matches();
	}
	
	public static boolean checkValidHomeNumber(String number){
		if(number!=""){
			if(number.matches("^[0-9]{2}\\-[0-9]{2}\\-[0-9]{2}$")||number.matches("^[0-9]{6}"))return true;
			else return false;
		} else return true;
	}
	
}
