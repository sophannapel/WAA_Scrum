/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.entity;

import java.util.List;

/**
 *
 * @author Arif
 */
public class Resources {

    private int resourceId;
    private String resourceName;
    private String resourcePath;
    private String resourceIconName;
    private String resourceIconPath;
    private List<Resources> listSubMenus;

    public Resources() {
    }

    public Resources(int resourceId, String resourceName, String resourcePath, String resourceIconName, String resourceIconPath, List<Resources> listSubMenus) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourcePath = resourcePath;
        this.resourceIconName = resourceIconName;
        this.resourceIconPath = resourceIconPath;
        this.listSubMenus = listSubMenus;
    }

    public List<Resources> getListSubMenus() {
        return listSubMenus;
    }

    public void setListSubMenus(List<Resources> listSubMenus) {
        this.listSubMenus = listSubMenus;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public String getResourceIconName() {
        return resourceIconName;
    }

    public String getResourceIconPath() {
        return resourceIconPath;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public void setResourceIconName(String resourceIconName) {
        this.resourceIconName = resourceIconName;
    }

    public void setResourceIconPath(String resourceIconPath) {
        this.resourceIconPath = resourceIconPath;
    }

    @Override
    public String toString() {
        return "Resources{" + "resourceId=" + resourceId + ", resourceName=" + resourceName + ", resourcePath=" + resourcePath + ", resourceIconName=" + resourceIconName + ", resourceIconPath=" + resourceIconPath + '}';
    }

}
