package edu.mum.cs545.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public class UserStoryBeanForDevTest {

    @NotNull
    private Date dueDate;

    @NotNull
    @Column(nullable = false)
    @Range(min = 0)
    private Integer estimateDevEffort;

    @NotNull
    @Column(nullable = false)
    @Range(min = 0)
    private Integer estimateTestEffort;

    private Date startDate;

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getEstimateDevEffort() {
        return estimateDevEffort;
    }

    public void setEstimateDevEffort(Integer estimateDevEffort) {
        this.estimateDevEffort = estimateDevEffort;
    }

    public Integer getEstimateTestEffort() {
        return estimateTestEffort;
    }

    public void setEstimateTestEffort(Integer estimateTestEffort) {
        this.estimateTestEffort = estimateTestEffort;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
