package com.example.geektrust.converter;

import com.example.geektrust.constant.GeektrustConstant;
import com.example.geektrust.enums.ScheduleOperation;
import com.example.geektrust.model.ScheduleCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CommandConverterTest {
    private CommandConverter commandConverter;

    @BeforeEach
    public void setUp() {
        commandConverter = new CommandConverter();
    }

    @Test
    public void testGetCommandFromString() throws Exception {
        String commandString = "REGISTER ABC@GMAIL.COM REG-COURSE-PYTHON-KARMA";
        ScheduleCommand scheduleCommand = commandConverter.getCommandFromString(commandString);

        Assertions.assertEquals(ScheduleOperation.REGISTER, scheduleCommand.getInputCommand());
        List<String> commandParams = scheduleCommand.getCommandParams();
        Assertions.assertNotEquals(5, commandParams.size());
        Assertions.assertEquals(2, commandParams.size());
        Assertions.assertEquals("ABC@GMAIL.COM", commandParams.get(0));
        Assertions.assertEquals("REG-COURSE-PYTHON-KARMA", commandParams.get(1));
    }
}
