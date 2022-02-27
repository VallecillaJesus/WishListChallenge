package com.company.carvajalback.dao;

import com.company.carvajalback.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<Users,Integer> {
}
