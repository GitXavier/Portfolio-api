package com.wcs.portfolio.bundle.ApplicationUser;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserService {

    @Autowired
    ApplicationUserRepository repository;

    @Autowired
    protected ModelMapper modelMapper;

    public List<ApplicationUser> getAll() { return this.repository.findAll(); }

    public ApplicationUser getById( Long id ) { return this.repository.findById(id).get(); }

    public ApplicationUser add( ApplicationUser item) { return this.repository.save(item); }

    public ApplicationUser update( Long id, ApplicationUser newObj) {

        if (newObj.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inconsistent parameter");
        }

        Optional<ApplicationUser> obj = this.repository.findById(newObj.getId());
        ApplicationUser updateObj = obj.get();

        this.modelMapper.map(newObj, updateObj);

        return repository.save(updateObj);
    }

    public boolean delete( Long id ) {

        repository.deleteById(id);
        return true;
    }
}
