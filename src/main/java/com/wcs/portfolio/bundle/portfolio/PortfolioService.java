package com.wcs.portfolio.bundle.portfolio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    PortfolioRepository repository;

    @Autowired
    protected ModelMapper modelMapper;

    public List<Portfolio> getAll() { return this.repository.findAll(); }

    public Portfolio getById( Long id ) { return this.repository.findById(id).get(); }

    public Portfolio add( Portfolio item) { return this.repository.save(item); }

    public Portfolio update( Long id, Portfolio newObj) {

        if (newObj.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inconsistent parameter");
        }

        Optional<Portfolio> obj = this.repository.findById(newObj.getId());
        Portfolio updateObj = obj.get();

        this.modelMapper.map(newObj, updateObj);

        return repository.save(updateObj);
    }

    public boolean delete( Long id ) {

        repository.deleteById(id);
        return true;
    }
}
