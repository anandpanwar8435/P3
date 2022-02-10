package in.co.rays.project3.model;

import java.util.Date;
import java.util.List;

import in.co.rays.project3.dto.TimeTableDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;

public interface TimeTableModelInt {

	public long add(TimeTableDTO dto) throws ApplicationException, DuplicateRecordException;

	public void update(TimeTableDTO dto) throws ApplicationException, DuplicateRecordException;

	public void delete(TimeTableDTO dto) throws ApplicationException;

	public TimeTableDTO findByPk(long pk) throws ApplicationException;

	public List list() throws ApplicationException;

	public List list(int pageNo, int pageSize) throws ApplicationException;

	public List search(TimeTableDTO dto) throws ApplicationException;

	public List search(TimeTableDTO dto, int pageNo, int pageSize) throws ApplicationException;

	public TimeTableDTO checkByCourseName(long courseId, java.util.Date examDate) throws ApplicationException;

	public TimeTableDTO checkBySubjectName(long courseId, long subjectId, Date examDate) throws ApplicationException;

	public TimeTableDTO checkBySemester(long courseId, long subjectId, String semester, java.util.Date examDate) throws ApplicationException;
}
