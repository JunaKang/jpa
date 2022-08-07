package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//예제 6.6
public interface ProductRepository extends JpaRepository<Product, Long> {
}