package com.company.carvajalback.dao;

import com.company.carvajalback.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListDAO extends JpaRepository<WishList,Integer> {
}
