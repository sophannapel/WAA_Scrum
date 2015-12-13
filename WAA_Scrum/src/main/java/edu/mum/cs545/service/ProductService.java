package edu.mum.cs545.service;

import edu.mum.cs545.entity.Product;
import java.util.List;

public interface ProductService {

    public List<Product> listProduct();

    public void createProduct(Product product);

    public Product getProductById(int id);

    public void deleteProduct(int id);

    public void updateProduct(Product product);
}
