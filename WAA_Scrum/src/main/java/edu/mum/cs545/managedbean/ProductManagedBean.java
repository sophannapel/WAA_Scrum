/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.managedbean;

import edu.mum.cs545.bean.ProductBean;
import edu.mum.cs545.entity.Employee;
import edu.mum.cs545.entity.Product;
import edu.mum.cs545.entity.Status;
import edu.mum.cs545.service.ProductService;
import edu.mum.cs545.service.StatusService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 *
 * @author pelsophanna
 */
@Named("productManagedBean")
@SessionScoped
public class ProductManagedBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
//    @ManagedProperty("#{ProductBean}")
    private ProductBean productBean;
    
    @NotNull
    @Column(nullable = false)
    private Integer statusId;
    
    @Inject
    transient private ProductService productService;
    
    @Inject
    transient private StatusService statusService;
    
    private SelectItem[] statusOption;

    public StatusService getStatusService() {
        return statusService;
    }

    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    public SelectItem[] getStatusOption() {
        List<Status> list = statusService.statusList();
        statusOption = new SelectItem[list.size()];
        for (int i=0; i<list.size(); i++) {
            statusOption[i] = new SelectItem(list.get(i).getId(), list.get(i).getName());
        }
        return statusOption;
    }

    public void setStatusOption(SelectItem[] statusOption) {
        this.statusOption = statusOption;
    }

    public ProductBean getProductBean() {
        return productBean;
    }

    public void setProductBean(ProductBean productBean) {
        this.productBean = productBean;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    
    public Integer getStatusId() {
        return statusId;
    }
    
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
    
    public String createProduct() {
        
        //Need to create employee object, status for this product

        Mapper mapper = new DozerBeanMapper();
        productBean.setStatus(new Status(statusId));
        productBean.setEmployee(new Employee(2));
        
        Product product = mapper.map(productBean, Product.class);
        productService.createProduct(product);
        return "productForm";
    }    
}
