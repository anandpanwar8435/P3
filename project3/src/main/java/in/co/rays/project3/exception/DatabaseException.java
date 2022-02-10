package in.co.rays.project3.exception;

/**
 *  DatabaseException is prpogated by DAO classes when an unhandled Database
 *  exception occurred
 * @author computer gallery
 *
 */
public class DatabaseException extends Exception {
	
		/**
		 * serialVersionUID
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * @param msg
		 * error message
		 */
		public DatabaseException(String msg){
			super(msg);
		}

}
