package com.maieutiquer.primesinaninterval;

public class InvalidRangeException extends Exception {

	private static final long serialVersionUID = 1L;

    public InvalidRangeException() {}

    public InvalidRangeException(String message)
    {
       super(message);
    }
}
