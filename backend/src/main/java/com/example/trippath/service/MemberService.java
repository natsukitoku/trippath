package com.example.trippath.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.trippath.entity.Member;
import com.example.trippath.form.MemberForm;
import com.example.trippath.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public void create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());
        member.setCreatedAt(LocalDateTime.now());
        member.setUpdatedAt(LocalDateTime.now());
        repository.save(member);
    }

    public void update(MemberForm form, Integer id) {
        Member member = findById(id);
        if (!member.getName().equals(form.getName())) {
            member.setName(form.getName());
        }
        if (!member.getEmail().equals(form.getEmail())) {
            member.setEmail(form.getEmail());
        }
        if (!member.getPassword().equals(form.getPassword())) {
            member.setPassword(form.getPassword());
        }
        member.setUpdatedAt(LocalDateTime.now());
        repository.save(member);
    }

    public void delete(Integer id) {
         Member member = findById(id);
         if (member != null) {
            member.setDeletedAt(LocalDateTime.now());
            repository.save(member);
         }
    }
    
    public Member findById(Integer id) {
        Optional<Member> member = repository.findById(id);
         Member mem = member.get();
         return mem;
    }
}
