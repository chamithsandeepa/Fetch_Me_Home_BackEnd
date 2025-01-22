package com.example.Pet_Adoption_System.Service;


import com.example.Pet_Adoption_System.Model.Blog;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BlogService {
    String createBlog(String content, MultipartFile image) throws IOException;

    Blog getBlogById(String id);

    List<Blog> getAllBlogs();
}
