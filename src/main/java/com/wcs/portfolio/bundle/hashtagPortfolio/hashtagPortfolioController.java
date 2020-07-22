package com.wcs.portfolio.bundle.hashtagPortfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/hashtagportfolios")
public class hashtagPortfolioController {

    @Autowired
    HashtagPortfolioService service;

    @GetMapping
    public List<HashtagPortfolio> getPropertyAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HashtagPortfolio getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public HashtagPortfolio add(@RequestBody HashtagPortfolio obj) {
        return service.add(obj);
    }

    @PatchMapping("/{id}")
    public HashtagPortfolio update(@PathVariable Long id, @RequestBody HashtagPortfolio obj) {
        return service.update(id, obj);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
