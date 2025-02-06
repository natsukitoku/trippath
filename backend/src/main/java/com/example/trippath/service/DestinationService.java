package com.example.trippath.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.trippath.entity.Destination;
import com.example.trippath.form.DestinationForm;
import com.example.trippath.repository.DestinationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DestinationService {
    
    private final DestinationRepository repository;

    public List<Destination> getAllDestinations(Integer tripId) {
        List<Destination> destinations =repository.findAllById(tripId);
        return destinations;
    }

    public void create(DestinationForm form) {
        Destination destination = new Destination();
        destination.setTripId(form.getTripId());
        destination.setName(form.getName());
        destination.setCategoryId(form.getCategoryId());
        destination.setAddress(form.getAddress());
        destination.setDescription(form.getDescription());
        destination.setLat(form.getLat());
        destination.setLon(form.getLon());
        destination.setCreatedAt(LocalDateTime.now());
        destination.setUpdatedAt(LocalDateTime.now());
        repository.save(destination);
    }

    public void update(DestinationForm form, Integer id) {
        Destination destination = findById(id);
        if (!destination.getName().equals(form.getName())) {
            destination.setName(form.getName());
        }
        if (!destination.getCategoryId().equals(form.getCategoryId())) {
            destination.setCategoryId(form.getCategoryId());
        }
        if (!destination.getAddress().equals(form.getAddress())) {
            destination.setAddress(form.getAddress());
        }
        if (!destination.getDescription().equals(form.getDescription())) {
            destination.setDescription(form.getDescription());
        }
        if (destination.getLat() != form.getLat()) {
            destination.setLat(form.getLat());
        }
        if (destination.getLon() != form.getLon()) {
            destination.setLon(form.getLon());
        }
        destination.setUpdatedAt(LocalDateTime.now());
        repository.save(destination);
    }

    public void delete(Integer id) {
        Destination destination = findById(id);
        destination.setDeletedAt(LocalDateTime.now());
        repository.save(destination);
    }

    public Destination findById(Integer id) {
        Optional<Destination> res = repository.findById(id);
        Destination destination = res.get();
        return destination;
    }
}