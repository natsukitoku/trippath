package com.example.trippath.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.trippath.entity.Trip;
import com.example.trippath.form.TripForm;
import com.example.trippath.repository.TripRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository repository;

    public List<Trip> getAllTrips(Integer creatorId) {
        List<Trip> trips = repository.findAll(creatorId);
        return trips;
    }
    
    public void create(TripForm form, Integer creatorId) {
        Trip trip = new Trip();
        trip.setCreatorId(creatorId);
        trip.setTitle(form.getTitle());
        trip.setStartDate(form.getStartDate());
        trip.setEndDate(form.getEndDate());
        trip.setCreatedAt(LocalDateTime.now());
        trip.setUpdatedAt(LocalDateTime.now());
        repository.save(trip);
    }

    public void update(TripForm form, Integer id) {
        Trip trip = findById(id);
        if (!trip.getTitle().equals(form.getTitle())) {
            trip.setTitle(form.getTitle());
        }
        if (!trip.getStartDate().equals(form.getStartDate())) {
            trip.setStartDate(form.getStartDate());
        }
        if (!trip.getEndDate().equals(form.getEndDate())) {
            trip.setEndDate(form.getEndDate());
        }
        trip.setUpdatedAt(LocalDateTime.now());
        repository.save(trip);
    }

    public void delete(Integer id) {
        Trip trip = findById(id);
        if (trip != null) {
            trip.setDeletedAt(LocalDateTime.now());
            repository.save(trip);
        }
    }

    public Trip findById(Integer id) {
        Optional<Trip> trip = repository.findById(id);
         Trip tr = trip.get();
         return tr;
    }
}
