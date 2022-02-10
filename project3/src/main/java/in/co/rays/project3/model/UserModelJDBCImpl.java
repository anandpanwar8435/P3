package in.co.rays.project3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import in.co.rays.project3.dto.UserDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.exception.RecordNotFoundException;
import in.co.rays.project3.util.JDBCDataSource;

public class UserModelJDBCImpl implements UserModelInt{

	public long nextPk(UserDTO dto) throws ApplicationException {
		long pk = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT MAX(ID) FROM ST_USER";

		try {
			conn = JDBCDataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
			pk=rs.getLong(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ApplicationException("cannot bring the max pk");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk + 1;
		
	}

	public long add(UserDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		long pk=nextPk(dto);
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO ST_USER VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			conn = JDBCDataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1,pk);
			stmt.setString(2,dto.getFirstName());
			stmt.setString(3,dto.getLastName());
			stmt.setString(4,dto.getGender());
			stmt.setLong(5,dto.getRoleId());
			stmt.setDate(6,(java.sql.Date) dto.getDob());
			stmt.setString(7,dto.getMobileNo());
			stmt.setString(8,dto.getLogin());
			stmt.setString(9,dto.getPassword());
			stmt.setString(10,dto.getConfirmPassword());
			stmt.setString(11,dto.getCreatedBy());
			stmt.setString(12,dto.getModifiedBy());
			stmt.setTimestamp(13,dto.getCreatedDatetime());
			stmt.setTimestamp(14,dto.getModifiedDatetime());
			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ApplicationException("cannot bring the max pk");
			
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;		
	}

	public void delete(UserDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM ST_USER WHERE ID=?";

		try {
			conn = JDBCDataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1,dto.getId());
			
		
			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ApplicationException("cannot bring the max pk");
			
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public void update(UserDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE ST_USER SET FIRST_NAME=?,LAST_NAME=?,GENDER=?,ROLE_ID=?,DOB=?,MOBILE_NO=?,LOGIN=?,PASSWORD=?,CONFIRM_PASSWORD=?,LAST_LOGIN=?,UNSUCCESSFULL_LOGIN=?,LOGIN_IP=?,REGISTERED_IP=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?";

		try {
			conn = JDBCDataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			
			
			stmt.setString(1,dto.getFirstName());
			stmt.setString(2,dto.getLastName());
			stmt.setString(3,dto.getGender());
			stmt.setLong(4,dto.getRoleId());
			stmt.setDate(5,(java.sql.Date) dto.getDob());
			stmt.setString(6,dto.getMobileNo());
			stmt.setString(7,dto.getLogin());
			stmt.setString(8,dto.getPassword());
			stmt.setString(9,dto.getConfirmPassword());
			stmt.setString(10,dto.getCreatedBy());
			stmt.setString(11,dto.getModifiedBy());
			stmt.setTimestamp(12,dto.getCreatedDatetime());
			stmt.setTimestamp(13,dto.getModifiedDatetime());
			stmt.setLong(14,dto.getId());
		
			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ApplicationException("cannot bring the max pk");
			
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		

	}

	public UserDTO findByPk(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement stmt = null;
		UserDTO dto=null;
		ResultSet rs=null;
		String sql = "SELECT * FROM ST_USER WHERE ID=?";

		try {
			conn = JDBCDataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, pk);
			rs = stmt.executeQuery();
			while(rs.next()) {
				dto.setId(rs.getLong(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setGender(rs.getString(4));
				dto.setRoleId(rs.getLong(5));
				dto.setDob(rs.getDate(6));
				dto.setMobileNo(rs.getString(7));
				dto.setLogin(rs.getString(8));
				dto.setPassword(rs.getString(9));
				dto.setConfirmPassword(rs.getString(10));
				dto.setCreatedBy(rs.getString(11));
				dto.setModifiedBy(rs.getString(12));
				dto.setCreatedDatetime(rs.getTimestamp(13));
				dto.setModifiedDatetime(rs.getTimestamp(14));	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ApplicationException("cannot bring the max pk");
			
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return dto;
	}

	public UserDTO findByLogin(String login) throws ApplicationException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		UserDTO dto=null;
		ResultSet rs=null;
		String sql = "SELECT * FROM ST_USER WHERE ID=?";

		try {
			conn = JDBCDataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, login);
			rs = stmt.executeQuery();
			while(rs.next()) {
				dto.setId(rs.getLong(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setGender(rs.getString(4));
				dto.setRoleId(rs.getLong(5));
				dto.setDob(rs.getDate(6));
				dto.setMobileNo(rs.getString(7));
				dto.setLogin(rs.getString(8));
				dto.setPassword(rs.getString(9));
				dto.setConfirmPassword(rs.getString(10));
				dto.setCreatedBy(rs.getString(11));
				dto.setModifiedBy(rs.getString(12));
				dto.setCreatedDatetime(rs.getTimestamp(13));
				dto.setModifiedDatetime(rs.getTimestamp(14));	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ApplicationException("cannot bring the max pk");
			
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return dto;
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	public List list(int pageNo, int PageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List search(UserDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}

	public List search(UserDTO dto, int pageNo, int PageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean changePassword(long pk, String newPassword, String oldPassword)
			throws ApplicationException, RecordNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	public UserDTO authenticate(String login, String password) throws ApplicationException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		UserDTO dto=null;
		ResultSet rs=null;
		String sql = "SELECT * FROM ST_USER WHERE Login=?,Password=?";

		try {
			conn = JDBCDataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(1, password);
			rs = stmt.executeQuery();
			while(rs.next()) {
				dto.setId(rs.getLong(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setGender(rs.getString(4));
				dto.setRoleId(rs.getLong(5));
				dto.setDob(rs.getDate(6));
				dto.setMobileNo(rs.getString(7));
				dto.setLogin(rs.getString(8));
				dto.setPassword(rs.getString(9));
				dto.setConfirmPassword(rs.getString(10));
				dto.setCreatedBy(rs.getString(11));
				dto.setModifiedBy(rs.getString(12));
				dto.setCreatedDatetime(rs.getTimestamp(13));
				dto.setModifiedDatetime(rs.getTimestamp(14));	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ApplicationException("cannot bring the max pk");
			
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return dto;

	}

	public boolean forgetPassword(String login) throws ApplicationException, RecordNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean resetPassword(UserDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	public long registerUser(UserDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public List getRoles(UserDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
}
