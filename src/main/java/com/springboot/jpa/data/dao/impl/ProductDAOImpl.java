package com.springboot.jpa.data.dao.impl;

import com.springboot.jpa.data.dao.ProductDAO;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

//예제 6.9
@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //예제 6.10
    @Override
    public Product insertProduct(Product product){
        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    //예제 6.11
    @Override
    public Product selectProduct(Long number){
        Product selectedProduct = productRepository.getReferenceById(number);

        return selectedProduct;
    }

    //예제 6.14
    @Override
    public Product updateProductName(Long number, String name) throws Exception{
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updatedProduct;
        if (selectedProduct.isPresent()){
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updatedProduct = productRepository.save(product);
        }else {
            throw new Exception();
        }
        return updatedProduct;
    }

    //예제 6.16
    @Override
    public void deleteProduct(Long number) throws Exception{
        Optional<Product> selectedProduct = productRepository.findById(number);

        if (selectedProduct.isPresent()){
            Product product = selectedProduct.get();

            productRepository.delete(product);
        }else{
            throw new Exception();
        }
    }
}
