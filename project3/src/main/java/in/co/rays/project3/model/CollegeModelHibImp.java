package in.co.rays.project3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project3.dto.CollegeDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.util.HibDataSource;

/**
 * JDBC implements of college model
 * @author computer gallery
 *
 */
public class CollegeModelHibImp implements CollegeModelInt {
	
	/**
	 * add new college
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public long add(CollegeDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session = HibDataSource.getSession();
		Transaction tx = null;
		
        int pk=0;
		
		CollegeDTO duplicateCollegeName=findByName(dto.getName());
		
		if(duplicateCollegeName!=null){
			throw new DuplicateRecordException("College Name Already Exists");
		}
		try {
			tx = session.beginTransaction();
			session.save(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();

			if (tx != null) {
				tx.rollback();

			}

			throw new ApplicationException("application exception id add method " + e.getMessage());
		} finally {
			session.close();
		}
		return dto.getId();
	}

	/**
	 * delete college information
	 * @param b
	 * @throws DatabaseException
	 */
	public void delete(CollegeDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
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

			throw new ApplicationException("Application exception id delete " + e.getMessage());
		} finally {
			session.close();
		}
	}

	
	/**
	 * update college detail
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public void update(CollegeDTO dto) throws DuplicateRecordException, ApplicationException {
		// TODO Auto-generated method stub
		Session session = HibDataSource.getSession();
		Transaction tx = null;
		try {
			CollegeDTO existDto = findByName(dto.getName());
			if (existDto != null && existDto.getId() != dto.getId()) {
				throw new DuplicateRecordException("Duplicate Entry Found ");
			}
			tx = session.beginTransaction();
			session.update(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("Application Exception in update method " + e.getMessage());
		} finally {
			session.close();
		}

	}

	/**
	 * find the information with the help of pk
	 * @param pk
	 * @return dto
	 * @throws ApplicationException
	 */
	public CollegeDTO findByPk(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = HibDataSource.getSession();
		CollegeDTO dto = null;
		try {

			dto = (CollegeDTO) session.get(CollegeDTO.class, pk);

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in getting DTO FindByName " + e.getMessage());

		} finally {
			session.close();
		}
		return dto;
	}

	/**
	 * find the infromation with the help of college name
	 * @param name
	 * @return dto
	 * @throws ApplicationException
	 */
	public CollegeDTO findByName(String name) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = HibDataSource.getSession();
		CollegeDTO dto = null;
		try {
			Criteria criteria = session.createCriteria(CollegeDTO.class);
			criteria.add(Restrictions.eq("name", name));

			List list = criteria.list();
			if (list.size() == 1) {
				dto = (CollegeDTO) list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("unable to find the result in collegeDTO " + e.getMessage());

		} finally {
			session.close();
		}

		return dto;
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	/**
	 * to show list of college
		 * @param pageNo
		 * @param pageSize
		 * @return list
		 * @throws ApplicationException
	 */
	public List<CollegeDTO> list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		List<CollegeDTO> list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(CollegeDTO.class);
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = criteria.list();

		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in  College list");
		} finally {
			session.close();
		}

		return list;
	}

	public List search(CollegeDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	
	/**
	 * search college information 
	 * @param pageNo
	 * @param pageSize
	 * @return list
	 * @throws ApplicationException
	 */
	public List search(CollegeDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = HibDataSource.getSession();
		List list = null;
		try {
			Criteria criteria = session.createCriteria(CollegeDTO.class);

			if (dto != null) {
				if (dto.getId() >0) {
					criteria.add(Restrictions.eq("id", dto.getId()));
				}
				if (dto.getName() != null && dto.getName().length() > 0) {
					criteria.add(Restrictions.like("name", dto.getName() + "%"));
				}
				if (dto.getAddress() != null && dto.getAddress().length() > 0) {
					criteria.add(Restrictions.like("address", dto.getAddress() + "%"));
				}
				if(dto.getState() != null && dto.getState().length() > 0) {
					criteria.add(Restrictions.like("state", dto.getState() + "%"));
				}
				
				if (dto.getCity() != null && dto.getCity().length() > 0) {
					criteria.add(Restrictions.like("city", dto.getCity() + "%"));
				}
				if (dto.getPhoneNo() != null && dto.getPhoneNo().length() > 0) {
					criteria.add(Restrictions.like("phoneNo", dto.getPhoneNo() + "%"));
				}

			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = criteria.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e);
			throw new ApplicationException("Unable to search the list " + e.getMessage());
		} finally {
			session.close();
		}

		return list;
	}

}
