package edu.mum.cs545.bean;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Named("employeeBean")
@RequestScoped
public class EmployeeBean implements Serializable{

    private int id;
    
    @NotEmpty(message = "{employeebean_firstname_notempty}")
    private String firstname;
    
    @NotEmpty(message = "{employeebean_lastname_notempty}")
    private String lastname;
    
    @NotEmpty(message = "{employeebean_username_notempty}")
    private String username;
    
    @NotEmpty(message = "{employeebean_password_notempty}")
    private String password;
    
    @Transient
    @NotEmpty(message = "{employeebean_password_notempty}")
    private String confirmPassword;
    
    @NotEmpty(message = "{employeebean_status_notempty}")
    private String status;
    
    @NotNull(message = "{employeebean_role_notempty}")
    private int roleId;

    public String getFirstname() {
        return firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    } 
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

}