package in.co.rays.project3.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project3.dto.TimeTableDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.model.TimeTableModelHibImpl;

public class TimeTableModelTest {
	public static void main(String[] args) throws ApplicationException, DuplicateRecordException, ParseException {
		testAdd();            //Done
		 //testUpdate();        //Done
		 //testDelete();        //Done
		//testfindByPk();       //Done
		// testfindByName();    //Done
		// testList();          //Done
		// testsearch();          //Done
	}

	public static void testAdd() throws ApplicationException, DuplicateRecordException, ParseException {
		TimeTableModelHibImpl m = new TimeTableModelHibImpl();
		TimeTableDTO dto = new TimeTableDTO();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		
		dto.setCourseId(11);
		dto.setSubId(5);
		//dto.setCourseName("M.Com");
		//dto.setSubName("Account");
		dto.setSemester("6");
		dto.setDescription("ghg");
		dto.setExamDate(sdf.parse("18-05-2022"));
		dto.setExamTime("8AM to 11PM");
		dto.setCreatedBy("Anand");
		dto.setModifiedBy("Anand");
		dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
		m.add(dto);
	}


	  public static void testUpdate() throws ApplicationException, DuplicateRecordException, ParseException {
		  TimeTableModelHibImpl m = new TimeTableModelHibImpl();
		  TimeTableDTO dto = new TimeTableDTO();
		  SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		    dto.setId((long) (3));
		    dto.setCourseName("saijk");
			dto.setSubName("jsad");
			dto.setSemester("sad");
			dto.setExamDate(sdf.parse("16-02-2022"));
			dto.setExamTime("9AM to 12PM");
		dto.setCreatedBy("Anand");
		dto.setModifiedBy("Anand");
		dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
	  m.update(dto); 
	 
	  }
	  
	 
	   public static void testDelete() throws ApplicationException {
		   TimeTableModelHibImpl m = new TimeTableModelHibImpl(); 
		   TimeTableDTO dto = new TimeTableDTO();
	  dto.setId((long) (3));
	  m.delete(dto);
	  
	   }
	  
	  
	  public static void testfindByPk() throws ApplicationException {
		  TimeTableModelHibImpl m = new TimeTableModelHibImpl();
		  TimeTableDTO dto = new TimeTableDTO();
	  dto=m.findByPk(1); 
		
	  System.out.println(dto.getId());
	  System.out.println(dto.getSubId());
	  System.out.println(dto.getCourseId());
	  System.out.println(dto.getSubName());
	  System.out.println(dto.getCourseName()); 
	  System.out.println(dto.getDescription());
	  System.out.println(dto.getExamDate());
	  System.out.println(dto.getSemester());
	  System.out.println(dto.getExamTime());
		 
	  
	  }
	  
	/*
	 * public static void testfindByName() throws ApplicationException {
	 * TimeTableModelHibImpl m = new TimeTableModelHibImpl(); TimeTableDTO dto = new
	 * TimeTableDTO(); dto=m.findBySubjectName("Computer");
	 * System.out.println(dto.getCourseName());
	 * 
	 * 
	 * }
	 */
	  
	  public static void testList() throws ApplicationException {
		  TimeTableModelHibImpl m = new TimeTableModelHibImpl(); 
		  TimeTableDTO dto = new TimeTableDTO();
	  
	  List list=new ArrayList(); 
	  try {
		  list=m.list(0, 0);
		  if(list.size()<0) {
	  System.out.println("record not found");
	  
	  }
	  
	  Iterator it=list.iterator();
	  while(it.hasNext()) { 
		  dto= (TimeTableDTO) it.next(); 
				
		  System.out.println(dto.getId());
		  System.out.println(dto.getSubId());
		  System.out.println(dto.getCourseId());
		  System.out.println(dto.getSubName());
		  System.out.println(dto.getCourseName()); 
		  System.out.println(dto.getDescription());
		  System.out.println(dto.getExamDate());
		  System.out.println(dto.getSemester());
		  System.out.println(dto.getExamTime());
				 
	  
	  } } catch (Exception e) { 
	  e.printStackTrace(); }
	  
	  }
	  
	  public static void testsearch() throws ApplicationException {
		  TimeTableModelHibImpl m = new TimeTableModelHibImpl();
		  TimeTableDTO dto = new TimeTableDTO();
		  List list=new ArrayList(); 
		  dto=m.findByPk(1);
		  try {
			  list=m.search(dto,0, 0); 
			  if(list.size()<0) {
		  }
			  Iterator it=list.iterator();
			  while(it.hasNext()) { 
				  dto= (TimeTableDTO) it.next(); 
						
				  System.out.println(dto.getId());
				  System.out.println(dto.getSubId());
				  System.out.println(dto.getCourseId());
				  System.out.println(dto.getSubName());
				  System.out.println(dto.getCourseName()); 
				  System.out.println(dto.getDescription());
				  System.out.println(dto.getExamDate());
				  System.out.println(dto.getSemester());
				  System.out.println(dto.getExamTime());
						 
			  
			  } } catch (Exception e) { 
			  e.printStackTrace(); }
			  
			  }
}
