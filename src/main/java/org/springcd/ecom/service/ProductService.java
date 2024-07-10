package org.springcd.ecom.service;

import jakarta.transaction.Transactional;
import org.springcd.ecom.model.Product;
import org.springcd.ecom.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    ProductRepo repo;

    @Autowired
    public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product createProduct(Product product, MultipartFile imgFile) throws IOException {
        product.setImageName(imgFile.getOriginalFilename());
        product.setImageType(imgFile.getContentType());
        product.setImageData(imgFile.getBytes());
        repo.save(product);
        return product;
    }

    public Product updateProduct(int id, Product product, MultipartFile imgFile) throws IOException {
        product.setImageName(imgFile.getOriginalFilename());
        product.setImageType(imgFile.getContentType());
        product.setImageData(imgFile.getBytes());
        return repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    @Transactional
    public List<Product> searchProducts(String keyword) {
        return repo.searchKeyword(keyword);
    }
}
