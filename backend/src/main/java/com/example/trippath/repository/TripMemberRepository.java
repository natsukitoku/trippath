package com.example.trippath.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.trippath.entity.TripMember;


public interface TripMemberRepository extends JpaRepository<TripMember, Integer> {
    
    @Query("SELECT tm FROM TripMember tm WHERE tripId = :id AND deletedAt Is NULL")
    public List<TripMember> findAllById(Integer id);
}
