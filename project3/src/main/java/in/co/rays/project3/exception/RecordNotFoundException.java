package in.co.rays.project3.exception;

/**
 * RecordNotFoundException thrown when a record not found occurred
 * @author computer gallery
 *
 */
public class RecordNotFoundException extends Exception{


	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * @param msg
	 * : Error message
	 */
	public RecordNotFoundException(String msg){
		
		super(msg);
	}
}
