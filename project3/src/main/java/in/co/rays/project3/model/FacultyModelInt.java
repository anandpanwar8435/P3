package in.co.rays.project3.model;

import java.util.List;

import in.co.rays.project3.dto.FacultyDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;

public interface FacultyModelInt {

	    public long add(FacultyDTO dto) throws ApplicationException, DuplicateRecordException;
        public void	update(FacultyDTO dto) throws ApplicationException;
		public void delete(FacultyDTO dto) throws ApplicationException;
		public FacultyDTO findByPk(long pk) throws ApplicationException;
		public FacultyDTO findByLogin(String login) throws ApplicationException;
		public  List list() throws ApplicationException;
		public List list(int pageNo,int pageSize) throws ApplicationException;
		public List search(FacultyDTO dto) throws ApplicationException;
		public List search(FacultyDTO dto,int pageNo,int pageSize) throws ApplicationException;
}
