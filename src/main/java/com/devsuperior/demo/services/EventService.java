package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repositories.EventRepository;
import com.devsuperior.demo.services.exceptions.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public EventDTO updateById(Long id, EventDTO event) {
        try {
            Event founded = repository.getReferenceById(id);

            founded.setName(event.getName());
            founded.setDate(event.getDate());
            founded.setUrl(event.getUrl());
            founded.getCity().setId(event.getCityId());

            Event updated = repository.save(founded);
            return new EventDTO(updated);
        }
        catch (EntityNotFoundException e) {
            throw new NotFoundException("Event not founded");
        }
    }
}
