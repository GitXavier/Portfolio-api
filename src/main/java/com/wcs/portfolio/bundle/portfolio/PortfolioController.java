package com.wcs.portfolio.bundle.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/portfolios")
public class PortfolioController {

    @Autowired
    PortfolioService service;

    @GetMapping
    public List<Portfolio> getPropertyAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Portfolio getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Portfolio add(@RequestBody Portfolio obj) {
        return service.add(obj);
    }

    @PatchMapping("/{id}")
    public Portfolio update(@PathVariable Long id, @RequestBody Portfolio obj) {
        return service.update(id, obj);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
