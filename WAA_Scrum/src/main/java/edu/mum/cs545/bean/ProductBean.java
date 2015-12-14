/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.bean;

import edu.mum.cs545.entity.Employee;
import edu.mum.cs545.entity.Product;
import edu.mum.cs545.service.ProductService;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author pelsophanna
 */
@Named("productBean")
@SessionScoped
public class ProductBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @NotEmpty(message = "{productbean_name_notempty}")
    private String name;
    
    @NotNull(message = "{productbean_startdate_notnull}")
    @Future(message = "{productbean_startdate_future}")
    private Date startDate;
    
    @NotNull(message = "{productbean_duedate_notnull}")
    @Future(message = "{productbean_duedate_future}")
    private Date dueDate;
    
    private String description;
    
    @NotNull
    @Column(nullable = false)
    private Integer statusId;
    
    @Inject
    transient private ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
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
    
    public Integer getStatusId() {
        return statusId;
    }
    
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
    
    public String createProduct() {

        Mapper mapper = new DozerBeanMapper();
        Product product = mapper.map(this, Product.class);
        product.setEmployeeId(new Employee(2));
        productService.createProduct(product);
        System.out.println("hehe ---- " + product.toString());
        System.out.println("hehehhe");
        return "productForm";
    }
    
}
