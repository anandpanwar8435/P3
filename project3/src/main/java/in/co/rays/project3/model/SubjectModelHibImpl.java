package in.co.rays.project3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project3.dto.CourseDTO;
import in.co.rays.project3.dto.SubjectDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.util.HibDataSource;

/**
 * JDBC Implement of subject
 * @author computer gallery
 *
 */
public class SubjectModelHibImpl  implements SubjectModelInt{
	/**
	 * add subject
	 * @param dto
	 * @return pk
	 * @throws DuplicateRecordException
	 * @throws ApplicationException
	 */
	public long add(SubjectDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub

		Session session = HibDataSource.getSession();
		System.out.println("step 1");
		Transaction tx = null;

		
		  CourseModelInt cModel = ModelFactory.getInstance().getCourseModel();
		  CourseDTO cDto = cModel.findByPk(dto.getCourseId());
		  dto.setCourseName(cDto.getCourseName());
		  
		  System.out.println("step 1a");
		  
		  SubjectDTO duplicataSub = findBySubjectName(dto.getSubjectName());
		  System.out.println("subject duplicate    "+duplicataSub);
		  
		  System.out.println("step 2"); // Check if create Subject already exist 
		  if(duplicataSub!= null && duplicataSub.getSubjectName()!=null) { 
			  throw new DuplicateRecordException("Subject already exists");}
		  System.out.println("step 3");
		 
		try {
			tx = session.beginTransaction();
			System.out.println("step 4");
			session.save(dto);
			System.out.println("step 5");
			tx.commit();
			System.out.println("step 6");
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("step 7");
			throw new ApplicationException("unable to add the record "+e);
		} finally {
			session.close();
		}
		return dto.getId();
	}

	/**
	 * update subject
 * @param dto
 * @throws ApplicationException
 * @throws DuplicateRecordException
	 */
	public void update(SubjectDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub

		Session session = HibDataSource.getSession();
		Transaction tx = null;

		
		  CourseModelInt cModel = ModelFactory.getInstance().getCourseModel();
		  CourseDTO cDto = cModel.findByPk(dto.getCourseId());
		  dto.setCourseName(cDto.getCourseName());
		 
		try {
			tx = session.beginTransaction();
			session.update(dto);

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("unable to update the record");

		} finally {
			session.close();
		}

	}

	/**
	 * delete subject
	 * @param dto
	 * @throws ApplicationException
	 */
	public void delete(SubjectDTO dto) throws ApplicationException {
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
			throw new ApplicationException("unable to delete the record");
		} finally {
			session.close();
		}
	}

	/**
	 * find subject by pk
 * @param pk
 * @return dto
 * @throws ApplicationException
	 */
	public SubjectDTO findByPk(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		SubjectDTO dto = null;

		Session session = HibDataSource.getSession();
		try {
			dto = (SubjectDTO) session.get(SubjectDTO.class, pk);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("unable to get the record");
		} finally {
			session.close();
		}

		return dto;
	}

	/**
	 * find subject by subject name
	 * @param subjectname
	 * @return dto
	 * @throws ApplicationException
	 */
	public SubjectDTO findBySubjectName(String subjectName) throws ApplicationException {
		// TODO Auto-generated method stub
		SubjectDTO dto = null;
		try {
			Session session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(SubjectDTO.class);
			criteria.add(Restrictions.like("subjectName", subjectName));

			List list = criteria.list();
			if (list.size() > 0) {
				dto = (SubjectDTO) list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("unale to fetch record");
		}
		return dto;
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	/**
	 * list of subject
	 * @param pageNo
	 * @param pageSize
	 * @return list
	 * @throws ApplicationException
	 */
	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub

		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(SubjectDTO.class);
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);

			}
			list = criteria.list();
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in  subject list");
		} finally {
			session.close();
		}

		return list;
	}

	public List search(SubjectDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	/**
	 * search subject
 * @param dto
 * @param pageNo
 * @param pageSize
 * @return list
 * @throws ApplicationException
	 */
	public List search(SubjectDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub

		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(SubjectDTO.class);

			if (dto != null) {
				if (dto.getId() != null) {
					criteria.add(Restrictions.eq("id", dto.getId()));

				}
				if (dto.getSubjectId() > 0) {
					criteria.add(Restrictions.eq("subjectId", dto.getSubjectId()));
				}
				if (dto.getCourseId() > 0) {
					criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
				}
				if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
					criteria.add(Restrictions.like("courseName", dto.getCourseName() + "%"));
				}
				if (dto.getSubjectName() != null && dto.getSubjectName().length() > 0) {
					criteria.add(Restrictions.like("subjectName", dto.getSubjectName() + "%"));
				}
			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);

			}
			list = criteria.list();
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in  subject list");
		} finally {
			session.close();
		}

		return list;
	}
}
