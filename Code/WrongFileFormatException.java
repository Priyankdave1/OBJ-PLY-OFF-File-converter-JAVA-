package assignment;
import java.lang.Exception;
public class WrongFileFormatException extends Exception{

	String message;

	public WrongFileFormatException(String message) {
		super(message);
		this.message = message;
	}
		
	
}
