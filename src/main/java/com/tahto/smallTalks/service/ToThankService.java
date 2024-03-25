package com.tahto.smallTalks.service;

import com.tahto.smallTalks.entity.ToThank;
import com.tahto.smallTalks.exception.FindToThankNullException;
import com.tahto.smallTalks.exception.ToThankAlreadyExistsNullException;
import com.tahto.smallTalks.exception.ToThankNullException;
import com.tahto.smallTalks.repository.ToThankRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToThankService {
    private final ToThankRepository repository;

    public ToThankService(ToThankRepository repository) {
        this.repository = repository;
    }

    public ToThank add(ToThank toThank) {
        if (toThank.getName() == null)
            throw new ToThankNullException();

        List<ToThank> list = this.findAll();

        if(list.contains(toThank))
            throw new ToThankAlreadyExistsNullException();

        return repository.save(toThank);
    }

    public List<ToThank> findAll() {
        return repository.findAll();
    }

    public ToThank getById(Long id) {
        return repository.findById(id).orElseThrow(FindToThankNullException::new);
    }

    public ToThank update(Long id, ToThank entryToThank) {
        ToThank toThank = this.getById(id);

        toThank.setName(entryToThank.getName());
        return repository.save(toThank);
    }

    public void delete(Long id) {
        ToThank toThank = this.getById(id);
        repository.delete(toThank);
    }
}
