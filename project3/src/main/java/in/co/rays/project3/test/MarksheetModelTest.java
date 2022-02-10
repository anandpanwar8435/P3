package in.co.rays.project3.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project3.dto.MarksheetDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.model.MarksheetModelHibImpl;


public class MarksheetModelTest {
	public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
		//testAdd();            //Done
		// testUpdate();        //Done
		//testDelete();         //Done
		//testfindByPk();       //Done
		// testfindByRollNo();  //Done
		 testList();            //Done
		// testsearch();        //Done
	}

	public static void testAdd() throws ApplicationException, DuplicateRecordException {
		MarksheetModelHibImpl m = new MarksheetModelHibImpl();
		MarksheetDTO dto = new MarksheetDTO();
		
		dto.setRollNo("ME1002");
		dto.setStudentId(5);
		dto.setName("rhbj");
		dto.setMaths(78);
		dto.setPhysics(46);
		dto.setChemistry(89);
		dto.setCreatedBy("Anand");
		dto.setModifiedBy("Anand");
		dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
		m.add(dto);
	}

	
	  public static void testUpdate() throws ApplicationException, DuplicateRecordException {
		  MarksheetModelHibImpl m = new MarksheetModelHibImpl();
		  MarksheetDTO dto = new MarksheetDTO();
		
	    dto.setId((long) (1));
	    dto.setRollNo("CS1001");
		dto.setStudentId(1);
		dto.setName("Anand");
		dto.setMaths(91);
		dto.setPhysics(95);
		dto.setChemistry(89);
		dto.setCreatedBy("Anand");
		dto.setModifiedBy("Anand");
		dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
	    m.update(dto); 
	 
	  }
	  
	 
	   public static void testDelete() throws ApplicationException {
		   MarksheetModelHibImpl m = new MarksheetModelHibImpl(); 
		   MarksheetDTO dto = new MarksheetDTO();
	  dto.setId((long) (3));
	  m.delete(dto);
	  
	   }
	  
	  
	  public static void testfindByPk() throws ApplicationException {
		  MarksheetModelHibImpl m = new MarksheetModelHibImpl();
		  MarksheetDTO dto = new MarksheetDTO();
	  dto=m.findByPk(1); 
	 
	  System.out.println(dto.getId());
	  System.out.println(dto.getRollNo());
      System.out.println(dto.getName());
      System.out.println(dto.getStudentId());
      System.out.println(dto.getPhysics());
      System.out.println(dto.getChemistry());
      System.out.println(dto.getMaths());
     
		 
	   }
	  
	  public static void testfindByRollNo() throws ApplicationException {
		  MarksheetModelHibImpl m = new MarksheetModelHibImpl(); 
		  MarksheetDTO dto = new MarksheetDTO();
		 dto=m.findByRollNo("CS1002"); 
	 
		  System.out.println(dto.getId());
		  System.out.println(dto.getRollNo());
	      System.out.println(dto.getName());
	      System.out.println(dto.getStudentId());
	      System.out.println(dto.getPhysics());
	      System.out.println(dto.getChemistry());
	      System.out.println(dto.getMaths());
	  
	  } 
	  
	  public static void testList() throws ApplicationException {
		  MarksheetModelHibImpl m = new MarksheetModelHibImpl(); 
		  MarksheetDTO dto = new MarksheetDTO();
	  
	  List list=new ArrayList(); 
	  try { 
		  list=m.list(1, 10); 
	  if(list.size()<0) {
	  System.out.println("record not found");
	  
	  }
	  
	  Iterator it=list.iterator();
	  while(it.hasNext()) { 
		  dto= (MarksheetDTO) it.next(); 
				
		  System.out.println(dto.getId());
		  System.out.println(dto.getRollNo());
	      System.out.println(dto.getName());
	      System.out.println(dto.getStudentId());
	      System.out.println(dto.getPhysics());
	      System.out.println(dto.getChemistry());
	      System.out.println(dto.getMaths());
				 
	    }
	  } catch (Exception e) { 
	  e.printStackTrace(); }
	  
	  }
	  
	  public static void testsearch() throws ApplicationException {
		  MarksheetModelHibImpl m = new MarksheetModelHibImpl();
		  MarksheetDTO dto = new MarksheetDTO();
		  List list=new ArrayList(); 
		 dto=m.findByRollNo("CS1001");
		  try {
			  list=m.search(dto,0, 0); 
			  if(list.size()<0) {
		  }
			  Iterator it=list.iterator();
			  while(it.hasNext()) { 
				  dto= (MarksheetDTO) it.next(); 
						
				  System.out.println(dto.getId());
				  System.out.println(dto.getRollNo());
			      System.out.println(dto.getName());
			      System.out.println(dto.getStudentId());
			      System.out.println(dto.getPhysics());
			      System.out.println(dto.getChemistry());
			      System.out.println(dto.getMaths());
						 
			  
			  } } catch (Exception e) { 
			  e.printStackTrace(); }
			  
			  } 
}
