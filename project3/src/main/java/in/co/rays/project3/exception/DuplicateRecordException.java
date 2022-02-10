package in.co.rays.project3.exception;

/**
 * DuplicateRecordException is prpogated by DAO classes when an unhandled Database
 * exception occurred
 * @author computer gallery
 *
 */
public class DuplicateRecordException extends Exception {


		/**
		 * serialVersionUID
		 */
		private static final long serialVersionUID = 1L;

		
		/**
		 * @param msg
		 * error msg
		 */
		public DuplicateRecordException(String msg){
			super(msg);
		}
	}
