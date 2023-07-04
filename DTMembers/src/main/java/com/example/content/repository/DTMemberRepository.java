package com.example.content.repository;

import com.example.content.entity.DTMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DTMemberRepository extends JpaRepository<DTMember,Integer> {

    // select * from DTMember where team=?
    //@Query("SELECT s FROM DTMember s WHERE s.team =?1")
    List<DTMember> findByTeamIgnoreCase(String team);




}


