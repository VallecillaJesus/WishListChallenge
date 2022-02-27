package com.company.carvajalback.api;


import com.company.carvajalback.dao.UserDAO;
import com.company.carvajalback.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserREST {

    @Autowired
    UserDAO userDAO;

    @GetMapping("/list")
    public List<Users> getUsers(){
        return userDAO.findAll();
    }

    @GetMapping("/list/{id}")
    public Optional<Users> getUserById(@PathVariable Integer id){
        return userDAO.findById(id);
    }

    @GetMapping("/auth/{username}")
    public Boolean authenticateUser(@PathVariable String username){
        List<Users> users = this.getUsers();
        if(!users.isEmpty()){
            for(Users user : users){
                if (user.getName().equals(username)) return true;
            }
        };
        return false;
    }

}
