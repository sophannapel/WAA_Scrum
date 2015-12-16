/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.managedbean;

import edu.mum.cs545.bean.EmployeeBean;
import edu.mum.cs545.bean.Login;
import edu.mum.cs545.entity.Employee;
import edu.mum.cs545.entity.Role;
import edu.mum.cs545.service.EmployeeService;
import edu.mum.cs545.service.RoleService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Luwam
 */
@Named("employeeManagedBean")
@SessionScoped
public class EmployeeManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    transient EmployeeService employeeService;
    @Inject
    transient RoleService roleService;
    @Inject
    private Login login;

    private Employee currentEmployeeBean;

    @Inject
    private EmployeeBean newEmployeeBean;

    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        employeeList = employeeService.getlistEmployee();
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getCurrentEmployeeBean() {
        return currentEmployeeBean;
    }

    public void setCurrentEmployeeBean(Employee currentEmployeeBean) {
        this.currentEmployeeBean = currentEmployeeBean;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public EmployeeBean getNewEmployeeBean() {
        return newEmployeeBean;
    }

    public void setNewEmployeeBean(EmployeeBean newEmployeeBean) {
        this.newEmployeeBean = newEmployeeBean;
    }

    private SelectItem[] roleOption;

    public SelectItem[] getRoleOption() {
        List<Role> list = roleService.roleList();
        roleOption = new SelectItem[list.size()];
        for (int i = 0; i < list.size(); i++) {
            roleOption[i] = new SelectItem(list.get(i).getId(), list.get(i).getName());
        }
        return roleOption;
    }

    public void setRoleOption(SelectItem[] roleOption) {
        this.roleOption = roleOption;
    }

    public String authenticate() {
        if (employeeService.isValidUser(login.getUsername(), login.getPassword())) {
            currentEmployeeBean = employeeService.getEmployeeByUsername(login.getUsername());
            return "/views/index";
        }
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Invalid Username or password. Please try again!"));
FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Username or password. Please try again!", null));
        return null;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/views/login?faces-redirect=true";
    }

    public String createEmployee() {
        employeeService.saveEmployeeDetails(newEmployeeBean);
        return "/views/employee/employees?faces-redirect=true";
    }

    public void editEmployee(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Employee Details Edited", ((Employee) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void duplicateUsername() {
        Object employee = employeeService.getEmployeeByUsername(newEmployeeBean.getUsername());
        if (employee != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Username already taken. Try another one!"));
        }
    }

}
