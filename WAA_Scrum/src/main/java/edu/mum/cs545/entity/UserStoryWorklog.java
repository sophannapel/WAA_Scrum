/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pelsophanna
 */
@Entity
@Table(name = "UserStory_Worklog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserStoryWorklog.findAll", query = "SELECT u FROM UserStoryWorklog u"),
    @NamedQuery(name = "UserStoryWorklog.findByUserStoryid", query = "SELECT u FROM UserStoryWorklog u WHERE u.userStoryWorklogPK.userStoryid = :userStoryid"),
    @NamedQuery(name = "UserStoryWorklog.findByWorklogsId", query = "SELECT u FROM UserStoryWorklog u WHERE u.userStoryWorklogPK.worklogsId = :worklogsId")})
public class UserStoryWorklog implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserStoryWorklogPK userStoryWorklogPK;
    @JoinColumn(name = "worklogs_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Worklog worklog;
    @JoinColumn(name = "UserStory_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserStory userStory;

    public UserStoryWorklog() {
    }

    public UserStoryWorklog(UserStoryWorklogPK userStoryWorklogPK) {
        this.userStoryWorklogPK = userStoryWorklogPK;
    }

    public UserStoryWorklog(int userStoryid, int worklogsId) {
        this.userStoryWorklogPK = new UserStoryWorklogPK(userStoryid, worklogsId);
    }

    public UserStoryWorklogPK getUserStoryWorklogPK() {
        return userStoryWorklogPK;
    }

    public void setUserStoryWorklogPK(UserStoryWorklogPK userStoryWorklogPK) {
        this.userStoryWorklogPK = userStoryWorklogPK;
    }

    public Worklog getWorklog() {
        return worklog;
    }

    public void setWorklog(Worklog worklog) {
        this.worklog = worklog;
    }

    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStory userStory) {
        this.userStory = userStory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userStoryWorklogPK != null ? userStoryWorklogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserStoryWorklog)) {
            return false;
        }
        UserStoryWorklog other = (UserStoryWorklog) object;
        if ((this.userStoryWorklogPK == null && other.userStoryWorklogPK != null) || (this.userStoryWorklogPK != null && !this.userStoryWorklogPK.equals(other.userStoryWorklogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.cs545.entity.UserStoryWorklog[ userStoryWorklogPK=" + userStoryWorklogPK + " ]";
    }

}
