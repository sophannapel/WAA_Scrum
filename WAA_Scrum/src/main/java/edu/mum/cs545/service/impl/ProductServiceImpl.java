package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.ProductDAO;
import edu.mum.cs545.dao.impl.ProductDAOImpl;
import edu.mum.cs545.entity.Product;
import edu.mum.cs545.service.ProductService;
import java.util.List;
import javax.ejb.EJB;



public class ProductServiceImpl implements ProductService {

////    @Inject
//    private ProductDAO productDao = new ProductDAOImpl();
    
    @EJB
    private ProductDAO productDao;

    @Override
    public List<Product> listProduct() {
        return productDao.listProduct();
    }

    @Override
    public void createProduct(Product product) {
        productDao.createProduct(product);
    }

    @Override
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    @Override
    public void deleteProduct(int id) {
        productDao.deleteProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

}
