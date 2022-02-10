package in.co.rays.project3.model;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project3.dto.CourseDTO;
import in.co.rays.project3.dto.SubjectDTO;
import in.co.rays.project3.dto.TimeTableDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.util.HibDataSource;

/**
 * JDBC Implements of timetable
 * @author computer gallery
 *
 */
public class TimeTableModelHibImpl implements TimeTableModelInt{
	
	/**
	 * add timetable
	 * @param dto
	 * @return pk
	 * @throws DuplicateRecordException
	 * @throws ApplicationException
	 */
	public long add(TimeTableDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
	
		
		  CourseModelInt Cmodel = ModelFactory.getInstance().getCourseModel();
		  CourseDTO Cbean = null; Cbean = Cmodel.findByPk(dto.getCourseId());
		  dto.setCourseName(Cbean.getCourseName());
		  
		  SubjectModelInt Smodel = ModelFactory.getInstance().getSubjectModel();
		  SubjectDTO Sbean = Smodel.findByPk(dto.getSubId());
		  dto.setSubName(Sbean.getSubjectName());
		 
		
		Session session = null;
		Transaction tx = null;
		long pk = 0;

		TimeTableDTO dto1 = checkByCourseName(dto.getCourseId(), dto.getSemester(),  new java.sql.Date(dto.getExamDate().getTime()));
		TimeTableDTO dto2 = checkBySubjectName(dto.getCourseId(), dto.getSubId(), dto.getSemester());
		 if(dto1 != null || dto2 != null){ 
			 throw new DuplicateRecordException("TimeTable Already Exsist"); 
			 
		 }
		
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.save(dto);
//			pk = dto.getId();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("Exception in timetable Add " + e.getMessage());
		} finally {
			session.close();
		}
		return pk;
	}

	/**
	 * Update a TIMETABLE.
	 *
	 * @param dto the dto
	 * @throws ApplicationException the application exception
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public void update(TimeTableDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub

		
		  CourseModelInt Cmodel = ModelFactory.getInstance().getCourseModel();
		  CourseDTO Cbean = null; Cbean = Cmodel.findByPk(dto.getCourseId());
		  dto.setCourseName(Cbean.getCourseName());
		  
		  SubjectModelInt Smodel = ModelFactory.getInstance().getSubjectModel();
		  SubjectDTO Sbean = Smodel.findByPk(dto.getSubId());
		  dto.setSubName(Sbean.getSubjectName());
		 

		Session session = null;
		Transaction tx = null;
		TimeTableDTO dto1 = checkByCourseName(dto.getCourseId(), dto.getSemester(),  new java.sql.Date(dto.getExamDate().getTime()));
		TimeTableDTO dto2 = checkBySubjectName(dto.getCourseId(), dto.getSubId(), dto.getSemester());
		 if(dto1 != null || dto2 != null){ 
			 throw new DuplicateRecordException("TimeTable Already Exsist"); 
			 
		 }
		
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.update(dto);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in timetable update " + e.getMessage());
		} finally {
			session.close();
		}

	}

	/**
	 * delete timetable
	 * @param dto
	 * @throws ApplicationException
	 */
	public void delete(TimeTableDTO dto) throws ApplicationException {

		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.delete(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in Timetable delete " + e.getMessage());
		} finally {
			session.close();
		}
	}

	/**
	 * Find User by TimeTable PK.
	 *
	 * @param pk            : get parameter
	 * @return dto
	 * @throws ApplicationException the application exception
	 */
	public TimeTableDTO findByPk(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		TimeTableDTO dto = null;
		try {
			session = HibDataSource.getSession();

			dto = (TimeTableDTO) session.get(TimeTableDTO.class, pk);
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in getting TimetableDTO by pk");
		} finally {
			session.close();
		}

		return dto;
	}

	public List list() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get List of TimeTable with pagination.
	 *
	 * @param pageNo            : Current Page No.
	 * @param pageSize            : Size of Page
	 * @return list : List of TimeTable
	 * @throws ApplicationException the application exception
	 */
	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(TimeTableDTO.class);

			if (pageSize > 0) {
				pageNo = ((pageNo - 1) * pageSize) + 1;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = criteria.list();
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in  TimetableDTO list");
		} finally {
			session.close();
		}
		return list;

	}

	public List search(TimeTableDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	/**
	 * Search TimeTable with pagination.
	 *
	 * @param dto            : Search Parameters
	 * @param pageNo            : Current Page No.
	 * @param pageSize            : Size of Page
	 * @return list : List of Users
	 * @throws ApplicationException the application exception
	 */
	public List search(TimeTableDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(TimeTableDTO.class);
			if (dto != null) {
				if (dto.getId() != null) {
					criteria.add(Restrictions.eq("id", dto.getId()));
				}
				if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
					criteria.add(Restrictions.like("courseName", dto.getCourseName() + "%"));
				}
				if (dto.getSubName() != null && dto.getSubName().length() > 0) {
					criteria.add(Restrictions.like("subName", dto.getSubName() + "%"));
				}
				if (dto.getSemester() != null && dto.getSemester().length() > 0) {
					criteria.add(Restrictions.like("semester", dto.getSemester() + "%"));
				}
				if (dto.getExamDate() != null && dto.getExamDate().getDate() > 0) {
					criteria.add(Restrictions.eq("examDate", dto.getExamDate()));
				}
				if (dto.getSubId() > 0) {
					criteria.add(Restrictions.eq("subId", dto.getSubId()));
				}
				if (dto.getCourseId() > 0) {
					criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
				}
			}
			if (pageSize > 0) {
				criteria.setFirstResult((pageNo - 1) * pageSize);
				criteria.setMaxResults(pageSize);
			}
			list = criteria.list();
		} catch (HibernateException e) {

			throw new ApplicationException("Exception in course search");
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * @param courseId
	 * @param semester
	 * @param examDate
	 * @return dto
	 * @throws ApplicationException
	 */
	public TimeTableDTO checkByCourseName(long courseId, String semester, Date examDate) throws ApplicationException {
		// TODO Auto-generated method stub
		
		long l = examDate.getTime();
		java.sql.Date date = new java.sql.Date(l);
		Session session = null;
		TimeTableDTO dto = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(TimeTableDTO.class);
			//Disjunction dis = Restrictions.disjunction();
			//criteria.add(Restrictions.and(Restrictions.eq("courseId", courseId), Restrictions.eq("examDate", date)), Restrictions.eq("semester", semester));
			
			criteria.add(Restrictions.eq("courseId", courseId));
			criteria.add(Restrictions.eq("semester", semester));
			criteria.add(Restrictions.eq("examDate", examDate));
			List list = criteria.list();
			if (list.size() > 0) {
				dto = (TimeTableDTO) list.get(0);
			}
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in getting TimetableDTO by pk");
		} finally {
			session.close();
		}
		return dto;
//		return null;
	}

	/**
	 * @param courseId
	 * @param subId
	 * @param semester
	 * @return dto
	 * @throws ApplicationException
	 */
	public TimeTableDTO checkBySubjectName(long courseId, long subId, String semester) throws ApplicationException {
		// TODO Auto-generated method stub
		/*
		 * long l = examDate.getTime(); java.sql.Date date = new java.sql.Date(l);
		 */
		Session session = null;
		TimeTableDTO dto = null;
		try {

			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(TimeTableDTO.class);
			//Disjunction dis = Restrictions.disjunction();
			
			criteria.add(Restrictions.eq("courseId", courseId));
			criteria.add(Restrictions.eq("subId", subId));
			criteria.add(Restrictions.eq("semester", semester));
			
			
			List list = criteria.list();
			if (list.size() > 0) {
				dto = (TimeTableDTO) list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();

			throw new ApplicationException("Exception : Exception in getting TimetableDTO by pk");
		} finally {
			session.close();
		}
		return dto;
//		return null;
	}

	/**
	 * Check bysemester.
    *
    * @param CourseId the course id
    * @param SubjectId the subject id
    * @param semester the semester
    * @param ExamDAte the exam Date
    * @return the time table dto
	 */
	public TimeTableDTO checkBySemester(long courseId, long subId, String semester, Date examDate) throws ApplicationException {
		// TODO Auto-generated method stub
		long l = examDate.getTime();
		java.sql.Date date = new java.sql.Date(l);
		Session session = null;
		TimeTableDTO dto = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(TimeTableDTO.class);
			//Disjunction dis = Restrictions.disjunction();
			criteria.add(Restrictions.eq("courseId", courseId));
			criteria.add(Restrictions.eq("subId", subId));
			criteria.add(Restrictions.like("semester", semester));
			criteria.add(Restrictions.eq("examDate", date));
			//criteria.add(dis);
			List list = criteria.list();
			if (list.size() > 0) {
				dto = (TimeTableDTO) list.get(0);
			}

		} catch (HibernateException e) {
			e.printStackTrace();

			throw new ApplicationException("Exception : Exception in getting TimetableDTO by pk");
		} finally {
			session.close();
		}
		return dto;
//		return null;
	}

	public TimeTableDTO checkByCourseName(long courseId, Date examDate) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO checkBySubjectName(long courseId, long subId, Date examDate) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
