package edu.mum.cs545.dao;

import edu.mum.cs545.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    public Employee getEmployee(String id);

    public boolean isValidUser(String username, String password);

    public Employee getEmployeeByUsername(String username);

    public boolean saveEmployee(Employee employee);

    public List<Employee> getUserListByRole(int roleId);

    public List<Employee> getlistEmployee();

    public void deleteEmployee(int id);

    public Employee getEmployeeById(int id);

    public void updateEmployee(Employee employee);

}
