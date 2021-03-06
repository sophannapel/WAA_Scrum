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
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author pelsophanna
 */
@Named("productManagedBean")
@ConversationScoped
//@RequestScoped
//@ViewScoped
public class ProductManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProductBean productBean;

    @NotNull
    @Column(nullable = false)
    private Integer statusId;

    @Inject
    transient private ProductService productService;

    @Inject
    transient private StatusService statusService;

    private SelectItem[] statusOption;

    private List<Product> productList;

    private int updateProductId;

    /* this method is needed for sorting product list on productList page */
    @PostConstruct
    public void init() {
        productList = productService.listProduct();
    }

    public int getUpdateProductId() {
        return updateProductId;
    }

    public void setUpdateProductId(int updateProductId) {
        this.updateProductId = updateProductId;
    }

    public List<Product> getProductList() {
        productList = productService.listProduct();
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public StatusService getStatusService() {
        return statusService;
    }

    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    public SelectItem[] getStatusOption() {
        List<Status> list = statusService.statusList();
        statusOption = new SelectItem[list.size()];
        for (int i = 0; i < list.size(); i++) {
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

        int uId = Integer.valueOf(FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("userId"));

        Mapper mapper = new DozerBeanMapper();
        productBean.setStatusId(new Status(statusId));
        productBean.setEmployeeId(new Employee(uId));
        Product product = mapper.map(productBean, Product.class);
        product.setId(updateProductId);

        if (updateProductId > 0) {
            productService.updateProduct(product);
            FacesMessage msg = new FacesMessage("Product Backlog Updated", String.valueOf(updateProductId));
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            productService.createProduct(product);
            FacesMessage msg = new FacesMessage("New Product Backlog Added", product.getId().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        return "productList";
    }

    public void editProduct(RowEditEvent event) throws IOException {
        FacesMessage msg = new FacesMessage("Product Backlog Edited", ((Product) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        Product tempProduct = (Product) event.getObject();
        Mapper mapper = new DozerBeanMapper();
        productBean = mapper.map(tempProduct, ProductBean.class);
        statusId = tempProduct.getStatusId().getId();
        updateProductId = tempProduct.getId();

        FacesContext ctx = FacesContext.getCurrentInstance();
        NavigationHandler navigationHandler = ctx.getApplication().getNavigationHandler();
        navigationHandler.handleNavigation(ctx, null, "productForm");
    }

    public void cancelEditProduct(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Product) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
