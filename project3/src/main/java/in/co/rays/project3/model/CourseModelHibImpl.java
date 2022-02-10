package in.co.rays.project3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project3.dto.CollegeDTO;
import in.co.rays.project3.dto.CourseDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.util.HibDataSource;

/**
 * JDBC Implements of course model
 * @author computer gallery
 *
 */
public class CourseModelHibImpl implements CourseModelInt {
	
	/**
	 * add new course
	 * 
	 * @param d
	 * @return pk
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public long add(CourseDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session = HibDataSource.getSession();
		Transaction tx = null;
		int pk=0;
		CourseDTO dtoExist=findByCourseName(dto.getCourseName());
	//	System.out.println(dtoExist.getCourseName()+"&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		if(dtoExist!=null){
			throw new DuplicateRecordException("Course is already exist");
			
		}
		try {
			tx = session.beginTransaction();
			session.save(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.commit();
			}
			throw new ApplicationException("unable to add in course ");
		} finally {
			session.close();
		}
		return dto.getId();
	}

	/**
	 * update course information
	 * @param b
	 * @throws ApplicationException
	 */
	public void update(CourseDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub

		Session session = HibDataSource.getSession();
		Transaction tx = null;
         CourseDTO beanExist=findByCourseName(dto.getCourseName());
		
		if(beanExist!=null&&beanExist.getId()!=dto.getId()){
			throw new DuplicateRecordException("Course is already exist");
			
		}

		try {

			tx = session.beginTransaction();
			session.update(dto);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.commit();
			}
			throw new ApplicationException("unable to update in course ");
		} finally {
			session.close();
		}

	}

	/**
	 * delete course information in table
	 * 
	 * @param b
	 * @throws ApplicationException
	 */
	public void delete(CourseDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub

		Session session = HibDataSource.getSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			session.delete(dto);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.commit();
			}
			throw new ApplicationException("unable to update in course ");
		} finally {
			session.close();
		}

	}

	/**
	 * find course by name
	 * 
	 * @param courseName
	 * @return dto
	 * @throws ApplicationException
	 */
	public CourseDTO findByCourseName(String courseName) throws ApplicationException {
	
		CourseDTO dto = null;
		try {
			System.out.println(courseName);
			Session session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(CourseDTO.class);

			criteria.add(Restrictions.eq("courseName", courseName));

			List list = criteria.list();
			if (list.size() > 0) {
				dto = (CourseDTO) list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("unable to find the record");
		}
		return dto;
	}
		
		/*
	 * Session session = HibDataSource.getSession(); CourseDTO dto = null; try {
	 * Criteria criteria = session.createCriteria(CourseDTO.class);
	 * criteria.add(Restrictions.eq("courseName", courseName));
	 * 
	 * List list = criteria.list(); if (list.size() == 1) { dto = (CourseDTO)
	 * list.get(0); } } catch (HibernateException e) { e.printStackTrace(); throw
	 * new ApplicationException("unable to find the result in collegeDTO " +
	 * e.getMessage());
	 * 
	 * } finally { session.close(); }
	 * 
	 * return dto; }
	 */
	
		
	/*
	 * CourseDTO dto = null; System.out.println(courseName); try { Session session =
	 * HibDataSource.getSession(); Criteria criteria =
	 * session.createCriteria(CourseModelHibImpl.class);
	 * 
	 * criteria.add(Restrictions.eq("courseName", courseName));
	 * 
	 * List list = criteria.list(); if (list.size() == 1) { dto = (CourseDTO)
	 * list.get(0); } } catch (HibernateException e) { e.printStackTrace(); throw
	 * new ApplicationException("unable to find the record"); } return dto; }
	 */

	
	

	/**
	 * find information by pk
	 * 
	 * @param pk
	 * @return dto
	 * @throws ApplicationException
	 */
	public CourseDTO findByPk(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		CourseDTO dto = null;
		Session session = HibDataSource.getSession();

		try {

			dto = (CourseDTO) session.get(CourseDTO.class, pk);

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in getting User by pk");
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
	 * to show course list
		 * 
		 * @param pageNo
		 * @param pageSize
		 * @return list
		 * @throws ApplicationException
	 */
	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = HibDataSource.getSession();
		List list = null;
		try {
			Criteria criteria = session.createCriteria(CourseDTO.class);
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = criteria.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in Gettin list in student ");
		} finally {
			session.close();
		}

		return list;
	}

	public List search(CourseDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	/**
	 * search list of course detail
 * 
 * @param pageNo
 * @param pageSize
 * @return list
 * @throws ApplicationException
	 */
	public List search(CourseDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = HibDataSource.getSession();
		List list = null;
		try {
			Criteria criteria = session.createCriteria(CourseDTO.class);

			if (dto != null) {
				if (dto.getId() > 0) {
					criteria.add(Restrictions.eq("id", dto.getId()));
				}
				if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
					criteria.add(Restrictions.like("courseName", dto.getCourseName()));
				}
				if (dto.getDuration() != null && dto.getDuration().length() > 0) {
					criteria.add(Restrictions.like("duration", dto.getDuration()));
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
			throw new ApplicationException("Exception in Getting list in student ");
		} finally {
			session.close();
		}

		return list;
	}
}
