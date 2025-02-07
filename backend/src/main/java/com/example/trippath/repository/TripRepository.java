package com.example.trippath.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.trippath.entity.Trip;

@Repository
public interface TripRepository  extends JpaRepository<Trip, Integer>{

    @Query("SELECT t FROM Trip t WHERE t.creatorId = :id AND t.deletedAt IS NULL")
    public List<Trip> findAll(Integer id);
}
