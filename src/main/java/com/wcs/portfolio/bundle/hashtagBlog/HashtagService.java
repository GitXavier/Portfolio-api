package com.wcs.portfolio.bundle.hashtagBlog;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class HashtagService {

    @Autowired
    HashtagRepository repository;

    @Autowired
    protected ModelMapper modelMapper;

    public List<Hashtag> getAll() { return this.repository.findAll(); }

    public Hashtag getById(Long id ) { return this.repository.findById(id).get(); }

    public Hashtag add(Hashtag item) { return this.repository.save(item); }

    public Hashtag update(Long id, Hashtag newObj) {

        if (newObj.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inconsistent parameter");
        }

        Optional<Hashtag> obj = this.repository.findById(newObj.getId());
        Hashtag updateObj = obj.get();

        this.modelMapper.map(newObj, updateObj);

        return repository.save(updateObj);
    }

    public boolean delete( Long id ) {

        repository.deleteById(id);
        return true;
    }
}
