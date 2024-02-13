package com.rays.exception;

/**
 * ApplicationException is propogated from Service classes when an business
 * logic exception occurered.
 * @author Abhishek Verma
 */
public class ApplicationException extends Exception {

	/**
	 * @param msg
	 *            : Error message
	 */
	public ApplicationException(String msg) {
		super(msg);
	}
}