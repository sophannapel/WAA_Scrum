package edu.mum.cs545.dao;

import edu.mum.cs545.entity.Product;
import java.util.List;

public interface ProductDAO {

    public List<Product> listProduct();

    public void createProduct(Product product);

    public Product getProductById(int id);

    public void deleteProduct(int id);

    public void updateProduct(Product product);
}
