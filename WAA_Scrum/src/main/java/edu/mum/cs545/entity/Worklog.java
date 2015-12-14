/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pelsophanna
 */
@Entity
@Table(name = "Worklog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Worklog.findAll", query = "SELECT w FROM Worklog w"),
    @NamedQuery(name = "Worklog.findById", query = "SELECT w FROM Worklog w WHERE w.id = :id"),
    @NamedQuery(name = "Worklog.findByActualEffort", query = "SELECT w FROM Worklog w WHERE w.actualEffort = :actualEffort"),
    @NamedQuery(name = "Worklog.findByModifiedDate", query = "SELECT w FROM Worklog w WHERE w.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "Worklog.findByEffortType", query = "SELECT w FROM Worklog w WHERE w.effortType = :effortType")})
public class Worklog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "actualEffort")
    private Integer actualEffort;
    @Column(name = "modifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Size(max = 255)
    @Column(name = "effortType")
    private String effortType;
    @JoinColumn(name = "userStoryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserStory userStoryId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "worklog")
    private UserStoryWorklog userStoryWorklog;

    public Worklog() {
    }

    public Worklog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActualEffort() {
        return actualEffort;
    }

    public void setActualEffort(Integer actualEffort) {
        this.actualEffort = actualEffort;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getEffortType() {
        return effortType;
    }

    public void setEffortType(String effortType) {
        this.effortType = effortType;
    }

    public UserStory getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(UserStory userStoryId) {
        this.userStoryId = userStoryId;
    }

    public UserStoryWorklog getUserStoryWorklog() {
        return userStoryWorklog;
    }

    public void setUserStoryWorklog(UserStoryWorklog userStoryWorklog) {
        this.userStoryWorklog = userStoryWorklog;
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
        if (!(object instanceof Worklog)) {
            return false;
        }
        Worklog other = (Worklog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.cs545.entity.Worklog[ id=" + id + " ]";
    }
    
}
