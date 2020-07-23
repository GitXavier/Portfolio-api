package com.wcs.portfolio.bundle.hashtagBlog;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wcs.portfolio.bundle.blog.Blog;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnoreProperties("hashtags")
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "blog_hashtag",
            joinColumns = @JoinColumn(name = "hashtag_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "blog_id", referencedColumnName = "id"),
            uniqueConstraints={@UniqueConstraint(columnNames={"hashtag_id", "blog_id"})})
    private List<Blog> blogs;

    public Hashtag() { }

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
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
