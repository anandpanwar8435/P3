package in.co.rays.project3.dto;

/**
 * marksheet JavaBean encapsulates marksheet attributes
 * @author computer gallery
 *
 */
public class MarksheetDTO extends BaseDTO {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
   /**
    * rollNo of marksheet
    */
private String rollNo;
   
   /**
    * studentId of marksheet
    */
private long studentId;
   
   /**
    * name of marksheet
    */
private String name;
   
   /**
    * physics of marksheet
    */
private Integer physics;
  
   /**
    * chemistry of marksheet
    */
private Integer chemistry;
   
   /**
    * maths of marksheet
    */
private Integer maths;
   

	public String getRollNo() {
	return rollNo;
}

public void setRollNo(String rollNo) {
	this.rollNo = rollNo;
}



public long getStudentId() {
	return studentId;
}

public void setStudentId(long studentId) {
	this.studentId = studentId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Integer getPhysics() {
	return physics;
}

public void setPhysics(Integer physics) {
	this.physics = physics;
}

public Integer getChemistry() {
	return chemistry;
}

public void setChemistry(Integer chemistry) {
	this.chemistry = chemistry;
}

public Integer getMaths() {
	return maths;
}

public void setMaths(Integer maths) {
	this.maths = maths;
}

	public String getKey() {
		
		return id+"";
	}

	public String getValue() {
		
		return rollNo+"";
	}
}
