package edu.mum.cs545.service;

import edu.mum.cs545.bean.EmployeeBean;
import edu.mum.cs545.entity.Employee;
import java.util.List;

public interface EmployeeService {

    public Employee getEmployeeByUsername(String username);

    public Employee getEmployee(String empId);

    public boolean isValidUser(String username, String password);

    public boolean saveEmployeeDetails(EmployeeBean employeeBean);

    public List<Employee> getUserListByRole(int roleId);

    public List<Employee> getlistEmployee();

    public void deleteEmpployee(int id);

    public Employee getEmployeeById(int id);

    public void employeeUpdate(EmployeeBean employeeBean);
}
