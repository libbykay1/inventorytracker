package com.example.inventorytracker.product;

import com.example.inventorytracker.exception.ProductNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findProductById(Long id) {
        return productRepository.findProductById(id).orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found."));
    }

    public void deleteProduct(Long id) { productRepository.deleteById(id); }

    @Transactional
    public void updateInventory(Long id, String count) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "product with id " + id + " does not exist")
        );
        if (count != null &&
        count.length() > 0
        ) {
            product.setCount(count);
        }

    }
}

