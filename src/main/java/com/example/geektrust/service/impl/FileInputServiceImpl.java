package com.example.geektrust.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.geektrust.constant.GeektrustConstant;
import com.example.geektrust.service.FileService;

public class FileInputServiceImpl implements FileService{
	
	
	private final File file;
    private final BufferedReader reader;

    public FileInputServiceImpl(String filePath) throws FileNotFoundException {
        file = new File(filePath);
        reader = new BufferedReader(new FileReader(file));
    }
    @Override
    public List<String> getCommandList() throws IOException {
        List<String> commands = new ArrayList<>();
        try {
            List<String> listOfInputCommand = processedInput();
            commands = listOfInputCommand;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return commands;
    }
    
    @Override
	public List<String> processedInput() throws IOException {
		// TODO Auto-generated method stub
    	 List<String> result = new ArrayList<>();
         String preProcessedInput = readNextLine();
         while (preProcessedInput != null) {
             result.add(preProcessedInput);
             preProcessedInput = readNextLine();
         }
         return result;
	}
   

    private String readNextLine() {
        String line = null;
        try {
            line = this.reader.readLine();
            if (line == null || isEmpty(line)) {
                return line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    private boolean isEmpty(String line) {
        return line == null || line.length() == GeektrustConstant.Integer_0 || line.trim().isEmpty() || line.trim().startsWith(GeektrustConstant.HASH_SYMBOL);
    }
	
	

}
