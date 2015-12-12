/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.entity;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pelsophanna
 */
public class TestHelper {
    
    private Session session = null;
    
    public TestHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public static void main(String[] args) {
        TestHelper obj = new TestHelper();
        
        List<Product> filmList = null;
    try {
        Transaction tx = obj.session.beginTransaction();
        Query q = obj.session.createQuery("from Product");
        filmList = q.list();
        for (Product p:filmList) {
            System.out.println(p.getDescription() + "-" + p.getName());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

        
    }
}
