package com.example.Pet_Adoption_System.Service.impl;

import com.example.Pet_Adoption_System.Model.Blog;
import com.example.Pet_Adoption_System.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BolgService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public String createBlog(String content, MultipartFile image) throws IOException {
        Blog blog = new Blog();
        blog.setContent(content);
        blog.setImage(image.getBytes()); // Convert image to byte array and save
        Blog savedBlog = blogRepository.save(blog);
        return savedBlog.getId(); // Return the generated blog ID
    }

    @Override
    public Blog getBlogById(String id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

}
