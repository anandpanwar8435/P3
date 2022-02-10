package in.co.rays.project3.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project3.dto.CourseDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.model.CourseModelHibImpl;

public class CourseModelTest {
	public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
		testAdd();           //Done
		// testUpdate();       //Done
		// testDelete();       //Done
		// testfindByPk();     //Done
		// testfindByName();   //Done
		// testList();         //Done
		// testsearch();         //Done
	}

	public static void testAdd() throws ApplicationException, DuplicateRecordException {
		CourseModelHibImpl m = new CourseModelHibImpl();
		CourseDTO dto = new CourseDTO();
		dto.setCourseName("CS");
		dto.setDescription("jnbn");
		dto.setDuration("2 years");
		dto.setCreatedBy("Anand");
		dto.setModifiedBy("Anand");
		dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
		m.add(dto);
	}

	public static void testUpdate() throws ApplicationException, DuplicateRecordException { 
		 CourseModelHibImpl m = new CourseModelHibImpl();
		 CourseDTO dto = new CourseDTO(); 
		 dto.setId((long)(3));
		 dto.setCourseName("DF"); 
		 dto.setDescription("kasdj");
		 m.update(dto);
		 
}


  public static void testDelete() throws ApplicationException {
	  CourseModelHibImpl m = new CourseModelHibImpl();
	  CourseDTO dto = new CourseDTO(); 
	  dto.setId((long)(3)); 
	  m.delete(dto); }
 
  
 public static void testfindByPk() throws ApplicationException {
	 CourseModelHibImpl m = new CourseModelHibImpl();
	 CourseDTO dto = new CourseDTO();
    
	 dto=m.findByPk(1);
    
	 System.out.println(dto.getId());
	 System.out.println(dto.getCourseName());
     System.out.println(dto.getDescription());
     System.out.println(dto.getDuration());
     
  }
  
 public static void testfindByName() throws ApplicationException {
	 CourseModelHibImpl m = new CourseModelHibImpl();
	 CourseDTO dto = new CourseDTO();
     dto=m.findByCourseName("CS");
    if(dto==null)  {
    	System.out.println("Course name Not found");
		
	}else {
		 System.out.println(dto.getId());
		 System.out.println(dto.getCourseName());
	     System.out.println(dto.getDescription());
	     System.out.println(dto.getDuration());
	}
	}
    		
 public static void testList() throws ApplicationException { 
	 CourseModelHibImpl m = new CourseModelHibImpl(); 
	 CourseDTO dto = new CourseDTO();
   List list=new ArrayList();
   try {
	  list=m.list(1, 10); 
	  if(list.size()<0) {
   System.out.println("record not found");
 
  }
	  Iterator it=list.iterator(); 
	  while(it.hasNext()) {
		  dto= (CourseDTO)
  it.next(); 
		 
		     System.out.println(dto.getId());
			 System.out.println(dto.getCourseName());
		     System.out.println(dto.getDescription());
		     System.out.println(dto.getDuration());
  
  } } catch (Exception e) { 
  e.printStackTrace(); }
  
 }
  
  public static void testsearch() throws ApplicationException {
	  CourseModelHibImpl m = new CourseModelHibImpl(); 
	  CourseDTO dto = new CourseDTO(); 
	  List list=new ArrayList();
	   dto=m.findByCourseName("CS");
	   try {
		  list=m.search(dto,0, 0); 
		  if(list.size()<0) {
	   System.out.println("record not found");
	 
	  }
		  Iterator it=list.iterator(); 
		  while(it.hasNext()) {
			  dto= (CourseDTO) it.next();
			  
			     System.out.println(dto.getId());
				 System.out.println(dto.getCourseName());
			     System.out.println(dto.getDescription());
			     System.out.println(dto.getDuration());
	  
	  } } catch (Exception e) { 
	  e.printStackTrace(); }
	  
	 }
  
  }
  
  
 
