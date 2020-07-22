package com.wcs.portfolio.bundle.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    BlogService service;

    @GetMapping
    public List<Blog> getPropertyAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Blog getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Blog add(@RequestBody Blog obj) {
        return service.add(obj);
    }

    @PatchMapping("/{id}")
    public Blog update(@PathVariable Long id, @RequestBody Blog obj) {
        return service.update(id, obj);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
