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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "Sprint")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sprint.findAll", query = "SELECT s FROM Sprint s"),
    @NamedQuery(name = "Sprint.findById", query = "SELECT s FROM Sprint s WHERE s.id = :id"),
    @NamedQuery(name = "Sprint.findByName", query = "SELECT s FROM Sprint s WHERE s.name = :name"),
    @NamedQuery(name = "Sprint.findByStartDate", query = "SELECT s FROM Sprint s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "Sprint.findByDueDate", query = "SELECT s FROM Sprint s WHERE s.dueDate = :dueDate")})
public class Sprint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 25)
    @Column(name = "name")
    private String name;
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "dueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @JoinColumn(name = "releaseId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ReleaseBacklog releaseId;
    @OneToMany(mappedBy = "sprintId")
    private Collection<UserStory> userStoryCollection;

    public Sprint() {
    }

    public Sprint(Integer id) {
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

    public ReleaseBacklog getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(ReleaseBacklog releaseId) {
        this.releaseId = releaseId;
    }

    @XmlTransient
    public Collection<UserStory> getUserStoryCollection() {
        return userStoryCollection;
    }

    public void setUserStoryCollection(Collection<UserStory> userStoryCollection) {
        this.userStoryCollection = userStoryCollection;
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
        if (!(object instanceof Sprint)) {
            return false;
        }
        Sprint other = (Sprint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.cs545.entity.Sprint[ id=" + id + " ]";
    }
    
}
