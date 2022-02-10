package in.co.rays.project3.dto;

import java.util.Date;

/**
 * student JavaDTO encapsulates student attributes
 * @author computer gallery
 *
 */
public class StudentDTO extends BaseDTO{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Student firstName 
	 */
	private String firstName;
	/**
	 * Student lastName 
	 */
	private String lastName;
	/**
	 * Student login 
	 */
	private String login;
	/**
	 * Student mobileNo 
	 */
	private String mobileNo;
	/**
	 * Student collegeId 
	 */
	private long collegeId;
	/**
	 * Student dob 
	 */
	private Date dob;
	/**
	 * Student collegeName 
	 */
	private String collegeName;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getKey() {
		return id+" ";
	}

	public String getValue() {
		return firstName+" "+lastName;
	}
}
