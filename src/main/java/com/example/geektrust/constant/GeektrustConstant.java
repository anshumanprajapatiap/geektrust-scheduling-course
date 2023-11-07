package com.example.geektrust.constant;

public class GeektrustConstant {
	
	
	public static final String INPUT_DATA_ERROR = "INPUT_DATA_ERROR";
	public static final String REJECTED = "REJECTED";
    public static final String ACCEPTED = "ACCEPTED";
    public static final String CANCEL_REJECTED = "CANCEL_REJECTED";
    public static final String CANCEL_ACCEPTED = "CANCEL_ACCEPTED";
    public static final String COURSE_CANCELED = "COURSE_CANCELED";
    public static final String COURSE_FULL_ERROR = "COURSE_FULL_ERROR";
    public static final String CONFIRMED = "CONFIRMED";
    public static final String HASH_SYMBOL = "#";
    public static final char AT_THE_RATE_SYMBOL = '@';
    public static final String REGCOURSE = "REG-COURSE-";
    public static final String OFFERING = "OFFERING-";
    public static final String HYPEN = "-";
    public static final String ddMMyyyy = "ddMMyyyy";
    
    public static final String space = " ";
	public static final String emptyString = "";
	
	public static final String FileNotFound = "File Not Found";
	public static final String unchecked = "unchecked";
	
	public static final boolean FALSE = false;
	public static final boolean TRUE = true;
	
	public static final String minArgs = "minArgs";
	public static final String maxArgs = "maxArgs";
	
	public static final int Integer_0 = 0;
	public static final int Integer_1 = 1;
	public static final int Integer_2 = 2;
	public static final int Integer_3 = 3;
	public static final int Integer_4 = 4;
	public static final int Integer_5 = 5;
	
	
	
	public static String getOperationValue(String input) {
        String value = "";
        switch (input) {
            case "ADD-COURSE-OFFERING":
                value = "ADD_COURSE_OFFERING";
                break;
             
            default:
                value = input;
                break;
        }
        return value;
    }

}
