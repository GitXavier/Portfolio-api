package com.wcs.portfolio.bundle.hashtagBlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/hashtagblogs")
public class HashtagController {

    @Autowired
    HashtagService service;

    @GetMapping
    public List<Hashtag> getPropertyAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Hashtag getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Hashtag add(@RequestBody Hashtag obj) {
        return service.add(obj);
    }

    @PatchMapping("/{id}")
    public Hashtag update(@PathVariable Long id, @RequestBody Hashtag obj) {
        return service.update(id, obj);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
