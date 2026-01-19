/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Product;
import model.ProductDAO;
import java.util.List;

public class ProductController {
    private ProductDAO dao;

    public ProductController() { dao = new ProductDAO(); }

    public boolean addProduct(Product p) { return dao.insert(p); }

    public List<Product> getAllProducts() { return dao.getAll(); }

    public List<Product> searchProducts(String keyword) { return dao.searchByName(keyword); }
    
    public List<Product> getLowStockProducts() {
    return dao.getLowStockProducts();}

    public boolean updateProduct(Product p) { return dao.update(p); }

    public boolean deleteProduct(int productId) { return dao.delete(productId); }
}
