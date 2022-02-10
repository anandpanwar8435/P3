package in.co.rays.project3.ctl;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project3.util.ServletUtility;


/**
 * Error functionality controller.perform error page operation 
 * @author computer gallery
 *
 */
@WebServlet(name="ErrorCtl", urlPatterns={"/ErrorCtl"})
public class ErrorCtl extends BaseCtl{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * Concept of Display logic
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
		ServletUtility.forward(getView(), request, response);
		
	}
	
/**
 * Concept of submit logic
 */
protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
	
 ServletUtility.forward(getView(), request, response);

  
}
	/**
	 * The getView Method
	 */
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.ERROR_VIEW;
	}
}
