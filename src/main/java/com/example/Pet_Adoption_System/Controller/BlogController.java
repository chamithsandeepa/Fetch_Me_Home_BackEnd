package com.example.Pet_Adoption_System.Controller;

import com.example.Pet_Adoption_System.Model.Blog;
import com.example.Pet_Adoption_System.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<?> createBlog(@RequestParam("content") String content,
                                        @RequestParam("image") MultipartFile image) {
        try {
            String blogId = blogService.createBlog(content, image);
            return ResponseEntity.ok("Blog created successfully with ID: " + blogId);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing image: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlog(@PathVariable String id) {
        Blog blog = blogService.getBlogById(id);

        if (blog == null) {
            return ResponseEntity.status(404).body("Blog not found!");
        }

        return ResponseEntity.ok(blog);
    }

    @GetMapping
    public ResponseEntity<?> getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        return ResponseEntity.ok(blogs);
    }
}
