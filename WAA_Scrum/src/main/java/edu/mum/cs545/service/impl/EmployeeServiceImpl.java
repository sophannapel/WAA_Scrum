package edu.mum.cs545.service.impl;

import edu.mum.cs545.bean.EmployeeBean;
import edu.mum.cs545.dao.EmployeeDAO;
import edu.mum.cs545.entity.Employee;
import edu.mum.cs545.entity.Role;
import edu.mum.cs545.service.EmployeeService;
import java.util.List;
import javax.inject.Inject;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    private EmployeeDAO employeeDAO;

    // @Autowired
    // private Employee employee;
    public void setPersonDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee getEmployee(String empId) {

        return employeeDAO.getEmployee(empId);
    }

    @Override
    public boolean isValidUser(String username, String password) {

        boolean isvalid = false;
        isvalid = employeeDAO.isValidUser(username, password);
        return isvalid;
    }

    @Override
    public boolean saveEmployeeDetails(EmployeeBean employeeBean) {
        boolean issaved = false;
        Employee e = new Employee();
        e.setFirstname(employeeBean.getFirstname());
        e.setLastname(employeeBean.getLastname());
        e.setUsername(employeeBean.getUsername());
        e.setPassword(employeeBean.getPassword());
        e.setRoleId(new Role(employeeBean.getRoleId()));
        e.setStatus(employeeBean.getStatus());
        issaved = employeeDAO.saveEmployee(e);
        return issaved;
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        return employeeDAO.getEmployeeByUsername(username);
    }

    @Override
    public List<Employee> getUserListByRole(int roleId) {
        return employeeDAO.getUserListByRole(roleId);
    }

    @Override
    public List<Employee> getlistEmployee() {

        List<Employee> employeeList = employeeDAO.getlistEmployee();

        return employeeList;

    }

    @Override
    public void deleteEmpployee(int id) {
        // TODO Auto-generated method stub
        employeeDAO.deleteEmployee(id);

    }

    @Override
    public Employee getEmployeeById(int id) {

        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public void employeeUpdate(EmployeeBean employeeBean) {
        // TODO Auto-generated method stub

        Mapper mapper = new DozerBeanMapper();
        Employee employee = mapper.map(employeeBean, Employee.class);

        employeeDAO.updateEmployee(employee);

    }

}
