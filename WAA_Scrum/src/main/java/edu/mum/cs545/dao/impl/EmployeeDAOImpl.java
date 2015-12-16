package edu.mum.cs545.dao.impl;

import edu.mum.cs545.dao.EmployeeDAO;
import edu.mum.cs545.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Employee getEmployee(String id) {
		System.out.println("Hello " + entityManager);

		@SuppressWarnings("unchecked")
		List<Employee> employeeList = entityManager.createQuery("SELECT t FROM Employee t").getResultList();

		for (Employee emp : employeeList) {
			LOGGER.info("Employee List::" + emp);
		}
		return employeeList.get(0);
	}

	@Override
	public boolean isValidUser(String username, String password) {

		Query isvalid = entityManager.createQuery("from Employee e where e.username = :username and e.password = :password");
		isvalid.setParameter("username", username);
		isvalid.setParameter("password", password);
		List<Employee> employeeList = isvalid.getResultList();
		LOGGER.info("Login Employee Information::" + employeeList);
		if (employeeList.isEmpty()) 
			return false;
		else
			return true;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		Query query = entityManager.createQuery("from Employee e where e.username = :username");
		query.setParameter("username", username);
		List<Employee> emp = query.getResultList();
		if(emp.isEmpty())
			return null;
		else
			return emp.get(0);
	}
	
	@Override
	@Transactional
	public boolean saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		entityManager.persist(employee);
		entityManager.flush();
		return false;
	}

	@Override
	public List<Employee> getUserListByRole(int roleId) {
		LOGGER.info("Get list of user by role::" + roleId);
		Query query = entityManager.createQuery(" FROM Employee WHERE role.id=:roleId");
		query.setParameter("roleId", roleId);
		List<Employee> list = query.getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
  @Override
  @Transactional
  public List<Employee> getlistEmployee() {
  	// TODO Auto-generated method stub
  	List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
  	for(Employee p : employees)
  		LOGGER.info("employee list::" + p);
  	return employees;
  }

@Override
@Transactional
public void deleteEmployee(int id) {

		  LOGGER.info("Deleting Employee for id::"+id);
		  Employee employee = entityManager.find(Employee.class, id);
		  employee.setStatus("Inactive");
		  entityManager.flush();
		  
	
				LOGGER.info(" Updated employee to Inactive Method call -------");
			

			
	
	
}

@Override
@Transactional
public Employee getEmployeeById(int id) {
	// TODO Auto-generated method stub
	return entityManager.find(Employee.class, id);
}

@Override
@Transactional
public void updateEmployee(Employee employee) {
	
	
	entityManager.merge(employee);
	entityManager.flush();	
	
}

}
