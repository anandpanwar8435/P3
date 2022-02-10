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
import in.co.rays.project3.dto.StudentDTO;
import in.co.rays.project3.dto.UserDTO;
import in.co.rays.project3.exception.ApplicationException;
import in.co.rays.project3.exception.DuplicateRecordException;
import in.co.rays.project3.exception.RecordNotFoundException;
import in.co.rays.project3.util.DataUtility;
import in.co.rays.project3.util.HibDataSource;


/**
 * JDBC Implement of student model
 * @author computer gallery
 *
 */
public class StudentModelHibImpl implements StudentModelInt {
	
	/**
	 * add student
	 * @param dto
	 * @return pk
	 * @throws DuplicateRecordException
	 * @throws ApplicationException
	 */
	public long add(StudentDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session = HibDataSource.getSession();
		
		
		  CollegeModelInt collegemodel = ModelFactory.getInstance().getCollegeModel();
		  CollegeDTO collegedto = collegemodel.findByPk(dto.getCollegeId());
		  dto.setCollegeName(collegedto.getName());
		 
		  StudentDTO duplicateName=findByLogin(dto.getLogin());
		  long pk = 0;
			if (duplicateName!=null){
				throw new DuplicateRecordException("Email already exist");
			}

		
		try {
			tx = session.beginTransaction();
			session.save(dto);
			pk = dto.getId();
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("Exception in Student Add " + e.getMessage());
		} finally {
			session.close();
		}
		return pk;
	}



	/**
	 * delete student
	 * @param dto
	 * @throws ApplicationException
	 */
	public void delete(StudentDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		
				Session session = null;
				Transaction tx = null;
				
				
		
		  CollegeModelInt collegemodel = ModelFactory.getInstance().getCollegeModel();
		  System.out.println("in delete mehtod 1");
		  // CollegeDTO collegedto =collegemodel.findByPk(dto.getCollegeId());
		  // dto.setCollegeName(collegedto.getName());
		  System.out.println("in delete mehtod 2");
		 
				try {
					session = HibDataSource.getSession();
					tx = session.beginTransaction();
					System.out.println("in delete mehtod 3");
					session.delete(dto);
					System.out.println("in delete mehtod 4");
					tx.commit();

				} catch (HibernateException e) {

					if (tx != null) {
						tx.rollback();
					}
					throw new ApplicationException("Exception in Student Delete" + e.getMessage());
				} finally {
					session.close();
				}
	}

	/**
	 * update student
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public void update(StudentDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Session session = null;
				Transaction tx = null;
				
				CollegeModelInt cModel = ModelFactory.getInstance().getCollegeModel();
				  CollegeDTO cDto = cModel.findByPk(dto.getCollegeId());
				  dto.setCollegeName(cDto.getName());
				
		
		  StudentDTO dtoExist = findByLogin(dto.getLogin());
		  
		  // Check if updated Email already exist
		  if (dtoExist != null && dtoExist.getId() != dto.getId()) { 
			  throw new DuplicateRecordException("Email is already exist"); 
			  }
		 
		  try {
					session = HibDataSource.getSession();
					tx = session.beginTransaction();
					session.update(dto);

					tx.commit();

				} catch (HibernateException e) {

					if (tx != null) {
						tx.rollback();
						throw new ApplicationException("Exception in Student Update" + e.getMessage());
					}
				} finally {
					session.close();
				}
	}

	/**
	 * find student with the help of login
	 * @param login
	 * @return dto
	 * @throws ApplicationException
	 */
	public StudentDTO findByLogin(String loginId) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session=HibDataSource.getSession();
		StudentDTO dto=null;
		try {
			Criteria criteria=session.createCriteria(StudentDTO.class);
			criteria.add(Restrictions.eq("login", loginId));
			List list=criteria.list();
			if(list.size()==1){
				dto=(StudentDTO) list.get(0);
			}
		} catch (HibernateException e) {
           
            throw new ApplicationException(
                    "Exception in getting Student by email " + e.getMessage());

        } finally {
            session.close();
        }
		return dto;
	}

	/**
	 * find student with the help of pk
	 * @param pk
	 * @return dto
	 * @throws ApplicationException
	 */
	public StudentDTO findByPk(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Session session = HibDataSource.getSession();
				StudentDTO dto = null;
				try {
					Criteria criteria = session.createCriteria(StudentDTO.class);
					criteria.add(Restrictions.eq("id", pk));
					List list = criteria.list();
					if (list.size() == 1) {
						dto = (StudentDTO) list.get(0);
					}
				} catch (HibernateException e) {
					e.printStackTrace();
					throw new ApplicationException("unable to fetch data in find by pk (Student)");
				}
				return dto;
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0,0);
	}

	/** 
	 * list of student
		 * @param pageNo
		 * @param pageSize
		 * @return list
		 * @throws ApplicationException
	 */
	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				 Session session = null;
			        List list = null;
			        try {
			            session = HibDataSource.getSession();
			            Criteria criteria = session.createCriteria(StudentDTO.class);

			            // if page size is greater than zero then apply pagination
			            if (pageSize > 0) {
			                pageNo = ((pageNo - 1) * pageSize) + 1;
			                criteria.setFirstResult(pageNo);
			                criteria.setMaxResults(pageSize);
			            }

			            list = criteria.list();
			        } catch (HibernateException e) {
			           
			            throw new ApplicationException(
			                    "Exception : Exception in  Student list");
			        } finally {
			            session.close();
			        }

			       
			        return list;

	}

	public List search(StudentDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}

	/**
	 * search student
		 * @param dto
		 * @param pageNo
		 * @param pageSize
		 * @return list
		 * @throws ApplicationException
	 */
	public List search(StudentDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
				System.out.println("llllllll"+dto.getCollegeId()+"....."+dto.getFirstName()+"''"+dto.getLogin());
				Session session = null;
		        List list = null;
		        try {
		            session = HibDataSource.getSession();
		            Criteria criteria = session.createCriteria(StudentDTO.class);
		            if (dto != null) {
						if (dto.getId() != null) {
							criteria.add(Restrictions.eq("id", dto.getId()));
						}
		            if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
		                criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
		            }
		            if (dto.getLogin() != null && dto.getLogin().length() > 0) {
		                criteria.add(Restrictions.like("login", dto.getLogin()
		                        + "%"));
		            }
		            if (dto.getLastName() != null && dto.getLastName().length() > 0) {
		                criteria.add(Restrictions.like("lastName", dto.getLastName()
		                        + "%"));
		            }
		            if (dto.getDob() != null && dto.getDob().getDate() > 0) {
		                criteria.add(Restrictions.eq("dob", dto.getDob()));
		            }
		            if (dto.getCollegeId() >0 ) {
		                criteria.add(Restrictions.eq("collegeId", dto.getCollegeId()));
		            }
		            
		            if (dto.getMobileNo() != null && dto.getMobileNo().length() > 0) {
		                criteria.add(Restrictions.like("mobileNo", dto.getMobileNo()
		                        + "%"));
		            }
		           }
		            // if page size is greater than zero the apply pagination
		            if (pageSize > 0) {
		                criteria.setFirstResult(((pageNo - 1) * pageSize));
		                criteria.setMaxResults(pageSize);
		            }

		            list = criteria.list();
		        } catch (HibernateException e) {
		           
		            throw new ApplicationException("Exception in Student search");
		            
		        } finally {
		            session.close();
		        }

		       return list;
			}
	
}
