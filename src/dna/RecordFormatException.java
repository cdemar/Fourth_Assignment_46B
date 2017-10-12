package dna;

/*
 * Provided one constructor whose argument is a
 * String, then it  passes the String to the superclass	
 * constructor that takes a single String argument.
 */

public class RecordFormatException extends Exception {

	private String message;

	public RecordFormatException(String message) {
		super(message);

	}

}
