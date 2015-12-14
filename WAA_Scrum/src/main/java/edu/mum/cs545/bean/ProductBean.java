package edu.mum.cs545.bean;

import edu.mum.cs545.entity.Employee;
import edu.mum.cs545.entity.Status;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author pelsophanna
 */
@Named("productBean")
//@SessionScoped
@RequestScoped
public class ProductBean implements Serializable {

    private Employee employeeId;
    private Status statusId;

    @NotEmpty(message = "{productbean_name_notempty}")
    private String name;

    @NotNull(message = "{productbean_startdate_notnull}")
    @Future(message = "{productbean_startdate_future}")
    private Date startDate;

    @NotNull(message = "{productbean_duedate_notnull}")
    @Future(message = "{productbean_duedate_future}")
    private Date dueDate;

    private String description;

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
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
