package in.co.rays.project3.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.project3.dto.BaseDTO;
import in.co.rays.project3.dto.UserDTO;
import in.co.rays.project3.util.DataUtility;
import in.co.rays.project3.util.DataValidator;
import in.co.rays.project3.util.ServletUtility;

/**
 * Base controller class of project. It contain (1) Generic operations (2)
 * Generic constants (3) Generic work flow
 * @author computer gallery
 *
 */
public abstract class BaseCtl extends HttpServlet{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	public static final String OP_SAVE = "Save";
	public static final String OP_CANCEL = "Cancel";
	public static final String OP_DELETE = "Delete";
	public static final String OP_RESET = "Reset";
	public static final String OP_LIST = "List";
	public static final String OP_SEARCH = "Search";
	public static final String OP_VIEW = "View";
	public static final String OP_NEXT = "Next";
	public static final String OP_PREVIOUS = "Previous";
	public static final String OP_NEW = "New";
	public static final String OP_GO = "Go";
	public static final String OP_BACK = "Back";
	public static final String OP_UPDATE = "Update";
	public static final String OP_LOG_OUT = "Logout";
	public static final String OP_CHANGE_MY_PROFILE = "MyProfile";
	
	

	/**
	 * Success Message Key Constant
	 */
	public static final String MSG_SUCCESS = "success";

	/**
	 * Error message key constant
	 */
	public static final String MSG_ERROR = "error";
	
	
	/**
	 * Validates input data entered by User
	 * 
	 * @param request
	 * @return
	 */
	protected boolean validate(HttpServletRequest request) {
		return true;
		
	}
	
	/**
	 * Loads list and other data required to display at HTML form
	 * @param request
	 */
	protected void preload(HttpServletRequest request) {
		
	}
	
	
	/**
	 * Populates DTO object from request parameters
	 * 
	 * @param request
	 * @return
	 */
	protected BaseDTO populateDTO(HttpServletRequest request) {
		
        return null;
    }
	
	
    
	/**
	 * Populates DTO object from request parameters
	 * 
	 * @param dto
	 * @param request
	 * @return
	 */
	protected BaseDTO populateDTO(BaseDTO dto,HttpServletRequest request){
		
		System.out.println("populateDTO method in BaseCtl");
		
		String createdBy=request.getParameter("createdBy");
		String modifiedBy=null;
		
//		UserDTO userDto=(UserDTO)request.getSession().getAttribute("user");
		
		HttpSession session=request.getSession();
		
		UserDTO userDto=(UserDTO) session.getAttribute("user");
		
		if(userDto==null){
			createdBy="root";
			modifiedBy="root";
			
		}else{
			modifiedBy=userDto.getLogin();
			if("null".equalsIgnoreCase(createdBy)||DataValidator.isNull(createdBy)){
				createdBy=modifiedBy;
			}
		}
			dto.setCreatedBy(createdBy);
			dto.setModifiedBy(modifiedBy);
			
			long cdt=DataUtility.getLong(request.getParameter("createdDateTime"));
			
			if(cdt>0){
				dto.setCreatedDatetime(DataUtility.getTimeStamp(cdt));
		  }else{
			dto.setCreatedDatetime(DataUtility.getCurrentTimeStamp());
		}
		dto.setModifiedDatetime(DataUtility.getCurrentTimeStamp());
	    return dto;
	}
	
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		preload(request);
		
		String op=DataUtility.getStringData(request.getParameter("operation"));
		System.out.println("Service Method Starts");
		
		if(DataValidator.isNotNull(op) && !OP_CANCEL.equalsIgnoreCase(op) && !OP_VIEW.equalsIgnoreCase(op)
				&& !OP_DELETE.equalsIgnoreCase(op)&& !OP_RESET.equalsIgnoreCase(op)) {
			
			if(!validate(request)) {
				BaseDTO dto = populateDTO(request);
                ServletUtility.setDto(dto, request);
                ServletUtility.forward(getView(), request, response);
                return;
			}
			System.out.println("validation done");
		}
			
		super.service(request, response);
        System.out.println("BaseCtl service method ends");
	}
	
	
	
	
	/**
	 * Returns the VIEW page of this Controller
	 * 
	 * @return View
	 */
	protected abstract String getView();
}
