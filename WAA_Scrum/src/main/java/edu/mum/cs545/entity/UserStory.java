/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pelsophanna
 */
@Entity
@Table(name = "UserStory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserStory.findAll", query = "SELECT u FROM UserStory u"),
    @NamedQuery(name = "UserStory.findById", query = "SELECT u FROM UserStory u WHERE u.id = :id"),
    @NamedQuery(name = "UserStory.findByName", query = "SELECT u FROM UserStory u WHERE u.name = :name"),
    @NamedQuery(name = "UserStory.findByPriority", query = "SELECT u FROM UserStory u WHERE u.priority = :priority"),
    @NamedQuery(name = "UserStory.findByStartDate", query = "SELECT u FROM UserStory u WHERE u.startDate = :startDate"),
    @NamedQuery(name = "UserStory.findByDueDate", query = "SELECT u FROM UserStory u WHERE u.dueDate = :dueDate"),
    @NamedQuery(name = "UserStory.findByEstimateDevEffort", query = "SELECT u FROM UserStory u WHERE u.estimateDevEffort = :estimateDevEffort"),
    @NamedQuery(name = "UserStory.findByEstimateTestEffort", query = "SELECT u FROM UserStory u WHERE u.estimateTestEffort = :estimateTestEffort")})
public class UserStory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 25)
    @Column(name = "name")
    private String name;
    @Size(max = 25)
    @Column(name = "priority")
    private String priority;
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "dueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "estimateDevEffort")
    private Integer estimateDevEffort;
    @Column(name = "estimateTestEffort")
    private Integer estimateTestEffort;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userStoryId")
    private Collection<Worklog> worklogCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userStory")
    private Collection<UserStoryWorklog> userStoryWorklogCollection;
    @JoinColumn(name = "sprintId", referencedColumnName = "id")
    @ManyToOne
    private Sprint sprintId;
    @JoinColumn(name = "developerId", referencedColumnName = "id")
    @ManyToOne
    private Employee developerId;
    @JoinColumn(name = "testId", referencedColumnName = "id")
    @ManyToOne
    private Employee testId;
    @JoinColumn(name = "ownerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee ownerId;
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "releaseId", referencedColumnName = "id")
    @ManyToOne
    private ReleaseBacklog releaseId;

    public UserStory() {
    }

    public UserStory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Worklog> getWorklogCollection() {
        return worklogCollection;
    }

    public void setWorklogCollection(Collection<Worklog> worklogCollection) {
        this.worklogCollection = worklogCollection;
    }

    @XmlTransient
    public Collection<UserStoryWorklog> getUserStoryWorklogCollection() {
        return userStoryWorklogCollection;
    }

    public void setUserStoryWorklogCollection(Collection<UserStoryWorklog> userStoryWorklogCollection) {
        this.userStoryWorklogCollection = userStoryWorklogCollection;
    }

    public Sprint getSprintId() {
        return sprintId;
    }

    public void setSprintId(Sprint sprintId) {
        this.sprintId = sprintId;
    }

    public Employee getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Employee developerId) {
        this.developerId = developerId;
    }

    public Employee getTestId() {
        return testId;
    }

    public void setTestId(Employee testId) {
        this.testId = testId;
    }

    public Employee getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Employee ownerId) {
        this.ownerId = ownerId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public ReleaseBacklog getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(ReleaseBacklog releaseId) {
        this.releaseId = releaseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserStory)) {
            return false;
        }
        UserStory other = (UserStory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.cs545.entity.UserStory[ id=" + id + " ]";
    }
    
}
