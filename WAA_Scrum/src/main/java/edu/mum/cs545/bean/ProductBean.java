package edu.mum.cs545.bean;

import edu.mum.cs545.entity.Employee;
import edu.mum.cs545.entity.Status;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author pelsophanna
 */

//@Named("product")
//@SessionScoped
public class ProductBean implements Serializable {

    private Employee employee;
    private Status status;
    
    @NotEmpty(message = "{productbean_name_notempty}")
    private String name;
    
    @NotNull(message = "{productbean_startdate_notnull}")
    @Future(message = "{productbean_startdate_future}")
    private Date startDate;
    
    @NotNull(message = "{productbean_duedate_notnull}")
    @Future(message = "{productbean_duedate_future}")
    private Date dueDate;
    
    private String description;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
