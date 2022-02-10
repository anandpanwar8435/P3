package in.co.rays.project3.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project3.dto.CollegeDTO;
import in.co.rays.project3.dto.CourseDTO;
import in.co.rays.project3.dto.FacultyDTO;
import in.co.rays.project3.dto.SubjectDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.util.HibDataSource;

/**
 * JDBC Implements of faculty model
 * @author computer gallery
 *
 */
public class FacultyModelHibImpl implements FacultyModelInt{

	/**
	 * add new faculty
	 * @return pk
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public long add(FacultyDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session=HibDataSource.getSession();
		Transaction tx=null;
		long pk=0;
		
		
		
		 CourseModelInt Cmodel = ModelFactory.getInstance().getCourseModel();
		 CourseDTO Cbean = Cmodel.findByPk(dto.getCourseId());
		 dto.setCourseName(Cbean.getCourseName());
		 
		 
		 CollegeModelInt collegemodel = ModelFactory.getInstance().getCollegeModel();
		 CollegeDTO collegedto = collegemodel.findByPk(dto.getCollegeId());
		 dto.setCollegeName(collegedto.getName());
		  
		 
		
		  SubjectModelInt Smodel = ModelFactory.getInstance().getSubjectModel();
		  SubjectDTO Sbean = Smodel.findByPk(dto.getSubjectId());
		  dto.setSubjectName(Sbean.getSubjectName());
		 
		  FacultyDTO duplicataRole = findByLogin(dto.getLogin());
			if (duplicataRole != null) {
				throw new DuplicateRecordException("Faculty already exists");
			}
		 
		try {
		tx=session.beginTransaction();
		session.save(dto);
		
		tx.commit();
		}catch(HibernateException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw new ApplicationException("unable to add record "+e.getMessage());
		}finally {
			session.close();
		}
		
		
		
		
		return dto.getId();
	}

	/**
	 * update faculty information
	 * @param dto
	 * @throws ApplicationException
	 * @throws DatabaseException
	 */
	public void update(FacultyDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session=HibDataSource.getSession();
		Transaction tx=null;
		
		
		  CourseModelInt Cmodel = ModelFactory.getInstance().getCourseModel();
		  CourseDTO Cbean = Cmodel.findByPk(dto.getCourseId());
		  dto.setCourseName(Cbean.getCourseName());
		  
		  
		  CollegeModelInt collegemodel = ModelFactory.getInstance().getCollegeModel();
		  CollegeDTO collegedto = collegemodel.findByPk(dto.getCollegeId());
		  dto.setCollegeName(collegedto.getName());
		  
		  
		  SubjectModelInt Smodel = ModelFactory.getInstance().getSubjectModel();
		  SubjectDTO Sbean = Smodel.findByPk(dto.getSubjectId());
		  dto.setSubjectName(Sbean.getSubjectName());
		 
		try {
		tx=session.beginTransaction();
		session.update(dto);
		
		tx.commit();
		}catch(HibernateException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw new ApplicationException("unable to update record "+e.getMessage());
		}finally {
			session.close();
		}
		
	}

	/**
	 * delete faculty
	 * @param dto
	 * @throws ApplicationException
	 */
	public void delete(FacultyDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session=HibDataSource.getSession();
		Transaction tx=null;
		try {
		tx=session.beginTransaction();
		session.delete(dto);
		
		tx.commit();
		}catch(HibernateException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw new ApplicationException("unable to delete record "+e.getMessage());
		}finally {
			session.close();
		}
		
	}

	/**
	 * find information with the help of pk
	 * @param pk
	 * @return dto
	 * @throws ApplicationException
	 */
	public FacultyDTO findByPk(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		FacultyDTO dto=null;
		Session session=HibDataSource.getSession();
		try {
		dto=(FacultyDTO) session.get(FacultyDTO.class, pk);
		System.out.println(dto.getCourseId());
		}catch(HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("unable to get record in pk "+e.getMessage());
		}finally {
			session.close();
		}
		return dto;
	}

	/**
	 * find faculty by login
	 * @param login
	 * @return dto
	 * @throws ApplicationException 
	 */
	public FacultyDTO findByLogin(String login) throws ApplicationException {
		// TODO Auto-generated method stub
		FacultyDTO dto=null;
		Session session=HibDataSource.getSession();
		try {
		Criteria criteria=	session.createCriteria(FacultyDTO.class);
			criteria.add(Restrictions.eq("login", login));
			List list = criteria.list();
			if (list.size() > 0) {
				dto = (FacultyDTO) list.get(0);
			}
		}catch(HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("unable to run findbylogin "+e.getMessage());
		}finally {
			session.close();
		}
		return dto;
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0,0);
	}

	/**
	 * to show list of faculty
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
			Criteria criteria = session.createCriteria(FacultyDTO.class);
			if (pageSize > 0) {
				pageNo = ((pageNo - 1) * pageSize) + 1;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = criteria.list();
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in  faculty list");
		} finally {
			session.close();
		}

		return list;
	}

	public List search(FacultyDTO dto) throws ApplicationException{
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}

	/**
	 * to search list of faculty
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return list
	 * @throws ApplicationException
	 */
	public List search(FacultyDTO dto, int pageNo, int pageSize) throws ApplicationException{
		// TODO Auto-generated method stub
		Session session = HibDataSource.getSession();
		//Session session = null;
        List list = null;
        try {
           // session = HibDataSource.getSession();
            Criteria criteria = session.createCriteria(FacultyDTO.class);
          if(dto!=null){
            if (dto.getId() !=null) {
                criteria.add(Restrictions.eq("id", dto.getId()));
            }
            if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
                criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
            }
            if (dto.getLogin() != null && dto.getLogin().length() > 0) {
                criteria.add(Restrictions.like("login", dto.getLogin() + "%"));
            }
            if (dto.getLastName() != null && dto.getLastName().length() > 0) {
                criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
            }
            if (dto.getCollegeId() > 0) {
                criteria.add(Restrictions.eq("collegeId", dto.getCollegeId()));
            }
            if (dto.getCourseId() > 0) {
                criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
            }
            if (dto.getSubjectId() > 0) {
                criteria.add(Restrictions.eq("subjectId", dto.getSubjectId()));
            } 
            if (dto.getCollegeName() != null && dto.getCollegeName().length() > 0) {
				criteria.add(Restrictions.like("collegeName", dto.getCollegeName() + "%"));
			}
            if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
				criteria.add(Restrictions.like("courseName", dto.getCourseName() + "%"));
			}
            
          }

            // if page size is greater than zero the apply pagination
            
         
          if (pageSize > 0) {
                criteria.setFirstResult(((pageNo - 1) * pageSize));
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
}
