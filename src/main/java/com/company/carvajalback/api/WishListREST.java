package com.company.carvajalback.api;

import com.company.carvajalback.dao.ProductDAO;
import com.company.carvajalback.dao.UserDAO;
import com.company.carvajalback.dao.WishListDAO;
import com.company.carvajalback.model.Product;
import com.company.carvajalback.model.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wishlist")
public class WishListREST {

    @Autowired
    WishListDAO wishListDAO;
    @Autowired
    ProductDAO productDAO;


    @GetMapping("/list/{id}")
    public List<Optional<Product>> getProductsList(@PathVariable Integer id){

        List<Optional<Product>> wishes = new ArrayList<>();
        wishListDAO.findAll().forEach(x -> {

            if(x.getUserId().equals(id)){

                wishes.add(productDAO.findById(x.getProductId()));

            }

        });

        wishes.forEach(x -> x.get().updateState());

        return wishes;
    }

    @PutMapping("/delete/{userId}/{productId}")
    public void deleteProduct(@PathVariable Integer productId, @PathVariable Integer userId){
        List<WishList> wishList = wishListDAO.findAll();

        wishList.forEach(x -> {
            if(x.getProductId().equals(productId) && x.getUserId().equals(userId)){
                wishListDAO.deleteById(x.getId());
            };
        });
    }

    @PutMapping("/add/{userId}/{productId}")
    public String addProduct(@PathVariable Integer productId, @PathVariable Integer userId){
        List<WishList> wishList = wishListDAO.findAll();
        Boolean exists = false;

        for(WishList wish : wishList){
            if(wish.getProductId().equals(productId)){
                return "El producto ya se encuentra en tu lista de deseos";
            }
        }
        wishListDAO.save(new WishList(8,userId,productId));
        return "correct";
    }

}
