package in.co.rays.project3.test;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project3.dto.UserDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.model.UserModelHibImpl;

public class UserModelTest {

	public static void main(String[] args) throws ApplicationException, DuplicateRecordException, ParseException {
		testAdd();             //Done
		// testUpdate();         //Done
		//  testDelete();        //Done
		// testfindByPk();       //Done
		// testfindByLogin();    //Done
		// testList();           //Done
		// testsearch();         //Done
	}

	public static void testAdd() throws ApplicationException, ParseException, DuplicateRecordException {
		UserModelHibImpl m = new UserModelHibImpl();
		UserDTO dto = new UserDTO();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		// dto.setId((long) (5));
		dto.setFirstName("Anand");
		dto.setLastName("Panwar");
		dto.setGender("Male");
		dto.setDob(sdf.parse("05-11-1995"));
	    dto.setRoleId(1);
		dto.setMobileNo("8854698523");
		dto.setLogin("anand843599@gmail.com");
		dto.setPassword("Anand@12345");
		dto.setConfirmPassword("Anand@12345");
		dto.setCreatedBy("Anand");
		dto.setModifiedBy("Anand");
		dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
		m.add(dto);
	}

	
	  public static void testUpdate() throws ApplicationException, DuplicateRecordException, ParseException {
	  UserModelHibImpl m = new UserModelHibImpl();
	  UserDTO dto = new UserDTO();
	  SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
	  dto.setId((long) (1)); 
	  dto.setFirstName("Sunil");
		dto.setLastName("Mehta");
		dto.setGender("Male");
		dto.setDob(sdf.parse("20-12-2001"));
		dto.setRoleId(2);
		dto.setMobileNo("9945851584");
		dto.setLogin("sunilil@gmail.com");
		dto.setPassword("sunilil@123");
		dto.setConfirmPassword("sunilil@123");
		dto.setCreatedBy("Anand");
		dto.setModifiedBy("Anand");
		dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
	  m.update(dto); 
	 
	  }
	  
	 
	   public static void testDelete() throws ApplicationException {
	  UserModelHibImpl m = new UserModelHibImpl(); 
	  UserDTO dto = new UserDTO();
	  dto.setId((long) (1));
	  m.delete(dto);
	  
	   }
	  
	  
	  public static void testfindByPk() throws ApplicationException {
	  UserModelHibImpl m = new UserModelHibImpl();
	  UserDTO dto = new UserDTO();
	  dto=m.findByPk(2); 
		
	  System.out.println(dto.getId()); 
      System.out.println(dto.getFirstName()); 
      System.out.println(dto.getLastName());
      System.out.println(dto.getLogin()); 
      System.out.println(dto.getPassword());
      System.out.println(dto.getDob()); 
      System.out.println(dto.getMobileNo()); 
      System.out.println(dto.getGender()); 
		 
	  
	  }
	  
	  public static void testfindByLogin() throws ApplicationException {
	  UserModelHibImpl m = new UserModelHibImpl(); 
	  UserDTO dto = new UserDTO();
		 dto=m.findByLogin("anand2@gmail.com"); 


		  System.out.println(dto.getId()); 
	      System.out.println(dto.getFirstName()); 
	      System.out.println(dto.getLastName());
	      System.out.println(dto.getLogin()); 
	      System.out.println(dto.getPassword());
	      System.out.println(dto.getDob()); 
	      System.out.println(dto.getMobileNo()); 
	      System.out.println(dto.getGender()); 
	  
	  } 
	  
	  public static void testList() throws ApplicationException {
	  UserModelHibImpl m = new UserModelHibImpl(); 
	  UserDTO dto = new UserDTO();
	  
	  List list=new ArrayList(); 
	  try { 
		  list=m.list(1, 10); 
		  if(list.size()<0) {
	  System.out.println("record not found");
	  
	  }
	  
	  Iterator it=list.iterator();
	  while(it.hasNext()) { 
		  dto= (UserDTO) it.next(); 
				
		  System.out.println(dto.getId()); 
	      System.out.println(dto.getFirstName()); 
	      System.out.println(dto.getLastName());
	      System.out.println(dto.getLogin()); 
	      System.out.println(dto.getPassword());
	      System.out.println(dto.getDob()); 
	      System.out.println(dto.getMobileNo()); 
	      System.out.println(dto.getGender()); 
				 
	  
	  } } catch (Exception e) { // TODO Auto-generated catch block
	  e.printStackTrace(); }
	  
	  }
	  
	  public static void testsearch() throws ApplicationException {
	  UserModelHibImpl m = new UserModelHibImpl();
	  UserDTO dto = new UserDTO();
	  List list=new ArrayList(); 
	  dto=m.findByLogin("anand@gmail.com");
	  try {
		  list=m.search(dto,0, 0); 
		  if(list.size()<0) {
	  }
		  Iterator it=list.iterator();
		  while(it.hasNext()) { 
			  dto= (UserDTO) it.next(); 
					
			  System.out.println(dto.getId()); 
		      System.out.println(dto.getFirstName()); 
		      System.out.println(dto.getLastName());
		      System.out.println(dto.getLogin()); 
		      System.out.println(dto.getPassword());
		      System.out.println(dto.getDob()); 
		      System.out.println(dto.getMobileNo()); 
		      System.out.println(dto.getGender()); 
		      
					  }
		  } catch (Exception e) { 
		  e.printStackTrace(); }
		
	  
	  }
	 
}
