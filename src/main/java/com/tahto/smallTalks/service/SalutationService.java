package com.tahto.smallTalks.service;

import com.tahto.smallTalks.entity.Salutation;
import com.tahto.smallTalks.exception.SalutationAlreadyExistsNullException;
import com.tahto.smallTalks.exception.FindSalutationNullException;
import com.tahto.smallTalks.exception.SalutationNullException;
import com.tahto.smallTalks.repository.SalutationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalutationService {

    private final SalutationRepository repository;

    public SalutationService(SalutationRepository repository) {
        this.repository = repository;
    }

    public List<Salutation> findAll() {
        return repository.findAll();
    }

    public Salutation add(Salutation salutation) {
        if(salutation.getName() == null)
            throw new SalutationNullException();

        List<Salutation> list = this.findAll();

        if(list.contains(salutation)) {
            throw new SalutationAlreadyExistsNullException();
        }

        return repository.save(salutation);
    }

    public Salutation findSalutationById(Long id) {
        return repository.findById(id).orElseThrow(FindSalutationNullException::new);
    }

    public Salutation updateSalutation(Long id, Salutation entrySalutation) {
        Salutation salutation = this.findSalutationById(id);

        salutation.setName(entrySalutation.getName());

        return repository.save(salutation);
    }

    public void delete(Long id) {
        Salutation salutation = this.findSalutationById(id);
        repository.delete(salutation);
    }

}
