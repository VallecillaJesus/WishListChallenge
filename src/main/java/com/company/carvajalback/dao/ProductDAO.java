package com.company.carvajalback.dao;

import com.company.carvajalback.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product,Integer> {
}
