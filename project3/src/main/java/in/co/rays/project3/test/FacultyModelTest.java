package in.co.rays.project3.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import in.co.rays.project3.dto.FacultyDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;

import in.co.rays.project3.model.FacultyModelHibImpl;


public class FacultyModelTest {
	public static void main(String[] args) throws ApplicationException, DuplicateRecordException, ParseException {
		testAdd();             // Done
		// testUpdate();         //Done
		//testDelete();          //Done
		//testfindByPk();        //Done
		// testfindByLogin();    //Done
		// testList();           //Done
		// testsearch();           //Done
	}

	public static void testAdd() throws ApplicationException, ParseException, DuplicateRecordException {
		FacultyModelHibImpl m = new FacultyModelHibImpl();
		FacultyDTO dto = new FacultyDTO();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		// dto.setId((long) (5));
		dto.setFirstName("Karan");
		dto.setLastName("Singh");
	    dto.setGender("Male");
	    dto.setDob(sdf.parse("06-12-1988"));
	    dto.setQualification("M.Com");
	    dto.setLogin("karan@gmail.com");
	    dto.setMobileNo("7789561265");
	    dto.setCollegeId(5);
	    dto.setCourseId(2);
	    dto.setSubjectId(5);
	    dto.setCollegeName("Aurbindo");
	    dto.setSubjectName("Account");
		dto.setCourseName("M.Com");
		dto.setCreatedBy("Anand");
		dto.setModifiedBy("Anand");
		dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
		m.add(dto);
	}

	
	  public static void testUpdate() throws ApplicationException, DuplicateRecordException, ParseException {
		  FacultyModelHibImpl m = new FacultyModelHibImpl();
		  FacultyDTO dto = new FacultyDTO();
	    SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		
	    dto.setId((long) (1));
		dto.setFirstName("yu");
		dto.setLastName("Verma");
	    dto.setGender("Male");
	    dto.setDob(sdf.parse("11-07-1998"));
	    dto.setQualification("CS");
	    dto.setLogin("hema45345@gmail.com");
	    dto.setMobileNo("9984569821");
	    dto.setCollegeId(9);
	    dto.setCourseId(3);
	    dto.setSubjectId(6);
	    dto.setCollegeName("Lodha");
	    dto.setSubjectName("Math");
		dto.setCourseName("CS");
		dto.setCreatedBy("Anand");
		dto.setModifiedBy("Anand");
		dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
	    m.update(dto); 
	 
	  }
	  
	 
	   public static void testDelete() throws ApplicationException {
		   FacultyModelHibImpl m = new FacultyModelHibImpl(); 
		   FacultyDTO dto = new FacultyDTO();
	  dto.setId((long) (3));
	  m.delete(dto);
	  
	   }
	  
	  
	  public static void testfindByPk() throws ApplicationException {
		  FacultyModelHibImpl m = new FacultyModelHibImpl();
		  FacultyDTO dto = new FacultyDTO();
	  dto=m.findByPk(1); 
	 
	  System.out.println(dto.getId());
	  System.out.println(dto.getFirstName());
	  System.out.println(dto.getLastName());
	  System.out.println(dto.getGender());
	  System.out.println(dto.getQualification());
	  System.out.println(dto.getMobileNo());
	  System.out.println(dto.getLogin());
	  System.out.println(dto.getDob());
	  System.out.println(dto.getCollegeId());
	  System.out.println(dto.getCourseId());
	  System.out.println(dto.getSubjectId());
	  System.out.println(dto.getCollegeName());
      System.out.println(dto.getCourseName()); 
      System.out.println(dto.getSubjectName());
     
		 
	   }
	  
	  public static void testfindByLogin() throws ApplicationException {
		  FacultyModelHibImpl m = new FacultyModelHibImpl(); 
		  FacultyDTO dto = new FacultyDTO();
		 dto=m.findByLogin("anand@gmail.com"); 
	 
		  System.out.println(dto.getId());
		  System.out.println(dto.getFirstName());
		  System.out.println(dto.getLastName());
		  System.out.println(dto.getGender());
		  System.out.println(dto.getQualification());
		  System.out.println(dto.getMobileNo());
		  System.out.println(dto.getLogin());
		  System.out.println(dto.getDob());
		  System.out.println(dto.getCollegeId());
		  System.out.println(dto.getCourseId());
		  System.out.println(dto.getSubjectId());
		  System.out.println(dto.getCollegeName());
	      System.out.println(dto.getCourseName()); 
	      System.out.println(dto.getSubjectName());
	  
	  
	  } 
	  
	  public static void testList() throws ApplicationException {
		  FacultyModelHibImpl m = new FacultyModelHibImpl(); 
		  FacultyDTO dto = new FacultyDTO();
	  
	  List list=new ArrayList(); 
	  try {
		  list=m.list(0, 0);
	  if(list.size()<0) {
	  System.out.println("record not found");
	  
	  }
	  
	  Iterator it=list.iterator();
	  while(it.hasNext()) { 
		  dto= (FacultyDTO) it.next();  
				
		  System.out.println(dto.getId());
		  System.out.println(dto.getFirstName());
		  System.out.println(dto.getLastName());
		  System.out.println(dto.getGender());
		  System.out.println(dto.getQualification());
		  System.out.println(dto.getMobileNo());
		  System.out.println(dto.getLogin());
		  System.out.println(dto.getDob());
		  System.out.println(dto.getCollegeId());
		  System.out.println(dto.getCourseId());
		  System.out.println(dto.getSubjectId());
		  System.out.println(dto.getCollegeName());
	      System.out.println(dto.getCourseName()); 
	      System.out.println(dto.getSubjectName());
				 
	    }
	  } catch (Exception e) { 
	  e.printStackTrace(); }
	  
	  }
	  
	  public static void testsearch() throws ApplicationException {
		  FacultyModelHibImpl m = new FacultyModelHibImpl();
		  FacultyDTO dto = new FacultyDTO();
		  List list=new ArrayList(); 
		dto=m.findByLogin("anand@gmail.com");
		  try {
			  list=m.search(dto,0, 0); 
			  if(list.size()<0) {
		  }
			  Iterator it=list.iterator();
			  while(it.hasNext()) { 
				  dto= (FacultyDTO) it.next(); 
						
				  System.out.println(dto.getId());
				  System.out.println(dto.getFirstName());
				  System.out.println(dto.getLastName());
				  System.out.println(dto.getGender());
				  System.out.println(dto.getQualification());
				  System.out.println(dto.getMobileNo());
				  System.out.println(dto.getLogin());
				  System.out.println(dto.getDob());
				  System.out.println(dto.getCollegeId());
				  System.out.println(dto.getCourseId());
				  System.out.println(dto.getSubjectId());
				  System.out.println(dto.getCollegeName());
			      System.out.println(dto.getCourseName()); 
			      System.out.println(dto.getSubjectName());
						 
			  
			  } } catch (Exception e) { 
			  e.printStackTrace(); }
			  
			  } 
	  
}
