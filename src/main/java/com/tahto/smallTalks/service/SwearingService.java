package com.tahto.smallTalks.service;


import com.tahto.smallTalks.entity.Swearing;
import com.tahto.smallTalks.exception.AlreadyExistsNullException;
import com.tahto.smallTalks.exception.FindSwearingNullException;
import com.tahto.smallTalks.exception.SwearingNullException;
import com.tahto.smallTalks.repository.SwearingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwearingService {

    private final SwearingRepository repository;

    public SwearingService(SwearingRepository repository) {
        this.repository = repository;
    }

    public Swearing add(Swearing swearing) {
        if(swearing.getName() == null)
            throw new SwearingNullException();

        List<Swearing> list = this.getAll();

        if(list.contains(swearing)) {
            throw new AlreadyExistsNullException();
        }

        return repository.save(swearing);
    }

    public List<Swearing> getAll() {
        return repository.findAll();
    }

    public Swearing getById(Long id) {
        return repository.findById(id).orElseThrow(FindSwearingNullException::new);
    }

}
