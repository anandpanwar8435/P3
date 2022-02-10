package in.co.rays.project3.model;

import java.util.Date;
import java.util.List;

import in.co.rays.project3.dto.TimeTableDTO;
import in.co.rays.project3.exception.ApplicationException;

public class TimeTableModelJDBCImpl implements TimeTableModelInt{

	public long add(TimeTableDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void update(TimeTableDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

	public void delete(TimeTableDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

	public TimeTableDTO findByPk(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List search(TimeTableDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List search(TimeTableDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO checkByCourseName(long courseId, Date examDate) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO checkBySubjectName(long courseId, long subjectId, Date examDate) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO checkBySemester(long courseId, long subjectId, String semester, Date examDate)
			throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
}
