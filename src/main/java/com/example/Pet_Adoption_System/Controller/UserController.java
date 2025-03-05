package com.example.Pet_Adoption_System.Controller;
import java.util.List;

import com.example.Pet_Adoption_System.Model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Pet_Adoption_System.Service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // Allow requests from React app
@RequestMapping("api/users")
@Tag(name="UserController",description="To perform operations on User")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(
            summary = "GET operation on User",
            description = "It is used to get all Users in database"
    )
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @Operation(
            summary = "POST operation on User",
            description = "It is used to save User in database"
    )
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // Validate input
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null || user.getConfirmPassword() == null) {
            return ResponseEntity.badRequest().body("All fields are required.");
        }

        // Check if password and confirmPassword match
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Passwords do not match.");
        }

        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @Operation(
            summary = "POST operation on User",
            description = "It is used to login operation on Users"
    )
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        if (user.getEmail() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Email and password are required.");
        }

        User authenticatedUser = userService.authenticateUser(user.getEmail(), user.getPassword());

        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        }
        return ResponseEntity.status(401).body("Invalid credentials.");
    }

    @Operation(
            summary = "PUT operation on User",
            description = "It is used to update User details in database"
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody User user) {
        // Validate input
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Name, email, and password are required.");
        }

        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @Operation(
            summary = "DELETE operation on User",
            description = "It is used to delete User details in database"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }
}
