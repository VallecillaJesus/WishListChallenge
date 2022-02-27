package com.company.carvajalback.api;

import com.company.carvajalback.dao.ProductDAO;
import com.company.carvajalback.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
