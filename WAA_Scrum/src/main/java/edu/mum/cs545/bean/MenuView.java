/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.bean;

import edu.mum.cs545.entity.Resources;
import edu.mum.cs545.managedbean.EmployeeManagedBean;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public static int PRODUCT_OWNER_ROLE_ID = 1;
    public static int HR_ADMIN_OWNER_ROLE_ID = 5;

    @PostConstruct
    public void init() {

        model = new DefaultMenuModel();
        Map<Integer, List<Resources>> mapRoleBasedResources = populateResources();

        List<Resources> listResources = mapRoleBasedResources.get(getCurrentUserRoleId());
        if(listResources==null){
         DefaultSubMenu firstSubmenu = new DefaultSubMenu("Under development");
         model.addElement(firstSubmenu);
        }else{
            for (Resources res : listResources) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(res.getResourceName());
                for (Resources resSub : res.getListSubMenus()) {
                    DefaultMenuItem item = new DefaultMenuItem(resSub.getResourceName());
                    item.setUrl(resSub.getResourcePath());
                    item.setIcon(resSub.getResourceIconPath());
                    firstSubmenu.addElement(item);
                }
                model.addElement(firstSubmenu);
            }
        }
        
        
//        model = new DefaultMenuModel();
//
//        //First submenu
//        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Product Management");
//
//        DefaultMenuItem item = new DefaultMenuItem("List of Products");
//        item.setUrl("/views/product/productList.faces");
//        item.setIcon("ui-icon-lightbulb");
//        firstSubmenu.addElement(item);
//
//        item = new DefaultMenuItem("Add New Product");
//        item.setUrl("/views/product/productForm.faces");
//        item.setIcon("ui-icon-plus");
//        firstSubmenu.addElement(item);
//
//        model.addElement(firstSubmenu);
//
//        //Employee management submenu
//        DefaultSubMenu employeeSubmenu = new DefaultSubMenu("Employee Management");
//
//        item = new DefaultMenuItem("List of Employees");
//        item.setUrl("/views/employee/employees.faces");
//        item.setIcon("ui-icon-lightbulb");
//        employeeSubmenu.addElement(item);
//
//        item = new DefaultMenuItem("Add New Employee");
//        item.setUrl("/views/employee/registration.faces");
//        item.setIcon("ui-icon-plus");
//        employeeSubmenu.addElement(item);
//
//        model.addElement(employeeSubmenu);

    }

    /**
     *
     * @return
     */
    public int getCurrentUserRoleId() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        EmployeeManagedBean neededBean = (EmployeeManagedBean) facesContext.getApplication().createValueBinding("#{ employeeManagedBean}").getValue(facesContext);
        int roleId = neededBean.getCurrentEmployeeBean().getRoleId().getId();
        return roleId;
    }

    public Map<Integer, List<Resources>> populateResources() {
        List<Resources> listResources = new ArrayList<Resources>();

        List<Resources> listSubMenus = new ArrayList<>();

        Map<Integer, List<Resources>> mapRoleBasedResources = new HashMap<>();

        //Product owner resources
        listSubMenus.add(new Resources(1, "List of Products", "/views/product/productList.faces", "ui-icon-lightbulb", "ui-icon-lightbulb", null));
        listSubMenus.add(new Resources(1, "Add New Product", "/views/product/productForm.faces", "ui-icon-plus", "ui-icon-lightbulb", null));

        listResources.add(new Resources(1, "Product Management", "/views/product/productList.faces", "ui-icon-lightbulb", "ui-icon-lightbulb", listSubMenus));
        listSubMenus = new ArrayList<>();
        listSubMenus.add(new Resources(1, "Add New Release", "#", "ui-icon-lightbulb", "ui-icon-lightbulb", null));
        listSubMenus.add(new Resources(1, "List of Releases", "#", "ui-icon-lightbulb", "ui-icon-lightbulb", null));

        listResources.add(new Resources(3, "Release Management", "/views/employee/registration.faces", "ui-icon-plus", "ui-icon-plus", listSubMenus));

        mapRoleBasedResources.put(PRODUCT_OWNER_ROLE_ID, listResources);

        //HR user resources
        listSubMenus = new ArrayList<>();
        listResources = new ArrayList<>();
        listSubMenus.add(new Resources(1, "Add New Employee", "/views/employee/registration.faces", "ui-icon-plus", "ui-icon-plus", null));
        listSubMenus.add(new Resources(1, "List of Releases", "/views/employee/employees.faces", "ui-icon-lightbulb", "ui-icon-lightbulb", null));

        listResources.add(new Resources(2, "List of Employees", "/views/employee/registration.faces", "ui-icon-plus", "ui-icon-plus", listSubMenus));

        mapRoleBasedResources.put(HR_ADMIN_OWNER_ROLE_ID, listResources);

        return mapRoleBasedResources;
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
