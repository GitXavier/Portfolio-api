package com.wcs.portfolio.bundle.hashtagBlog;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class HashtagBlogService {

    @Autowired
    HashtagBlogRepository repository;

    @Autowired
    protected ModelMapper modelMapper;

    public List<HashtagBlog> getAll() { return this.repository.findAll(); }

    public HashtagBlog getById( Long id ) { return this.repository.findById(id).get(); }

    public HashtagBlog add( HashtagBlog item) { return this.repository.save(item); }

    public HashtagBlog update( Long id, HashtagBlog newObj) {

        if (newObj.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inconsistent parameter");
        }

        Optional<HashtagBlog> obj = this.repository.findById(newObj.getId());
        HashtagBlog updateObj = obj.get();

        this.modelMapper.map(newObj, updateObj);

        return repository.save(updateObj);
    }

    public boolean delete( Long id ) {

        repository.deleteById(id);
        return true;
    }
}
