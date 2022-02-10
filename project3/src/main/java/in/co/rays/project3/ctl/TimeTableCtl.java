package in.co.rays.project3.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project3.dto.BaseDTO;
import in.co.rays.project3.dto.TimeTableDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DatabaseException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.exception.RecordNotFoundException;
import in.co.rays.project3.model.CourseModelInt;
import in.co.rays.project3.model.ModelFactory;
import in.co.rays.project3.model.SubjectModelInt;
import in.co.rays.project3.model.TimeTableModelInt;
import in.co.rays.project3.util.DataUtility;
import in.co.rays.project3.util.DataValidator;
import in.co.rays.project3.util.PropertyReader;
import in.co.rays.project3.util.ServletUtility;

/**
 * TimeTable functionality controller.to perform add,delete and update operation.
 * @author computer gallery
 *
 */
@WebServlet(urlPatterns={"/ctl/TimeTableCtl"})
public class TimeTableCtl extends BaseCtl{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(TimeTableCtl.class);

	/**
	 * The preload Method
	 */
	protected void preload(HttpServletRequest request) {
		CourseModelInt model = ModelFactory.getInstance().getCourseModel();
		SubjectModelInt  model1 = ModelFactory.getInstance().getSubjectModel();
		try {
			List l = model.list();
			List l1 = model1.list();
			request.setAttribute("courseList", l);
			request.setAttribute("subjectList", l1);
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * The validate Method
	 */
	protected boolean validate(HttpServletRequest request) {
		log.debug("time table validate start");
		boolean pass = true;
	//	String examDate = request.getParameter("examDate");
		System.out.println("hmmmmmmmmmmm"+pass);
		if (DataValidator.isNull(request.getParameter("description"))) {
			request.setAttribute("description", PropertyReader.getValue("error.require", "Description"));
			pass = false;
		}
		System.out.println("kkkkkkk"+pass);
		if (DataValidator.isNull(request.getParameter("courseId"))) {
			request.setAttribute("courseId", PropertyReader.getValue("error.require", "Course Name"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("subId"))) {
			request.setAttribute("subId", PropertyReader.getValue("error.require", "Subject Name"));
			pass = false;
		}
		

		if (DataValidator.isNull(request.getParameter("semester"))) {
			request.setAttribute("semester", PropertyReader.getValue("error.require", "Semester"));
			pass = false;
		}

		if (DataValidator.isNull( request.getParameter("examDate"))) {
			request.setAttribute("examDate", PropertyReader.getValue("error.require", "Exam Date"));
			pass = false;
		} /*
			 * else if (!DataValidator.isDate(request.getParameter("examDate"))) {
			 * request.setAttribute("examDate", PropertyReader.getValue("error.date",
			 * "Exam Date")); pass = false; }
			 */
			 
		if (DataValidator.isNull(request.getParameter("examId"))) {
			request.setAttribute("examId", PropertyReader.getValue("error.require", "Exam Time"));
			pass = false;
		}
		log.debug("time table validate end");
		System.out.println("kjkj>>>>" + pass);
		return pass;
	}

	/**
	 * The populateDTO Method
	 */
	protected BaseDTO populateDTO(HttpServletRequest request) {
		log.debug("time table populate start");
		TimeTableDTO dto = new TimeTableDTO();
		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setCourseId(DataUtility.getLong(request.getParameter("courseId")));
		System.out.println(request.getParameter("courseId")+"&&&&&&&&&&&&&&&&&&&&&&&");
		dto.setDescription(DataUtility.getString(request.getParameter("description")));
		dto.setSemester(DataUtility.getString(request.getParameter("semester")));
		System.out.println(request.getParameter("semester")+"###################");
		dto.setSubId(DataUtility.getLong(request.getParameter("subId")));
		System.out.println(request.getParameter("subId")+"%%%%%%%%%%%%%%%%%%%");
		dto.setExamDate(DataUtility.getDate(request.getParameter("examDate")));
		dto.setExamTime(DataUtility.getString(request.getParameter("examId")));
		populateDTO(dto,request);
		log.debug("time table populate end");
		System.out.println("<<<>>>>>>++.." + dto);
		
		return dto;
	}

	
	/**
	 * Display Logics inside this method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.debug("time table do get start");
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		TimeTableModelInt model =ModelFactory.getInstance().getTimeTableModel() ;
		if (id > 0 || op != null) {
			TimeTableDTO dto;
			try {
				dto = model.findByPk(id);
				ServletUtility.setDto(dto, request);
			} catch (Exception e) {
				e.printStackTrace();
				log.debug(e);
				ServletUtility.handleException(e, request, response);
				return;
			}

		}
		ServletUtility.forward(getView(), request, response);
		log.debug("time table doget end");
	}

	
	/**
	 * Submit logic inside it
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String op = DataUtility.getString(request.getParameter("operation"));
		// get model

		TimeTableModelInt model = ModelFactory.getInstance().getTimeTableModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			TimeTableDTO dto = (TimeTableDTO) populateDTO(request);
			try {
				if (id > 0) {
					
						model.update(dto);
					    ServletUtility.setDto(dto, request);
					    ServletUtility.setSuccessMessage("Data is successfully updated", request);
				} else {
					long pk = model.add(dto);
					///// bean.setId(pk);

					ServletUtility.setSuccessMessage("Data is successfully added", request);
				}
			} catch (ApplicationException e) {
				log.error(e);
				e.printStackTrace();
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("TimeTable is already exists", request);
			}
			/*
			 * catch (DatabaseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } catch (RecordNotFoundException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
			/*
			 * } else if (OP_DELETE.equalsIgnoreCase(op)) {
			 * 
			 * TimeTableDTO bean = (TimeTableDTO) populateDTO(request); try {
			 * model.delete(bean); ServletUtility.redirect(ORSView.TIMETABLE_LIST_CTL,
			 * request, response); return; } catch (ApplicationException e) { log.error(e);
			 * ServletUtility.handleException(e, request, response); return; }
			 */

		} else if (OP_RESET.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.TIMETABLE_CTL, request, response);
			return;

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.TIMETABLE_LIST_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);

		log.debug("TimeTableCtl Method doPost Ended");
		}
	/**
	 * The getView Method
	 */
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.TIMETABLE_VIEW;
	}
}
