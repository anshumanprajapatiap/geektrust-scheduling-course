package com.example.geektrust.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.example.geektrust.constant.GeektrustConstant;

public class Constant {
	
	
	@Test
    public void testGetValue(){
        assertEquals("ADD_COURSE_OFFERING",GeektrustConstant.getOperationValue("ADD-COURSE-OFFERING") );
        assertNotEquals("ALLOT_COURSE",GeektrustConstant.getOperationValue("ALLOT-COURSE"));
        assertEquals("INPUT_DATA_ERROR",GeektrustConstant.INPUT_DATA_ERROR);
        assertEquals("REJECTED",GeektrustConstant.REJECTED);
        assertEquals("ACCEPTED",GeektrustConstant.ACCEPTED);
        assertEquals("CANCEL_REJECTED",GeektrustConstant.CANCEL_REJECTED);
        assertEquals("CANCEL_ACCEPTED",GeektrustConstant.CANCEL_ACCEPTED);
    }

}
