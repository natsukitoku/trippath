package com.example.trippath.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.trippath.entity.TripMember;
import com.example.trippath.form.TripMemberForm;
import com.example.trippath.repository.TripMemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TripMemberService {
    
    private final TripMemberRepository repository;

    public List<TripMember> findAllById(Integer id) {
        List<TripMember> members = repository.findAllById(id);
        return members;
    }

    public void addFriend(TripMemberForm form) {
        TripMember tripMember = new TripMember();
        tripMember.setTripId(form.getTripId());
        tripMember.setMemberId(form.getMemberId());
        tripMember.setCreatedAt(LocalDateTime.now());
        repository.save(tripMember);
    }

    public void delete(Integer id) {
        TripMember tripMember = findById(id);
        tripMember.setDeletedAt(LocalDateTime.now());
        repository.save(tripMember);
    }

    public TripMember findById(Integer id) {
        Optional<TripMember> res = repository.findById(id);
        TripMember tripMember = res.get();
        return tripMember;
    }
}
