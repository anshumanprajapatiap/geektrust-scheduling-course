package com.example.geektrust.service;

import java.io.IOException;
import java.util.List;

public interface FileService {
	
public List<String> processedInput() throws IOException;
	
	public List<String> getCommandList() throws IOException;

}
