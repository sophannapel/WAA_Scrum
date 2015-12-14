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
@Table(name = "ReleaseBacklog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReleaseBacklog.findAll", query = "SELECT r FROM ReleaseBacklog r"),
    @NamedQuery(name = "ReleaseBacklog.findById", query = "SELECT r FROM ReleaseBacklog r WHERE r.id = :id"),
    @NamedQuery(name = "ReleaseBacklog.findByName", query = "SELECT r FROM ReleaseBacklog r WHERE r.name = :name"),
    @NamedQuery(name = "ReleaseBacklog.findByType", query = "SELECT r FROM ReleaseBacklog r WHERE r.type = :type"),
    @NamedQuery(name = "ReleaseBacklog.findByStartDate", query = "SELECT r FROM ReleaseBacklog r WHERE r.startDate = :startDate"),
    @NamedQuery(name = "ReleaseBacklog.findByDueDate", query = "SELECT r FROM ReleaseBacklog r WHERE r.dueDate = :dueDate")})
public class ReleaseBacklog implements Serializable {

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
    @Column(name = "type")
    private String type;
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "dueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "descriptioon")
    private String descriptioon;
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "scrumMasterId", referencedColumnName = "id")
    @ManyToOne
    private Employee scrumMasterId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "releaseId")
    private Collection<Sprint> sprintCollection;
    @OneToMany(mappedBy = "releaseId")
    private Collection<UserStory> userStoryCollection;

    public ReleaseBacklog() {
    }

    public ReleaseBacklog(Integer id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDescriptioon() {
        return descriptioon;
    }

    public void setDescriptioon(String descriptioon) {
        this.descriptioon = descriptioon;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Employee getScrumMasterId() {
        return scrumMasterId;
    }

    public void setScrumMasterId(Employee scrumMasterId) {
        this.scrumMasterId = scrumMasterId;
    }

    @XmlTransient
    public Collection<Sprint> getSprintCollection() {
        return sprintCollection;
    }

    public void setSprintCollection(Collection<Sprint> sprintCollection) {
        this.sprintCollection = sprintCollection;
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
        if (!(object instanceof ReleaseBacklog)) {
            return false;
        }
        ReleaseBacklog other = (ReleaseBacklog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.cs545.entity.ReleaseBacklog[ id=" + id + " ]";
    }
    
}
