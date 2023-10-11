package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    @Transactional(readOnly = true)
    public List<CityDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(CityDTO::new)
                .sorted(Comparator.comparing(CityDTO::getName))
                .toList();
    }

    @Transactional
    public CityDTO insert(CityDTO city) {
        City saved = new City();
        city.setName(city.getName());
        city.setId(repository.save(saved).getId());

        return city;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
