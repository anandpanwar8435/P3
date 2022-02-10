package in.co.rays.project3.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project3.dto.CollegeDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.model.CollegeModelHibImp;


public class CollegeModelTest {
	
	public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
		//testAdd();            //Done
		// testUpdate();        //Done
		//testDelete();         //Done
		//testfindByPk();       //Done
		// testfindByName();    //Done
		 testList();            //Done
		// testsearch();        //Done
	}

	public static void testAdd() throws ApplicationException, DuplicateRecordException {
		CollegeModelHibImp m = new CollegeModelHibImp();
		CollegeDTO dto = new CollegeDTO();
		// dto.setId((long) (5));
		dto.setName("MANIT");
		dto.setAddress("Bhopal");
		dto.setState("MP");
		dto.setCity("Bhopal");
		dto.setCreatedBy("Anand");
		dto.setModifiedBy("Anand");
		dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
		m.add(dto);
	}

	
	  public static void testUpdate() throws ApplicationException, DuplicateRecordException {
		  CollegeModelHibImp m = new CollegeModelHibImp();
		  CollegeDTO dto = new CollegeDTO();
	    dto.setId((long) (1)); 
	    dto.setName("Bansal");
		dto.setAddress("Bhopal");
		dto.setState("MP");
		dto.setCity("Bhopal");
		dto.setPhoneNo("8845454454");
		dto.setCreatedBy("Anand");
		dto.setModifiedBy("Anand");
		dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
	  m.update(dto); 
	 
	  }
	  
	 
	   public static void testDelete() throws ApplicationException {
		   CollegeModelHibImp m = new CollegeModelHibImp(); 
		   CollegeDTO dto = new CollegeDTO();
	  dto.setId((long) (3));
	  m.delete(dto);
	  
	   }
	  
	  
	  public static void testfindByPk() throws ApplicationException {
		  CollegeModelHibImp m = new CollegeModelHibImp();
		  CollegeDTO dto = new CollegeDTO();
	     
		  dto=m.findByPk(2);
	  
		  System.out.println(dto.getId());
	      System.out.println(dto.getName()); 
	      System.out.println(dto.getAddress());
	      System.out.println(dto.getState());
	      System.out.println(dto.getCity());
	      System.out.println(dto.getPhoneNo());
	  
	  }
	  
	  public static void testfindByName() throws ApplicationException {
		  CollegeModelHibImp m = new CollegeModelHibImp(); 
		  CollegeDTO dto = new CollegeDTO();
		 dto=m.findByName("MITS"); 
	  
		  System.out.println(dto.getId());
	      System.out.println(dto.getName()); 
	      System.out.println(dto.getAddress());
	      System.out.println(dto.getState());
	      System.out.println(dto.getCity());
	      System.out.println(dto.getPhoneNo());
	 
	  } 
	  
	  public static void testList() throws ApplicationException {
		  CollegeModelHibImp m = new CollegeModelHibImp(); 
		  CollegeDTO dto = new CollegeDTO();
	  
	  List list=new ArrayList(); 
	  try {
		  list=m.list(1, 10);
	  if(list.size()<0) {
	  System.out.println("record not found");
	  
	  }
	  
	  Iterator it=list.iterator();
	  while(it.hasNext()) { 
		  dto= (CollegeDTO) it.next(); 
				
		  System.out.println(dto.getId());
	      System.out.println(dto.getName()); 
	      System.out.println(dto.getAddress());
	      System.out.println(dto.getState());
	      System.out.println(dto.getCity());
	      System.out.println(dto.getPhoneNo());
				 
	  
	  } } catch (Exception e) { 
	  e.printStackTrace(); }
	  
	  }
	  
	  public static void testsearch() throws ApplicationException {
		  CollegeModelHibImp m = new CollegeModelHibImp();
		  CollegeDTO dto = new CollegeDTO();
		  List list=new ArrayList(); 
		  dto=m.findByName("Bansal");
		  try {
			  list=m.search(dto,0, 0); 
			  if(list.size()<0) {
		  }
			  Iterator it=list.iterator();
			  while(it.hasNext()) { 
				  dto= (CollegeDTO) it.next(); 
						
				  System.out.println(dto.getId());
			      System.out.println(dto.getName()); 
			      System.out.println(dto.getAddress());
			      System.out.println(dto.getState());
			      System.out.println(dto.getCity());
			      System.out.println(dto.getPhoneNo());
						 
			  
			  } } catch (Exception e) { 
			  e.printStackTrace(); }
			  
			  } 
	  
	  }
	 