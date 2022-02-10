package in.co.rays.project3.dto;

import java.util.Date;

/**
 * Timetable JavaDTO encapsulates student attributes
 * @author computer gallery
 *
 */
public class TimeTableDTO extends BaseDTO {
/**
 * serialVersionUID
 */
private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * TimeTable Subject Id
	 */
	private long subId;
	/**
	 * TimeTable courseId 
	 */
	private long courseId;
	/**
	 * TimeTable Subject Name
	 */
	private String subName;
	/**
	 * TimeTable course Name 
	 */
	private String courseName;
	/**
	 * TimeTable description
	 */
	private String description;
	/**
	 * TimeTable examDate 
	 */
	private Date examDate;
	/**
	 * TimeTable semester 
	 */
	private String semester;
	/**
	 * TimeTable examTime
	 */
	private String examTime;
	
	
	/*
	 * accessor
	 */
	public long getSubId() {
		return subId;
	}

	public void setSubId(long subId) {
		this.subId = subId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	

	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return subName;
	}
}
