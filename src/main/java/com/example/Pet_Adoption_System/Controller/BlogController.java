package com.example.Pet_Adoption_System.Controller;

import com.example.Pet_Adoption_System.Model.Blog;
import com.example.Pet_Adoption_System.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin
public class BlogController {

    @Autowired
    private BlogService blogService;

    // Admin-only endpoints
    @PostMapping
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        Blog savedBlog = blogService.addBlog(blog);
        return ResponseEntity.ok(savedBlog);
    }

    @GetMapping("/admin")
    public ResponseEntity<List<Blog>> getAllBlogsForAdmin() {
        List<Blog> blogs = blogService.getAllBlogs();
        return ResponseEntity.ok(blogs);
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<Blog> approveBlog(@PathVariable String id) {
        Blog approvedBlog = blogService.approveBlog(id);
        return ResponseEntity.ok(approvedBlog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable String id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok().build();
    }

    // Public endpoint
    @GetMapping("/public")
    public ResponseEntity<List<Blog>> getApprovedBlogs() {
        List<Blog> blogs = blogService.getApprovedBlogs();
        return ResponseEntity.ok(blogs);
    }
}