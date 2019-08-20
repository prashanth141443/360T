package com.threesixty.assignment.exception;

/**
 * 
 * @author prasanth.penumala
 * This class is defined for user defined Exception!!
 *
 */
public class AssignmentException extends Exception{
	
	private AssignmentException() {}
	
	public AssignmentException(int errorCode, String errorMessage) {
		System.out.println("Exception raised with Error Code["+errorCode+"] "+errorMessage);
	}
	
	public AssignmentException(String errorMessage) {
		System.out.println(errorMessage);
	}
	
	
}
