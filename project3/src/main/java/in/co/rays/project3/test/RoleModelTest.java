package in.co.rays.project3.test;



import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project3.dto.CollegeDTO;
import in.co.rays.project3.dto.RoleDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.model.RoleModelHibImpl;

public class RoleModelTest {
public static void main(String[] args)throws ApplicationException {
	//testAdd();           //Done
	//testUpdate();        //Done
	//testDelete();        //Done
	//testfindByPk();      //Done
	//testfindByName();    //Done
	 testList();           //Done
	//  testsearch();      //Done  
}

public static void testAdd() throws ApplicationException {
	RoleModelHibImpl m = new RoleModelHibImpl();
	RoleDTO dto = new RoleDTO();
	dto.setName("Kiosk");
	dto.setDescription("kiosk");
	dto.setCreatedBy("Anand");
	dto.setModifiedBy("Anand");
	dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
	dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
	m.add(dto);
}


public static void testUpdate() throws ApplicationException {
	RoleModelHibImpl m = new RoleModelHibImpl();
	RoleDTO dto = new RoleDTO();
	dto.setId((long) (1));
	dto.setName("Admin");
	dto.setDescription("Admin");
	dto.setCreatedBy("Anand");
	dto.setModifiedBy("Anand");
	dto.setCreatedDatetime(new Timestamp(new Date(0).getTime()));
	dto.setModifiedDatetime(new Timestamp(new Date(0).getTime()));
	m.update(dto);
}

public static void testDelete() throws ApplicationException {
	RoleModelHibImpl m = new RoleModelHibImpl();
	RoleDTO dto = new RoleDTO();
	dto.setId((long) (5));	
	m.delete(dto);
}


public static void testfindByPk() throws ApplicationException {
	RoleModelHibImpl m = new RoleModelHibImpl();
	RoleDTO dto = new RoleDTO();
	dto=m.findByPk(1);
	
	System.out.println(dto.getId());
	System.out.println(dto.getName());
	System.out.println(dto.getDescription());
	
}

public static void testfindByName() throws ApplicationException {
	RoleModelHibImpl m = new RoleModelHibImpl();
	RoleDTO dto = new RoleDTO();	
	dto=m.findByName("Admin");


	System.out.println(dto.getId());
	System.out.println(dto.getName());
	System.out.println(dto.getDescription());
	
	
}
public static void testList() throws ApplicationException {
	RoleModelHibImpl m = new RoleModelHibImpl();
	RoleDTO dto = new RoleDTO();
	
	List list=new ArrayList();
	try {
		list=m.list(0, 0);
		if(list.size()<0)
		{
			System.out.println("record not found");
			
		}
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			dto= (RoleDTO) it.next();
			
			System.out.println(dto.getId());
			System.out.println(dto.getName());
			System.out.println(dto.getDescription());
			
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static void testsearch() throws ApplicationException {
	RoleModelHibImpl m = new RoleModelHibImpl();
	RoleDTO dto = new RoleDTO();
	 List list=new ArrayList(); 
	dto=m.findByName("Admin");
	  try {
		  list=m.search(dto,0, 0); 
		  if(list.size()<0) {
	  }
		  Iterator it=list.iterator();
		  while(it.hasNext()) { 
			  dto= (RoleDTO) it.next(); 
					
					  System.out.println(dto.getId()); 
					  System.out.println(dto.getName());
					  System.out.println(dto.getDescription());
					  }
		  } catch (Exception e) { 
		  e.printStackTrace(); }
		  
		  
	
}
}

	


