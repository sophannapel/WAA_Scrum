/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author pelsophanna
 */
@Embeddable
public class UserStoryWorklogPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "UserStory_id")
    private int userStoryid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "worklogs_id")
    private int worklogsId;

    public UserStoryWorklogPK() {
    }

    public UserStoryWorklogPK(int userStoryid, int worklogsId) {
        this.userStoryid = userStoryid;
        this.worklogsId = worklogsId;
    }

    public int getUserStoryid() {
        return userStoryid;
    }

    public void setUserStoryid(int userStoryid) {
        this.userStoryid = userStoryid;
    }

    public int getWorklogsId() {
        return worklogsId;
    }

    public void setWorklogsId(int worklogsId) {
        this.worklogsId = worklogsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userStoryid;
        hash += (int) worklogsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserStoryWorklogPK)) {
            return false;
        }
        UserStoryWorklogPK other = (UserStoryWorklogPK) object;
        if (this.userStoryid != other.userStoryid) {
            return false;
        }
        if (this.worklogsId != other.worklogsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.cs545.entity.UserStoryWorklogPK[ userStoryid=" + userStoryid + ", worklogsId=" + worklogsId + " ]";
    }
    
}
