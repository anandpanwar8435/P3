package in.co.rays.project3.model;

import java.util.List;

import in.co.rays.project3.dto.RoleDTO;
import in.co.rays.project3.exception.ApplicationException;

public interface RoleModelInt {
	
	public long add(RoleDTO dto) throws ApplicationException;
	public void update(RoleDTO dto) throws ApplicationException;
	public void delete(RoleDTO dto) throws ApplicationException;
	public RoleDTO findByPk(long pk) throws ApplicationException;
	public RoleDTO findByName(String name) throws ApplicationException;
	public List list() throws ApplicationException;
	public List list(int pageNo,int pageSize) throws ApplicationException;
	public List search(RoleDTO dto) throws ApplicationException;
	public List search(RoleDTO dto,int pageNo,int pageSize) throws ApplicationException;
}
