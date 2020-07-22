package com.wcs.portfolio.bundle.hashtagBlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/hashtagblogs")
public class HashtagController {

    @Autowired
    HashtagBlogService service;

    @GetMapping
    public List<HashtagBlog> getPropertyAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HashtagBlog getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public HashtagBlog add(@RequestBody HashtagBlog obj) {
        return service.add(obj);
    }

    @PatchMapping("/{id}")
    public HashtagBlog update(@PathVariable Long id, @RequestBody HashtagBlog obj) {
        return service.update(id, obj);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
