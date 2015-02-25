package ch.plam.smallestsubstringalphabet;

public class InvalidInputStringException extends Exception {
	
	private static final long serialVersionUID = 1L;

    public InvalidInputStringException() {}

    public InvalidInputStringException(String message)
    {
       super(message);
    }

}
