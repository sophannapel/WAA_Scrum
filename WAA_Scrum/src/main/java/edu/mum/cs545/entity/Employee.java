/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pelsophanna
 */
@Entity
@Table(name = "Employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findByFirstname", query = "SELECT e FROM Employee e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Employee.findByLastname", query = "SELECT e FROM Employee e WHERE e.lastname = :lastname"),
    @NamedQuery(name = "Employee.findByUsername", query = "SELECT e FROM Employee e WHERE e.username = :username"),
    @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password"),
    @NamedQuery(name = "Employee.findByStatus", query = "SELECT e FROM Employee e WHERE e.status = :status")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 25)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 25)
    @Column(name = "username")
    private String username;
    @Size(max = 25)
    @Column(name = "password")
    private String password;
    @Size(max = 25)
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "scrumMasterId")
    private Collection<ReleaseBacklog> releaseBacklogCollection;
    @JoinColumn(name = "roleId", referencedColumnName = "id")
    @ManyToOne
    private Role roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<Product> productCollection;
    @OneToMany(mappedBy = "developerId")
    private Collection<UserStory> userStoryCollection;
    @OneToMany(mappedBy = "testId")
    private Collection<UserStory> userStoryCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerId")
    private Collection<UserStory> userStoryCollection2;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<ReleaseBacklog> getReleaseBacklogCollection() {
        return releaseBacklogCollection;
    }

    public void setReleaseBacklogCollection(Collection<ReleaseBacklog> releaseBacklogCollection) {
        this.releaseBacklogCollection = releaseBacklogCollection;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @XmlTransient
    public Collection<UserStory> getUserStoryCollection() {
        return userStoryCollection;
    }

    public void setUserStoryCollection(Collection<UserStory> userStoryCollection) {
        this.userStoryCollection = userStoryCollection;
    }

    @XmlTransient
    public Collection<UserStory> getUserStoryCollection1() {
        return userStoryCollection1;
    }

    public void setUserStoryCollection1(Collection<UserStory> userStoryCollection1) {
        this.userStoryCollection1 = userStoryCollection1;
    }

    @XmlTransient
    public Collection<UserStory> getUserStoryCollection2() {
        return userStoryCollection2;
    }

    public void setUserStoryCollection2(Collection<UserStory> userStoryCollection2) {
        this.userStoryCollection2 = userStoryCollection2;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.cs545.entity.Employee[ id=" + id + " ]";
    }
    
}
