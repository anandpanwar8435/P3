package in.co.rays.project3.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project3.dto.BaseDTO;
import in.co.rays.project3.dto.StudentDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.model.CollegeModelInt;
import in.co.rays.project3.model.ModelFactory;
import in.co.rays.project3.model.StudentModelInt;
import in.co.rays.project3.util.DataUtility;
import in.co.rays.project3.util.DataValidator;
import in.co.rays.project3.util.PropertyReader;
import in.co.rays.project3.util.ServletUtility;

/**
 * student functionality controller.to perform add,delete ,update operation
 * @author computer gallery
 *
 */
@WebServlet(urlPatterns={"/ctl/StudentCtl"})
public class StudentCtl  extends BaseCtl{

	private static Logger log = Logger.getLogger(StudentCtl.class);
	
	/**
	 * The preload Method
	 */
	@Override
	protected void preload(HttpServletRequest request) {
		CollegeModelInt model =ModelFactory.getInstance().getCollegeModel();
		try {
			List l = model.list();
			request.setAttribute("collegeList", l);
		} catch (ApplicationException e) {
			log.error(e);
		}

	}

	/**
	 * The validate Method
	 */
	@Override
	protected boolean validate(HttpServletRequest request) {

//		log.debug("StudentCtl Method validate Started");

		boolean pass = true;

		String op = DataUtility.getString(request.getParameter("operation"));
		String login = request.getParameter("login");
		String dob = request.getParameter("dob");

		if (DataValidator.isNull(request.getParameter("firstName"))) {
			request.setAttribute("firstName", PropertyReader.getValue("error.require", "First Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("firstName"))) {
			request.setAttribute("firstName", "please enter correct Name");
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("lastName"))) {
			request.setAttribute("lastName", PropertyReader.getValue("error.require", "Last Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("lastName"))) {
			request.setAttribute("lastName", "please enter correct Name");
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", PropertyReader.getValue("error.require", "Mobile No"));
			pass = false;
		} else if (!DataValidator.isPhoneNo(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", "Please Enter Valid Mobile Number");
			pass = false;
		}

		if (DataValidator.isNull(login)) {
			request.setAttribute("emailId", PropertyReader.getValue("error.require", "Email Id"));
			pass = false;
		} else if (!DataValidator.isEmail(login)) {
			request.setAttribute("emailId", PropertyReader.getValue("error.email", "Email Id"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("collegeId"))) {
			request.setAttribute("collegeId", PropertyReader.getValue("error.require", "College Name"));
			pass = false;
		}
		if (DataValidator.isNull(dob)) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", "Date Of Birth"));
			pass = false;
		} else if (!DataValidator.isDate(dob)) {
			request.setAttribute("dob", PropertyReader.getValue("error.date", "Date Of Birth"));
			pass = false;
		} else if (!DataValidator.isValidAge(dob)) {
			request.setAttribute("dob", "Age Must be greater then 18 year");
			pass = false;
		}

//		log.debug("StudentCtl Method validate Ended");

		return pass;
	}

	/**
	 * The populateDTO Method
	 */
	@Override
	protected BaseDTO populateDTO(HttpServletRequest request) {
		System.out.println("student ctl populate bean........");
//		log.debug("StudentCtl Method populatebean Started");

		StudentDTO dto = new StudentDTO();

		dto.setId(DataUtility.getLong(request.getParameter("id")));

		dto.setFirstName(DataUtility.getString(request.getParameter("firstName")));
		dto.setLastName(DataUtility.getString(request.getParameter("lastName")));

		dto.setDob(DataUtility.getDate(request.getParameter("dob")));

		dto.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));

		dto.setLogin(DataUtility.getString(request.getParameter("login")));

		dto.setCollegeId(DataUtility.getLong(request.getParameter("collegeId")));

		populateDTO(dto,request);
		
//		log.debug("StudentCtl Method populatebean Ended");

		return dto;
	}

	
	/**
	 * Contains Display logics
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		log.debug("StudentCtl Method doGet Started");

		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));

		// get model

		StudentModelInt model = ModelFactory.getInstance().getStudentModel();
		if (id > 0 || op != null) {
			StudentDTO dto;
			try {
				dto = model.findByPk(id);
				ServletUtility.setDto(dto, request);
			} catch (ApplicationException e) {
//				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		}
		ServletUtility.forward(getView(), request, response);
//		log.debug("StudentCtl Method doGett Ended");
	}

	/**
	 * Contains Submit logics
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("student ctl  do post start........");
//		log.debug("StudentCtl Method doPost Started");

		String op = DataUtility.getString(request.getParameter("operation"));

		// get model

		StudentModelInt model = ModelFactory.getInstance().getStudentModel();

		long id = DataUtility.getLong(request.getParameter("id"));

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			System.out.println(" save operation......");
			StudentDTO dto = (StudentDTO) populateDTO(request);

			try {
				if (id > 0) {
					model.update(dto);
					ServletUtility.setDto(dto, request);
					ServletUtility.setSuccessMessage("Data is successfully Update", request);
				} else {
					try {
						System.out.println("add dopsot");
						model.add(dto);
						ServletUtility.setSuccessMessage("Data is successfully saved", request);
					} catch (ApplicationException e) {
//						log.error(e);
						ServletUtility.handleException(e, request, response);
						return;
					} catch (DuplicateRecordException e) {
						ServletUtility.setDto(dto, request);
						ServletUtility.setErrorMessage("Student already exists", request);
					}

				}

				

			} catch (ApplicationException e) {
//				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("Student Email Id already exists", request);
			}

		}

//		else if (OP_DELETE.equalsIgnoreCase(op)) {
//
//			StudentDTO dto = (StudentDTO) populateDTO(request);
//			try {
//				model.delete(dto);
//				ServletUtility.redirect(ORSView.STUDENT_LIST_CTL, request, response);
//				return;
//
//			} catch (ApplicationException e) {
////				log.error(e);
//				ServletUtility.handleException(e, request, response);
//				return;
//			}
//
//		} 
		else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.STUDENT_LIST_CTL, request, response);
			return;

		} else if (OP_RESET.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.STUDENT_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);

//		log.debug("StudentCtl Method doPost Ended");
	}

	/**
	 * The getView Method
	 */
	@Override
	protected String getView() {
		return ORSView.STUDENT_VIEW;
	}

}
