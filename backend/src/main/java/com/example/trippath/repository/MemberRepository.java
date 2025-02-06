package com.example.trippath.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trippath.entity.Member;

public interface MemberRepository  extends JpaRepository<Member, Integer>{

    // @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Member m WHERE m.id = :id")
    // public boolean existsById(Integer id);
}
