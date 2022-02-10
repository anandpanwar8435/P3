package in.co.rays.project3.dto;

import java.sql.Timestamp;
import java.util.Date;

/**
 * user JavaDTO encapsulates user attributes
 * @author computer gallery
 *
 */
public class UserDTO extends BaseDTO {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	public static final String ACTIVE = "Active";
	public static final String INACTIVE = "Inactive";
	
	
	/**
	 * first name of user
	 */
	private String firstName;
	
	/**
	 * last name of user
	 */
	private String lastName;
	
	/**
	 * login of user
	 */
	private String login;
	
	/**
	 * password of user
	 */
	private String password;
	
	
	/**
	 * confirmPassword of user
	 */
	private String confirmPassword;
	
	/**
	 * dob of user
	 */
	private Date dob;
	
	/**
	 * mobileNo of user
	 */
	private String mobileNo;
	
	/**
	 * gender of user
	 */
	private String gender;
	
	/**
	 * roleId of user
	 */
	private long roleId;

	
	
	
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public static String getActive() {
		return ACTIVE;
	}

	public static String getInactive() {
		return INACTIVE;
	}

	public String getKey() {

		return id + " ";
	}

	public String getValue() {

		return firstName + "" + lastName;
	}


	
}
