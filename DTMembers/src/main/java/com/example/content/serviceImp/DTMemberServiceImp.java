package com.example.content.serviceImp;

import com.example.content.dto.DTMemberDTO;
import com.example.content.entity.DTMember;
import com.example.content.exceptions.DTMemberNotFoundException;
import com.example.content.repository.DTMemberRepository;
import com.example.content.service.DTMemberService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class DTMemberServiceImp implements DTMemberService {

    private final DTMemberRepository dtMemberRepository;
    private final Converter converter;
    @Autowired
    public DTMemberServiceImp(DTMemberRepository dtMemberRepository, Converter converter) {
        log.info("in DTMemberServiceImp constructor");
        this.dtMemberRepository = dtMemberRepository;
        this.converter = converter;
        log.info("after autowiring dependencies");
    }


    //business logic

    public List<DTMemberDTO> getAllMembers(){
        List<DTMemberDTO> members=converter
                            .toList(dtMemberRepository.findAll(), DTMemberDTO.class);
        return members;
    }
    public DTMemberDTO getDTMemberById(Integer id) {

//        Optional<DTMember> member= Optional.of(dtMemberRepository.findById(id).get());
//        if(member.isPresent()){
//
//            return member.get();
//        }
//        throw new IllegalStateException("no DTMember with such an id");

        DTMember member2= dtMemberRepository.findById(id).orElseThrow(()->
                new DTMemberNotFoundException("no member found"));
        DTMemberDTO member3= converter.convert(member2, DTMemberDTO.class);
        return member3;
    }

    public List<DTMemberDTO> getMembersInTeam(String team){
        List<DTMemberDTO> membersInTeam=converter
                .toList( dtMemberRepository.findByTeamIgnoreCase(team), DTMemberDTO.class);

        return membersInTeam;


    }
    public DTMemberDTO addDTMember(DTMemberDTO memberDTO) {

        DTMember member=converter.convert(memberDTO, DTMember.class);
        //dtMemberRepository.save(member);
      DTMemberDTO returnedMemberDTO= converter
                  .convert(dtMemberRepository.save(member), DTMemberDTO.class);
       return  returnedMemberDTO;/*why?
        beacuse when adding  we do not specify ID,
        so if we return the memberDTO the id feild will be null*/
    }


    public  void deleteDTMember(Integer id) {

        dtMemberRepository.deleteById(id);
    }



    @Transactional
    public void update(Integer id, String team) {
        DTMember member= dtMemberRepository.findById(id).orElseThrow(()->
                new DTMemberNotFoundException("no member found"));
        if(member.getTeam().equals(team)){
            System.out.println("same team");
        }else {
            member.setTeam(team);
        }


    }
    @Transactional
    public DTMemberDTO update2(Integer id, DTMemberDTO updatedDTMemberDTO){

        log.info("inside update2, check member exsis or throw DTMemberNotFoundException");
        DTMember member= dtMemberRepository.findById(id).orElseThrow(()->
                new DTMemberNotFoundException("no member found"));
        log.info("member exist, check if new info are valid");

        if(updatedDTMemberDTO.getName()!=null && updatedDTMemberDTO.getName()!= member.getName()){
            member.setName(updatedDTMemberDTO.getName());
        }
        if(updatedDTMemberDTO.getTeam()!=null && updatedDTMemberDTO.getTeam()!= member.getTeam()){
            member.setTeam(updatedDTMemberDTO.getTeam());
        }
        if(updatedDTMemberDTO.getAddress()!=null &&updatedDTMemberDTO.getAddress().getCity()!=member.getAddress().getCity()){
            member.setAddress(updatedDTMemberDTO.getAddress());
        }
        if(updatedDTMemberDTO.getCourses()!=null &&!updatedDTMemberDTO.getCourses().equals(member.getCourses())){
            member.setCourses(updatedDTMemberDTO.getCourses());
        }
        if(updatedDTMemberDTO.getDepartment()!=null&&!updatedDTMemberDTO.getDepartment().equals(member.getDepartment())){
            member.setDepartment(updatedDTMemberDTO.getDepartment());
        }
        log.info("member updated succesfuly");


        return converter.convert(member, DTMemberDTO.class);
    }
}
