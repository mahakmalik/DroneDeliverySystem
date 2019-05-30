package com.dds.exceptions;

/**
 * Custom Exception Class for malformed data in input file.
 * @author Mahak Malik
 *
 */
public class MalformedFileDataException extends Exception {

	public MalformedFileDataException(String message) {
		super(message);
	}

}
