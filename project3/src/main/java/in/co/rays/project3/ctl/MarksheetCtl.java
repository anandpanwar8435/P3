package in.co.rays.project3.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project3.dto.BaseDTO;
import in.co.rays.project3.dto.MarksheetDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.model.MarksheetModelInt;
import in.co.rays.project3.model.ModelFactory;
import in.co.rays.project3.model.StudentModelInt;
import in.co.rays.project3.util.DataUtility;
import in.co.rays.project3.util.DataValidator;
import in.co.rays.project3.util.PropertyReader;
import in.co.rays.project3.util.ServletUtility;

/**
 * marksheeet functionality controller.to perform add,delete and update operation
 * @author computer gallery
 *
 */
@WebServlet(urlPatterns = { "/ctl/MarksheetCtl" })
public class MarksheetCtl extends BaseCtl{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(MarksheetCtl.class);

	
	  /**
	 * The preload Method
	 */
	protected void preload(HttpServletRequest request) {
		  StudentModelInt model = ModelFactory.getInstance().getStudentModel();
		  try {
			  List list = model.list();
	  request.setAttribute("studentList", list); 
	  } catch (Exception e) {
	  e.printStackTrace(); log.error(e); 
	  } 
		  }
	 

	/**  
	 * The Validate Method
	 */
	protected boolean validate(HttpServletRequest request) {
		log.debug("marksheet validate bean start");
		System.out.println("marks ctl");
		boolean pass = true;
//		String id = request.getParameter("studentId");
//		System.out.println("kjkljk" + id);
		if (DataValidator.isNull(request.getParameter("roll"))) {
			request.setAttribute("roll", PropertyReader.getValue("error.require", "Roll No"));
			pass = false;
		} else if (!DataValidator.isRollNo(request.getParameter("roll"))) {
			request.setAttribute("roll", "Please Enter Valid Roll No");
			pass = false;
		}
		System.out.println("kmkkkkkkkkkkk" + request.getParameter("studentName"));
		if (DataValidator.isNull(request.getParameter("studentName"))) {
			request.setAttribute("studentName", PropertyReader.getValue("error.require", "Student Name"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("physics"))) {
			request.setAttribute("physics", PropertyReader.getValue("error.require", "physics"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("maths"))) {
			request.setAttribute("maths", PropertyReader.getValue("error.require", "maths "));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("chemistry"))) {
			request.setAttribute("chemistry", PropertyReader.getValue("error.require", "chemistry"));
			pass = false;
		}

		if (DataValidator.isNotNull(request.getParameter("physics"))
				&& !DataValidator.isInteger(request.getParameter("physics"))) {
			request.setAttribute("physics", PropertyReader.getValue("error.integer", "Physics Marks"));
			pass = false;

		}
		if (DataUtility.getInt(request.getParameter("physics")) > 100
				|| DataUtility.getInt(request.getParameter("physics")) < 0) {

			request.setAttribute("physics", "marks must be less than 100 and greater than 0");
			pass = false;
		}
		if (DataValidator.isNotNull(request.getParameter("chemistry"))
				&& !DataValidator.isInteger(request.getParameter("chemistry"))) {
			request.setAttribute("chemistry", PropertyReader.getValue("error.integer", "chemistry marks"));
		}
		if (DataUtility.getInt(request.getParameter("chemistry")) > 100
				|| DataUtility.getInt(request.getParameter("chemistry")) < 0) {

			request.setAttribute("chemistry", "marks less than less than 100 and greater than 0");
			pass = false;
		}
		if (DataValidator.isNotNull(request.getParameter("maths"))
				&& !DataValidator.isInteger(request.getParameter("maths"))) {
			request.setAttribute("maths", PropertyReader.getValue("error.integer", "maths marks"));
			pass = false;
		}
		if (DataUtility.getInt(request.getParameter("maths")) > 100
				|| DataUtility.getInt(request.getParameter("maths")) < 0) {

			request.setAttribute("maths", "marks must be less than 100 and greater than 0");
			pass = false;
		}
		log.debug("marksheet validate bean end");
		return pass;

	}

	/**
	 * The populateDTO Method
	 */
	protected BaseDTO populateDTO(HttpServletRequest request) {
		log.debug("marksheet populate bean start");
		MarksheetDTO dto = new MarksheetDTO();
		String id2=request.getParameter("studentName");
		String id3=id2.trim();
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setRollNo(request.getParameter("roll"));
		
		
//		dto.setStudentId(DataUtility.getLong(request.getParameter("studentName")));
		dto.setStudentId(DataUtility.getLong(id3));
		
		System.out.println("...........--->"+request.getParameter("studentName")+"......."+dto.getRollNo());
		System.out.println(dto.getStudentId()+"here is the id");
		
		dto.setPhysics(DataUtility.getInt(request.getParameter("physics")));
		System.out.println("kkkkkkkkkkk"+dto.getPhysics());
		dto.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));
		dto.setMaths(DataUtility.getInt(request.getParameter("maths")));
		populateDTO(dto, request);
		log.debug("marksheet populate bean end");
		return dto;

	}


	/**
	 * Display Logics
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("marksheet ctl doget  start");
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		MarksheetModelInt model = ModelFactory.getInstance().getMarksheetModel();
		if (id > 0) {
			MarksheetDTO dto;
			try {
				dto = model.findByPk(id);
				ServletUtility.setDto(dto, request);
			} catch (ApplicationException e) {
				e.printStackTrace();
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("marksheet ctl doget  end");
	}

	
	/**
	 * Submit logic 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("marksheet ctl dopost  start");
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		System.out.println("--------"+id);
		MarksheetModelInt model = ModelFactory.getInstance().getMarksheetModel();
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			MarksheetDTO dto = (MarksheetDTO) populateDTO(request);
			try {
				if (id > 0) {
					model.update(dto);
					ServletUtility.setSuccessMessage("Data is successfully Updated", request);
					ServletUtility.setDto(dto, request);
				} else {
					System.out.println("in post method.........." + dto.getRollNo()+"...."+dto.getStudentId());
					
					long pk = model.add(dto);
						dto.setId(pk);
					System.out.println("hmmmmmm" + pk);
					ServletUtility.setSuccessMessage("Data is successfully saved", request);
				}
				

			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("Roll no already exists", request);
			}

		}
//		else if (OP_DELETE.equalsIgnoreCase(op)) {
//			MarksheetDTO dto = (MarksheetDTO) populateDTO(request);
//			try {
//				model.delete(dto);
//				ServletUtility.redirect(ORSView.MARKSHEET_LIST_CTL, request, response);
//				return;
//			} catch (ApplicationException e) {
//				System.out.println("in catch");
//				log.error(e);
//				ServletUtility.handleException(e, request, response);
//				return;
//			}
//
//		}
		else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.MARKSHEET_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.MARKSHEET_LIST_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);

		log.debug("marksheet ctl dopost  end");
	}

	/**
	 * The getView Method
	 */
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.MARKSHEET_VIEW;
	}

}
