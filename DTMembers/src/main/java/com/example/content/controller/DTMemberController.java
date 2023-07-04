package com.example.content.controller;

import com.example.content.dto.DTMemberDTO;
import com.example.content.service.DTMemberService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("dt")// localhost:8080/dt
public class DTMemberController {

   private final DTMemberService dTMemberService;


   @Autowired
    public DTMemberController(DTMemberService dTMemberService) {
        log.info("In  DTMemberController constructor");
       this.dTMemberService = dTMemberService;
       log.info("After autowriing service");
    }

    @GetMapping("/members")// localhost:8080/api/members
    public List<DTMemberDTO> getAllMembers(){

        return dTMemberService.getAllMembers();
   }
    @GetMapping("/members/{id}")// localhost:8080/api/members/3
    public DTMemberDTO getMemberById(@PathVariable("id") Integer id){

        return  dTMemberService.getDTMemberById(id);
    }

//    @GetMapping("/members/req")
//    public DTMember getMemberById2(@RequestParam(name="id") Integer id){
//       return dTMemberService.getDTMemberById(id); it work
//    }

    @GetMapping("/members/teams/{team}")// localhost:8080/api/members/teams/ms
    public List<DTMemberDTO> getMembersInTeam(@PathVariable("team") String team){

        return dTMemberService.getMembersInTeam(team);
    }

    @PostMapping()
    public DTMemberDTO add( @RequestBody DTMemberDTO memberDTO){

      return dTMemberService.addDTMember(memberDTO);
    }

    @DeleteMapping("/delete/{Id}")
    public void delete(@PathVariable("Id") Integer Id){

       dTMemberService.deleteDTMember(Id);
    }



    @PutMapping("update/{id}/{team}")
    public void update(@PathVariable("id") Integer id, @PathVariable("team") String team){

        dTMemberService.update( id,  team);
    }
    @PutMapping("update2/{id}")
     public DTMemberDTO update2(@PathVariable("id") Integer id,@RequestBody DTMemberDTO updatedDTMemberDTO){
       log.info("calling update2 to update a DTmember");
         return dTMemberService.update2(id,updatedDTMemberDTO);
     }

}
