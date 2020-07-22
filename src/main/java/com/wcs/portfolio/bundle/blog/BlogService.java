package com.wcs.portfolio.bundle.blog;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    BlogRepository repository;

    @Autowired
    protected ModelMapper modelMapper;

    public List<Blog> getAll() { return this.repository.findAll(); }

    public Blog getById( Long id ) { return this.repository.findById(id).get(); }

    public Blog add( Blog item) { return this.repository.save(item); }

    public Blog update( Long id, Blog newObj) {

        if (newObj.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inconsistent parameter");
        }

        Optional<Blog> obj = this.repository.findById(newObj.getId());
        Blog updateObj = obj.get();

        this.modelMapper.map(newObj, updateObj);

        return repository.save(updateObj);
    }

    public boolean delete( Long id ) {

        repository.deleteById(id);
        return true;
    }
}
