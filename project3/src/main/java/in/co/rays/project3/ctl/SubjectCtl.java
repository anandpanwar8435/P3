package in.co.rays.project3.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project3.dto.BaseDTO;
import in.co.rays.project3.dto.SubjectDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.model.CourseModelInt;
import in.co.rays.project3.model.ModelFactory;
import in.co.rays.project3.model.SubjectModelInt;
import in.co.rays.project3.util.DataUtility;
import in.co.rays.project3.util.DataValidator;
import in.co.rays.project3.util.PropertyReader;
import in.co.rays.project3.util.ServletUtility;

/**
 * subject functionality controller.to perform add,delete and update operation.
 * @author computer gallery
 *
 */
@WebServlet(urlPatterns = { "/ctl/SubjectCtl" })
public class SubjectCtl  extends BaseCtl{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(SubjectCtl.class);

	/**
	 * The preload Method
	 */
	protected void preload(HttpServletRequest request) {
		CourseModelInt model = ModelFactory.getInstance().getCourseModel();
		try {
			List list = model.list();
			request.setAttribute("courseList", list);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	/**
	 * The validate Method 
	 */
	protected boolean validate(HttpServletRequest request) {
		log.debug("course ctl validate start");
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("courseName"))) {
			request.setAttribute("courseName", PropertyReader.getValue("error.require", "Course Name"));
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("subjectName"))) {
			request.setAttribute("subjectName", PropertyReader.getValue("error.require", "Subject Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("subjectName"))) {
			request.setAttribute("subjectName", "please enter correct Subject Name");
			pass = false;

		}

		if (DataValidator.isNull(request.getParameter("description"))) {
			request.setAttribute("description", PropertyReader.getValue("error.require", "Description"));
			pass = false;
		}
		log.debug("course ctl validate end");
		return pass;
	}

	/**
	 * The populateDTO Method
	 */
	protected BaseDTO populateDTO(HttpServletRequest request) {
		log.debug("course ctl populate bean start");
		SubjectDTO dto = new SubjectDTO();
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setCourseId(DataUtility.getLong(request.getParameter("courseName")));
		dto.setSubjectName(DataUtility.getString(request.getParameter("subjectName")));
		dto.setDescription(DataUtility.getString(request.getParameter("description")));
		populateDTO(dto, request);
		log.debug("course ctl populate bean end");

		return dto;

	}

	/**
	 * Display Logics inside this method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("course ctl doget start");
		SubjectModelInt model = ModelFactory.getInstance().getSubjectModel();
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0 || op != null) {
			SubjectDTO dto;
			try {
				dto = model.findByPk(id);
			   ServletUtility.setDto(dto, request);
			} catch (Exception e) {
				log.error(e);
				e.printStackTrace();
				ServletUtility.handleException(e, request, response);
				return;
			}
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("course ctl doget end");
	}

	
	/**
	 *  Submit logic inside it
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("course ctl dopost start");
		System.out.println("inside dopost");
		String op = DataUtility.getString(request.getParameter("operation"));

		long id = DataUtility.getLong(request.getParameter("id"));
		System.out.println(op);
		SubjectModelInt model = ModelFactory.getInstance().getSubjectModel();
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			System.out.println("inside save");
			SubjectDTO dto = (SubjectDTO) populateDTO(request);
			try {
				if (id > 0) {

					model.update(dto);
					ServletUtility.setDto(dto, request);
					ServletUtility.setSuccessMessage("Data in successfully Update", request);
				} else {
					System.out.println("kkkkk+" + id);
					long pk;
					try {
						pk = model.add(dto);
						//ServletUtility.setDto(dto, request);
						ServletUtility.setSuccessMessage("Data in successfully saved", request);
					} catch (DuplicateRecordException e) {
//						ServletUtility.setDto(dto, request);
						ServletUtility.setErrorMessage("subject already exists", request);
					}
				}
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (Exception e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("Unable to add record", request);
			}
		}
//		else if(OP_DELETE.equalsIgnoreCase(op)){
//			SubjectDTO dto=(SubjectDTO) populateDTO(request);
//			try{
//				model.delete(dto);
//				ServletUtility.redirect(getView(), request, response);
//			}catch (ApplicationException e) {
//				log.error(e);
//				ServletUtility.handleException(e, request, response);
//				return;
//			}
//		}
		else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.SUBJECT_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.SUBJECT_LIST_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("course ctl dopost end");
	}

	/**
	 * The getView Method
	 */
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.SUBJECT_VIEW;
	}
}
