package in.co.rays.project3.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project3.dto.SubjectDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.model.SubjectModelHibImpl;


public class SubjectModelTest {


public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
	//testAdd();             //Done
	 //testUpdate();         //Done
	 //testDelete();         //Done
	//testfindByPk();        //Done
	// testfindByName();     //Done
	// testList();           //Done
	 testsearch();           //Done
}

public static void testAdd() throws ApplicationException, DuplicateRecordException {
	SubjectModelHibImpl m = new SubjectModelHibImpl();
	SubjectDTO dto = new SubjectDTO();
	
	dto.setSubjectName("Account");
	dto.setDescription("sayuj");
	dto.setCourseName("B.Com");
	dto.setCourseId(8);
	dto.setSubjectId(9);
	dto.setCreatedBy("Anand");
	dto.setModifiedBy("Anand");
	dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
	dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
	m.add(dto);
}


  public static void testUpdate() throws ApplicationException, DuplicateRecordException {
	  SubjectModelHibImpl m = new SubjectModelHibImpl();
	  SubjectDTO dto = new SubjectDTO();
    dto.setId((long) (3)); 
    dto.setSubjectName("hhhhh");
	dto.setDescription("hgAHb");
	dto.setCourseName("BE");
	dto.setCourseId(1);
	dto.setSubjectId(4);
	dto.setCreatedBy("Anand");
	dto.setModifiedBy("Anand");
	dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
	dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
  m.update(dto); 
 
  }
  
 
   public static void testDelete() throws ApplicationException {
	   SubjectModelHibImpl m = new SubjectModelHibImpl(); 
	   SubjectDTO dto = new SubjectDTO();
  dto.setId((long) (3));
  m.delete(dto);
  
   }
  
  
  public static void testfindByPk() throws ApplicationException {
	  SubjectModelHibImpl m = new SubjectModelHibImpl();
	  SubjectDTO dto = new SubjectDTO();
  dto=m.findByPk(1); 
	
  System.out.println(dto.getId()); 
  System.out.println(dto.getSubjectId()); 
  System.out.println(dto.getSubjectName()); 
  System.out.println(dto.getCourseName());
  System.out.println(dto.getDescription());
  System.out.println(dto.getCourseId()); 
 
	 
  
  }
  
  public static void testfindByName() throws ApplicationException {
	  SubjectModelHibImpl m = new SubjectModelHibImpl(); 
	  SubjectDTO dto = new SubjectDTO();
	 dto=m.findBySubjectName("Computer"); 

	  System.out.println(dto.getId()); 
	  System.out.println(dto.getSubjectId()); 
	  System.out.println(dto.getSubjectName()); 
	  System.out.println(dto.getCourseName());
	  System.out.println(dto.getDescription());
	  System.out.println(dto.getCourseId()); 
  
  
  } 
  
  public static void testList() throws ApplicationException {
	  SubjectModelHibImpl m = new SubjectModelHibImpl(); 
	  SubjectDTO dto = new SubjectDTO();
  
  List list=new ArrayList(); 
  try { 
	  list=m.list(1, 10);
	  if(list.size()<0) {
  System.out.println("record not found");
  
  }
  
  Iterator it=list.iterator();
  while(it.hasNext()) { 
	  dto= (SubjectDTO) it.next(); 
			
	  System.out.println(dto.getId()); 
	  System.out.println(dto.getSubjectId()); 
	  System.out.println(dto.getSubjectName()); 
	  System.out.println(dto.getCourseName());
	  System.out.println(dto.getDescription());
	  System.out.println(dto.getCourseId()); 
			 
  
  } } catch (Exception e) { 
  e.printStackTrace(); }
  
  }
  
  public static void testsearch() throws ApplicationException {
	  SubjectModelHibImpl m = new SubjectModelHibImpl();
	  SubjectDTO dto = new SubjectDTO();
	  List list=new ArrayList(); 
	  dto=m.findBySubjectName("English");
	  try {
		  list=m.search(dto,0, 0); 
		  if(list.size()<0) {
	  }
		  Iterator it=list.iterator();
		  while(it.hasNext()) { 
			  dto= (SubjectDTO) it.next(); 
					
			  System.out.println(dto.getId()); 
			  System.out.println(dto.getSubjectId()); 
			  System.out.println(dto.getSubjectName()); 
			  System.out.println(dto.getCourseName());
			  System.out.println(dto.getDescription());
			  System.out.println(dto.getCourseId()); 
					 
		  
		  } } catch (Exception e) { 
		  e.printStackTrace(); }
		  
		  }
  }