package in.co.rays.project3.model;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project3.dto.RoleDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.util.HibDataSource;

/**
 * JDBC Implement of role model
 * @author computer gallery
 *
 */
public class RoleModelHibImpl implements RoleModelInt {
	
	/**
	 * add new role 
	 * @param dto
	 * @return pk
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public long add(RoleDTO dto) throws ApplicationException {

		Session session = HibDataSource.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("unable to add record "+e.getMessage());
		} finally {
			session.close();
		}
		return dto.getId();
}
	/**
	 * update role 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public void update(RoleDTO dto) throws ApplicationException {
		Session session = HibDataSource.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("unable to update record");
		} finally {
			session.close();
		}
	}
	
	/**
	 * delete role
	 * @param dto
	 * @throws ApplicationException
	 */
	public void delete(RoleDTO dto) throws ApplicationException {
		
		Session session = HibDataSource.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(dto);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("unable to delete record");
		} finally {
			session.close();
		}

	}

	/**
	 * find by role with the help of role
	 * @param pk
	 * @return dto
	 * @throws ApplicationException
	 */
	public RoleDTO findByPk(long pk) throws ApplicationException {
		
		Session session = HibDataSource.getSession();
		RoleDTO dto = null;

		try {

			dto = (RoleDTO) session.get(RoleDTO.class, pk);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("unable to delete record");
		} finally {
			session.close();
		}

		return dto;
	}

	/**
	 * find role with the help of name
	 * @param name
	 * @return dto
	 * @throws ApplicationException
	 */
	public RoleDTO findByName(String name) throws ApplicationException {
		
		Session session = HibDataSource.getSession();
		RoleDTO dto = null;
		List list = null;

		try {
			Criteria criteria = session.createCriteria(RoleDTO.class);
			criteria.add(Restrictions.eq("name", name));
			list = criteria.list();
			
			if (list.size() > 0) {
				dto = (RoleDTO) list.get(0);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("unable to fetch data");
		} finally {
			session.close();
		}
		return dto;
	}
	
	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0,0);
	}

	/**
	 * list of role
	 * @param pageNo
	 * @param pageSize
	 * @return list
	 * @throws ApplicationException
	 */
	public List list(int pageNo, int pageSize) throws ApplicationException {
	
		//log.debug("rolemodel List start");
		Session session=null;
		List list=null;
		
		try {
			session= HibDataSource.getSession();
			Criteria cri=session.createCriteria(RoleDTO.class);
			
			
			//pagination 
if(pageSize>0)
{
	
	pageNo=(pageNo-1) * pageSize + 1;
	cri.setFirstResult(pageNo);
	cri.setMaxResults(pageSize);
	
}
list=cri.list();

		} catch (HibernateException e) {
          //  log.error("Database Exception..", e);
            throw new ApplicationException(
                    "Exception : Exception in  Roles list");
        } finally {
            session.close();
        }

     //   log.debug("Model list End");
		
		return list;
	}



	
	/**
	 * search role
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return list
	 * @throws ApplicationException
	 */
	public List search(RoleDTO dto, int pageNo, int pageSize) throws ApplicationException {
		Session session = HibDataSource.getSession();
		List list = null;
		try {
			
			Criteria criteria = session.createCriteria(RoleDTO.class);
			
			if(dto!=null) {
				if(dto.getId()>0 ) {
					criteria.add(Restrictions.eq("id",dto.getId()));
				}
				if(dto.getName()!=null && dto.getName().length()>0) {
					criteria.add(Restrictions.like("name",dto.getName()));
				}
				if(dto.getDescription()!=null && dto.getDescription().length()>0) {
					criteria.add(Restrictions.like("description",dto.getDescription()));
				}
			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = criteria.list();
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in  role list");
		} finally {
			session.close();
		}
		
		return list;
	}
	public List search(RoleDTO dto) throws ApplicationException {
		
		return null;
	}

}