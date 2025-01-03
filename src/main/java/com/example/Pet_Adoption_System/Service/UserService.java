package com.example.Pet_Adoption_System.Service;

import com.example.Pet_Adoption_System.Model.User;


import java.util.List;


public interface UserService {

    User registerUser(User user);
    User getUserById(String id);
    List<User> getAllUsers();
    User updateUser(String id, User user);
    void deleteUser(String id);

}
    

    
