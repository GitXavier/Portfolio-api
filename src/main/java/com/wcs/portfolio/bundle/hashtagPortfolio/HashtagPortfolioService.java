package com.wcs.portfolio.bundle.hashtagPortfolio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class HashtagPortfolioService {

    @Autowired
    HashtagPortfolioRepository repository;

    @Autowired
    protected ModelMapper modelMapper;

    public List<HashtagPortfolio> getAll() { return this.repository.findAll(); }

    public HashtagPortfolio getById( Long id ) { return this.repository.findById(id).get(); }

    public HashtagPortfolio add( HashtagPortfolio item) { return this.repository.save(item); }

    public HashtagPortfolio update( Long id, HashtagPortfolio newObj) {

        if (newObj.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inconsistent parameter");
        }

        Optional<HashtagPortfolio> obj = this.repository.findById(newObj.getId());
        HashtagPortfolio updateObj = obj.get();

        this.modelMapper.map(newObj, updateObj);

        return repository.save(updateObj);
    }

    public boolean delete( Long id ) {

        repository.deleteById(id);
        return true;
    }
}
