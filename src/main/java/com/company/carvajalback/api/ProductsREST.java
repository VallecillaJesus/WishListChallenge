package com.company.carvajalback.api;

import com.company.carvajalback.dao.ProductDAO;
import com.company.carvajalback.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductsREST {

    @Autowired
    ProductDAO productDAO;

    @GetMapping("/list")
    public List<Product> getProducts(){
        return productDAO.findAll();
    }

    @GetMapping("/list/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id){
        return productDAO.findById(id);
    }

    @PostMapping()
    public ResponseEntity<String> addProduct(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Todo bien parcero");
    }

}
