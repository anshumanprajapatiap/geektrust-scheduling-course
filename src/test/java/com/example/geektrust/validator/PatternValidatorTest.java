package com.example.geektrust.validator;

import static org.hamcrest.CoreMatchers.either;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PatternValidatorTest {
	
	
	String emailCorrect;
    String emailIncorrect;

    @BeforeEach
    public void setup(){
    	emailCorrect = "abc@gmail.com";
    	emailIncorrect = "aaafgw._gmail.com";
    }
    
    @Test
    public void testGetNumberOfArguments() {
    	
    	assertEquals(PatternValidator.validateEmailAddress(emailCorrect),true);
    	assertNotEquals(PatternValidator.validateEmailAddress(emailCorrect),false);
    	
    	assertEquals(PatternValidator.validateEmailAddress(emailIncorrect),false);
    	assertNotEquals(PatternValidator.validateEmailAddress(emailIncorrect),true);
    	
    	
   
    }

}
