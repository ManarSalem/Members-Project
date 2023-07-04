package com.example.content.service;

import com.example.content.dto.DTMemberDTO;
import com.example.content.entity.DTMember;

import java.util.List;

public interface DTMemberService {

    List<DTMemberDTO> getAllMembers();

    DTMemberDTO getDTMemberById(Integer id);

    List<DTMemberDTO> getMembersInTeam(String team);

    DTMemberDTO addDTMember(DTMemberDTO memberDTO);

    void deleteDTMember(Integer id);

    void update(Integer id, String team);

    DTMemberDTO update2(Integer id, DTMemberDTO updatedDTMemberDTO);
}
