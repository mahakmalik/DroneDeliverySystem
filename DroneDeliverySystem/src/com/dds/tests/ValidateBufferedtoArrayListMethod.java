package com.dds.tests;

import java.util.List;

import org.junit.Test;

import com.dds.appcode.OrderFileProcessor;
import com.dds.exceptions.FileNotFoundException;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ValidateBufferedtoArrayListMethod {
    
	OrderFileProcessor ofp=new OrderFileProcessor();
	
	
	@When("^incorrect input file path is entered$")
	public void incorrect_input_file_path_is_entered(DataTable data) throws FileNotFoundException {
		List<String> path = data.asList(String.class);
		try {	    
		ofp.bufferedReaderToArrayList(path.get(0));
		ofp.bufferedReaderToArrayList(path.get(1));
		ofp.bufferedReaderToArrayList(path.get(2));
		} catch(Exception e){
			System.out.println(e);
		}
		
	}

	@Then("^File not found exception should be thrown$")
	public void file_not_found_exception_should_be_thrown() throws Throwable {
	    
	}
	
	@When("^correct input file path is entered$")
	public void correct_input_file_path_is_entered(DataTable data) throws Throwable {
		
		List<String> path = data.asList(String.class);
	    
		ofp.bufferedReaderToArrayList(path.get(0));
		
	}

	@Then("^File not found exception should not be thrown$")
	public void file_not_found_exception_should__not_be_thrown() throws Throwable {
	    
	}

}
