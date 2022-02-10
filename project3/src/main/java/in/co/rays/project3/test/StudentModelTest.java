package in.co.rays.project3.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project3.dto.StudentDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.model.StudentModelHibImpl;


public class StudentModelTest {
	public static void main(String[] args) throws ApplicationException, DuplicateRecordException, ParseException {
		//testAdd();             //Done
		// testUpdate();         //Done
		//testDelete();          //Done
		//testfindByPk();        //Done
		// testfindByLogin();    //Done
		// testList();           //Done
		 testsearch();           //Done
	}

	public static void testAdd() throws ApplicationException, DuplicateRecordException, ParseException {
		StudentModelHibImpl m = new StudentModelHibImpl();
		StudentDTO dto = new StudentDTO();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		
		dto.setCollegeId(5);
		dto.setCollegeName("shja");
		dto.setFirstName("Mahendra");
		dto.setLastName("Panwar");
		 dto.setDob(sdf.parse("27-03-1993"));
		dto.setLogin("mahendra@gmail.com");
		dto.setMobileNo("8546792564");
		dto.setCreatedBy("Anand");
		dto.setModifiedBy("Anand");
		dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
		m.add(dto);
	}

	
	  public static void testUpdate() throws ApplicationException, DuplicateRecordException {
		  StudentModelHibImpl m = new StudentModelHibImpl();
		  StudentDTO dto = new StudentDTO();
	    dto.setId((long) (3)); 
	    dto.setCollegeId(6);
		dto.setCollegeName("Aurbindo");
		dto.setFirstName("Sunil");
		dto.setLastName("Sahu");
		dto.setLogin("sunil@gmail.com");
		dto.setMobileNo("7854526454");
		dto.setCreatedBy("Anand");
		dto.setModifiedBy("Anand");
		dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
	  m.update(dto); 
	 
	  }
	  
	 
	   public static void testDelete() throws ApplicationException {
		   StudentModelHibImpl m = new StudentModelHibImpl(); 
		   StudentDTO dto = new StudentDTO();
	  dto.setId((long) (3));
	  m.delete(dto);
	  
	   }
	  
	  
	  public static void testfindByPk() throws ApplicationException {
		  StudentModelHibImpl m = new StudentModelHibImpl();
		  StudentDTO dto = new StudentDTO();
	  dto=m.findByPk(1); 
		
	  System.out.println(dto.getId());
	  System.out.println(dto.getFirstName());
	  System.out.println(dto.getLastName());
	  System.out.println(dto.getLogin());
	  System.out.println(dto.getMobileNo());
	  System.out.println(dto.getDob());
	  System.out.println(dto.getCollegeId());
      System.out.println(dto.getCollegeName()); 
      
		 
	  
	  }
	  
	  public static void testfindByLogin() throws ApplicationException {
		  StudentModelHibImpl m = new StudentModelHibImpl(); 
		  StudentDTO dto = new StudentDTO();
		 dto=m.findByLogin("anil@gmail.com"); 

		  System.out.println(dto.getId());
		  System.out.println(dto.getFirstName());
		  System.out.println(dto.getLastName());
		  System.out.println(dto.getLogin());
		  System.out.println(dto.getMobileNo());
		  System.out.println(dto.getDob());
		  System.out.println(dto.getCollegeId());
	      System.out.println(dto.getCollegeName()); 
	  
	  } 
	  
	  public static void testList() throws ApplicationException {
		  StudentModelHibImpl m = new StudentModelHibImpl(); 
		  StudentDTO dto = new StudentDTO();
	  
	  List list=new ArrayList(); 
	  try { 
		  list=m.list(0, 0);
	  if(list.size()<0) {
	  System.out.println("record not found");
	  
	  }
	  
	  Iterator it=list.iterator();
	  while(it.hasNext()) { 
		  dto= (StudentDTO) it.next(); 
				
		  System.out.println(dto.getId());
		  System.out.println(dto.getFirstName());
		  System.out.println(dto.getLastName());
		  System.out.println(dto.getLogin());
		  System.out.println(dto.getMobileNo());
		  System.out.println(dto.getDob());
		  System.out.println(dto.getCollegeId());
	      System.out.println(dto.getCollegeName()); 
				 
	  
	  } } catch (Exception e) { 
	  e.printStackTrace(); }
	  
	  }
	  
	  public static void testsearch() throws ApplicationException {
		  StudentModelHibImpl m = new StudentModelHibImpl();
		  StudentDTO dto = new StudentDTO();
		  List list=new ArrayList(); 
		 dto=m.findByLogin("rahul@gmail.com");
		  try {
			  list=m.search(dto,0, 0); 
			  if(list.size()<0) {
		  }
			  Iterator it=list.iterator();
			  while(it.hasNext()) { 
				  dto= (StudentDTO) it.next(); 
						
				  System.out.println(dto.getId());
				  System.out.println(dto.getFirstName());
				  System.out.println(dto.getLastName());
				  System.out.println(dto.getLogin());
				  System.out.println(dto.getMobileNo());
				  System.out.println(dto.getDob());
				  System.out.println(dto.getCollegeId());
			      System.out.println(dto.getCollegeName()); 
						 
			  
			  } } catch (Exception e) { 
			  e.printStackTrace(); }
			  
			  } 
	  
}
