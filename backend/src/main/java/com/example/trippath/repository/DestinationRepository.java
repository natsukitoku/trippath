package com.example.trippath.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.trippath.entity.Destination;

@Repository
public interface DestinationRepository extends  JpaRepository<Destination, Integer>{

    @Query("SELECT d FROM Destination d WHERE d.tripId = :id AND deletedAt IS NULL")
    public List<Destination> findAllById(Integer id);
}