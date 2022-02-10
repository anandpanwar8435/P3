package in.co.rays.project3.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project3.dto.BaseDTO;
import in.co.rays.project3.dto.CollegeDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.model.CollegeModelInt;
import in.co.rays.project3.model.ModelFactory;
import in.co.rays.project3.util.DataUtility;
import in.co.rays.project3.util.DataValidator;
import in.co.rays.project3.util.PropertyReader;
import in.co.rays.project3.util.ServletUtility;

/**
 * College functionality ctl. To perform add,delete ,update operation
 * @author computer gallery
 *
 */
@WebServlet(urlPatterns = {"/ctl/CollegeCtl"})
public class CollegeCtl extends BaseCtl {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
//	private static Logger log = Logger.getLogger(CollegeCtl.class);

	
	/**
	 * The Validate Method
	 */
	protected boolean validate(HttpServletRequest request) {
		System.out.println("in validataion");
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("name"))) {
			
			request.setAttribute("name", PropertyReader.getValue("error.require", "Name"));
			pass = false;
			System.out.println(pass);
			
		} else if (!DataValidator.isName(request.getParameter("name"))) {
			request.setAttribute("name", "please enter correct Name");
			pass = false;
        }
		
		if (DataValidator.isNull(request.getParameter("city"))) {
			request.setAttribute("city", PropertyReader.getValue("error.require", "City"));
			pass = false;
			
		} else if (!DataValidator.isName(request.getParameter("city"))) {
			request.setAttribute("city", "please enter correct City");
			pass = false;
       }
		
		if (DataValidator.isNull(request.getParameter("state"))) {
			request.setAttribute("state", PropertyReader.getValue("error.require", "State"));
			pass = false;
			
		} else if (!DataValidator.isName(request.getParameter("state"))) {
			request.setAttribute("state", "please enter correct State");
			pass = false;
        }
		
		if (DataValidator.isNull(request.getParameter("address"))) {
			request.setAttribute("address", PropertyReader.getValue("error.require", "Address"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("address"))) {
			request.setAttribute("address", "please enter correct Address");
			pass = false;
        }
		
		if (DataValidator.isNull(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", PropertyReader.getValue("error.require", "Mobile No"));
			pass = false;
			
		}else if(!DataValidator.isPhoneLength(request.getParameter("mobileNo"))){
			 request.setAttribute("mobileNo", "Please Enter Valid Mobile No");
			 pass=false;
		} else if (!DataValidator.isPhoneNo(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", "Please Enter Valid Mobile No");
			pass = false;
		}
		System.out.println("out off validation "+pass);
		return pass;
		
	}

	/**
	 * The populateDTO Method
	 */
	protected BaseDTO populateDTO(HttpServletRequest request) {
		CollegeDTO dto = new CollegeDTO();
		System.out.println(request.getParameter("mobileNo"));
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setName(request.getParameter("name"));
		dto.setCity(request.getParameter("city"));
		dto.setAddress(request.getParameter("address"));
		dto.setState(request.getParameter("state"));
		dto.setPhoneNo(request.getParameter("mobileNo"));
		populateDTO(dto, request);
		return dto;
	}

	/**
	 * Display Logics inside this method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));
		CollegeModelInt model=ModelFactory.getInstance().getCollegeModel();
		if (id > 0 || op != null) {
			CollegeDTO dto;
			try {
			  dto=model.findByPk(id);
			  ServletUtility.setDto(dto, request);
				
			} catch (ApplicationException e) {
//				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}

		}
		ServletUtility.forward(getView(), request, response);
	}

	/**
	 * Submit logic inside it
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       String op=request.getParameter("operation");
       long id=DataUtility.getLong(request.getParameter("id"));
       CollegeModelInt model=ModelFactory.getInstance().getCollegeModel();
       if (OP_SAVE.equalsIgnoreCase(op)||OP_UPDATE.equalsIgnoreCase(op)) {
    	   CollegeDTO dto = (CollegeDTO) populateDTO(request);
			System.out.println("...===+" + id + ">>>>>>..." + dto);
			try {
				if (id > 0) {
					model.update(dto);
					ServletUtility.setDto(dto, request);
					ServletUtility.setSuccessMessage("Data succefully update", request);
					ServletUtility.forward(getView(), request, response);
				} else {
					System.out.println("college add" + dto + "id...." + id);
					long pk = model.add(dto);
					ServletUtility.setSuccessMessage("Data successfully saved", request);
					ServletUtility.forward(getView(), request, response);
				}
				
			} catch (ApplicationException e) {
				e.printStackTrace();
//				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("College already exists", request);
				ServletUtility.forward(getView(), request, response);
			} 
		} 
//       else if (OP_DELETE.equalsIgnoreCase(op)) {
//			CollegeDTO dto = (CollegeDTO) populateDTO(request);
//			try {
//				model.delete(dto);
//				ServletUtility.forward(ORSView.COLLEGE_LIST_CTL, request, response);
//				return;
//			} catch (Exception e) {
////				log.error(e);
//				ServletUtility.handleException(e, request, response);
//				return;
//			}
//		}
       

   	else if (OP_RESET.equalsIgnoreCase(op)) {

   			ServletUtility.redirect(ORSView.COLLEGE_CTL, request, response);
   			return;

   		}

	else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.COLLEGE_LIST_CTL, request, response);
			return;

		}
		
	}

	/**
	 * The getView Method
	 */
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.COLLEGE_VIEW;
	}

}
