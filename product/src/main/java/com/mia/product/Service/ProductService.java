package com.mia.product.Service;

import com.mia.product.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> saveProducts(List<Product> products);
    List<Product> getProducts();
    Product getProductById(int id);
    Product getProductByName(String name);
    String deleteProduct(int id);
    Product updateProduct(Product product);
    Product updateProductQuantity(Product product, int count);
}
