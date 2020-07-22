package com.wcs.portfolio.bundle.hashtagBlog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wcs.portfolio.bundle.blog.Blog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HashtagBlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonBackReference("blog-hashtag")
    @ManyToMany(mappedBy = "hashtagBlogs")
    private List<Blog> Blogs = new ArrayList<>();

    public HashtagBlog() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return Blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        Blogs = blogs;
    }
}
