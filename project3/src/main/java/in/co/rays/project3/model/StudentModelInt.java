package in.co.rays.project3.model;

import java.util.List;

import in.co.rays.project3.dto.StudentDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;

public interface StudentModelInt {

	public long add(StudentDTO dto) throws ApplicationException, DuplicateRecordException;
	public void delete(StudentDTO dto) throws ApplicationException;
	public void update(StudentDTO dto) throws ApplicationException, DuplicateRecordException;
	public StudentDTO findByLogin(String loginId) throws ApplicationException;
	public StudentDTO findByPk(long pk) throws ApplicationException;
	public List list() throws ApplicationException;
	public List list(int pageNo,int pageSize) throws ApplicationException;
	public List search(StudentDTO dto) throws ApplicationException;
	public List search(StudentDTO dto,int pageNo,int pageSize) throws ApplicationException;
}
