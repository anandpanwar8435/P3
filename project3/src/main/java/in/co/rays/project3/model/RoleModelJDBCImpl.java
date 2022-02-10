package in.co.rays.project3.model;

import java.util.List;

import in.co.rays.project3.dto.RoleDTO;
import in.co.rays.project3.exception.ApplicationException;

public class RoleModelJDBCImpl implements RoleModelInt{

	public long add(RoleDTO dto) throws ApplicationException {
		
		return 0;
	}

	public void update(RoleDTO dto) throws ApplicationException {
		
		
	}

	public void delete(RoleDTO dto) throws ApplicationException {
		
		
	}

	public RoleDTO findByPk(long pk) throws ApplicationException {
		
		return null;
	}

	public RoleDTO findByName(String name) throws ApplicationException {
		
		return null;
	}

	public List list() throws ApplicationException {
		
		return null;
	}

	public List list(int pageNo, int pageSize) throws ApplicationException {
		
		return null;
	}

	public List search(RoleDTO dto) throws ApplicationException {
		
		return null;
	}

	public List search(RoleDTO dto, int pageNo, int pageSize) throws ApplicationException {
		
		return null;
	}
}
