package in.co.rays.project3.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project3.util.ServletUtility;

/**
 * welcome functionality controller.to  show welcome page
 * @author computer gallery
 *
 */
@WebServlet(name = "WelcomeCtl", urlPatterns = { "/WelcomeCtl" })
public class WelcomeCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;


	
	/**
	 * The doGet Method
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("Welcome doget method start");
		ServletUtility.forward(getView(), request, response);
		System.out.println("Welcome doget method ends");
		
	} 
	
	

	/**
	 * The getView Method
	 */
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		System.out.println("Welcome getview method start");
		return ORSView.WELCOME_VIEW;
	}
}
