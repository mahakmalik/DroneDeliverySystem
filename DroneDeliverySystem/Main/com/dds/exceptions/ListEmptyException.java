package com.dds.exceptions;

/**
 * Custom Exception Class for empty lists.
 * @author Mahak Malik
 *
 */
public class ListEmptyException extends Exception{

	public ListEmptyException(String message) {
		super(message);		
	}	
}
