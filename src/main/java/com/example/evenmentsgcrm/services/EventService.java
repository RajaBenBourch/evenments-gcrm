package com.example.evenmentsgcrm.services;

import com.example.evenmentsgcrm.dto.EventDTO;
import jakarta.persistence.EntityNotFoundException;
import com.example.evenmentsgcrm.entity.Event;
import com.example.evenmentsgcrm.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.evenmentsgcrm.repository.EventRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapper eventMapper;

    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = eventMapper.toEntity(eventDTO);
        event = eventRepository.save(event);
        return eventMapper.toDTO(event);
    }
    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(eventMapper::toDTO).collect(Collectors.toList());
    }
    public EventDTO getEventById(Long id) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event == null) {
            // Gérer l'exception ou retourner null / une DTO vide selon le cas
            throw new EntityNotFoundException("Event not found with id: " + id);
        }
        return eventMapper.toDTO(event);
    }



    public EventDTO updateEvent(Long id, EventDTO eventDTO) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id: " + id));

        Event updatedEvent = eventMapper.toEntity(eventDTO);
        updatedEvent.setId(existingEvent.getId()); // Assure que l'ID reste le même

        updatedEvent = eventRepository.save(updatedEvent);

        return eventMapper.toDTO(updatedEvent);
    }

    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id: " + id));

        eventRepository.delete(event);
    }



}
