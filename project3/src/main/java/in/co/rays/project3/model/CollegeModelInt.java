package in.co.rays.project3.model;

import java.util.List;

import in.co.rays.project3.dto.CollegeDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;

public interface CollegeModelInt {
	
	public long add(CollegeDTO dto) throws ApplicationException, DuplicateRecordException;
	public void delete(CollegeDTO dto) throws ApplicationException;
	public void update(CollegeDTO dto) throws DuplicateRecordException, ApplicationException;	
	public CollegeDTO findByPk(long pk) throws ApplicationException;
	public CollegeDTO findByName(String name) throws ApplicationException;
	public List list() throws ApplicationException;
	public List list(int pageNo,int pageSize) throws ApplicationException;
	public List search(CollegeDTO dto) throws ApplicationException;
	public List search(CollegeDTO dto,int pageNo,int pageSize) throws ApplicationException;	
}
