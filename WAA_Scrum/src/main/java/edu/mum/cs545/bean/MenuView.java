/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.bean;

import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author pelsophanna
 */
@Named("menuView")
//@SessionScoped
public class MenuView implements Serializable {
    private static final long serialVersionUID = 42L;
    private MenuModel model;

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Product Management");
        
        DefaultMenuItem item = new DefaultMenuItem("List of Products");
        item.setUrl("/views/product/productList.faces");
        item.setIcon("ui-icon-lightbulb");
        firstSubmenu.addElement(item);
        
        item = new DefaultMenuItem("Add New Product");
        item.setUrl("/views/product/productForm.faces");
        item.setIcon("ui-icon-plus");
        firstSubmenu.addElement(item);
        
        model.addElement(firstSubmenu);

        //Second submenu
//        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");
//
//        item = new DefaultMenuItem("Save");
//        item.setIcon("ui-icon-disk");
//        item.setCommand("#{menuView.save}");
//        item.setUpdate("messages");
//        secondSubmenu.addElement(item);
//
//        item = new DefaultMenuItem("Delete");
//        item.setIcon("ui-icon-close");
//        item.setCommand("#{menuView.delete}");
//        item.setAjax(false);
//        secondSubmenu.addElement(item);
//
//        item = new DefaultMenuItem("Redirect");
//        item.setIcon("ui-icon-search");
//        item.setCommand("#{menuView.redirect}");
//        secondSubmenu.addElement(item);
//
//        model.addElement(secondSubmenu);
        
        //Employee management submenu
        DefaultSubMenu employeeSubmenu = new DefaultSubMenu("Employee Management");
        
        item = new DefaultMenuItem("Add New Employee");
        item.setUrl("/views/employee/registration.faces");
        item.setIcon("ui-icon-plus");
        employeeSubmenu.addElement(item);
        
        item = new DefaultMenuItem("List of Employees");
        item.setUrl("/views/employee/employees.faces");
        item.setIcon("ui-icon-lightbulb");
        employeeSubmenu.addElement(item);
        
        model.addElement(employeeSubmenu);
        
    }

    public MenuModel getModel() {
        return model;
    }

    public void save() {
        addMessage("Success", "Data saved");
    }

    public void update() {
        addMessage("Success", "Data updated");
    }

    public void delete() {
        addMessage("Success", "Data deleted");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
