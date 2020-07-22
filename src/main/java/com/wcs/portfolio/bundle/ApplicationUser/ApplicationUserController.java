package com.wcs.portfolio.bundle.ApplicationUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class ApplicationUserController {

    @Autowired
    ApplicationUserService service;

    @GetMapping
    public List<ApplicationUser> getPropertyAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ApplicationUser getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ApplicationUser add(@RequestBody ApplicationUser obj) {
        return service.add(obj);
    }

    @PatchMapping("/{id}")
    public ApplicationUser update(@PathVariable Long id, @RequestBody ApplicationUser obj) {
        return service.update(id, obj);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
