package com.example.geektrust.validator;

import java.util.regex.Pattern;

public class PatternValidator {
	
	public static final Pattern VALID_EMAIL =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	
	public static boolean validateEmailAddress(String emailAddress){
  	  if (VALID_EMAIL.matcher(emailAddress).matches()) {
            return true;
        } 
  	  return false;
  	  
  }
    
}
