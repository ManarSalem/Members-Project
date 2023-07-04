package com.example.content.serviceImp;

import com.example.content.dto.DTMemberDTO;
import com.example.content.entity.DTMember;
import com.example.content.repository.DTMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.stereotype.Component;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class DTMemberServiceImpTest2 {

    @Mock private DTMemberRepository repo;


    @Mock Converter converter = new Converter();
   @InjectMocks private DTMemberServiceImp  service ;

   @Captor private  ArgumentCaptor<DTMember> DTArgumentCapture;
    @Test
    public void GetAllTest(){


        service.getAllMembers();
        verify(repo).findAll();// we checked here that the mock repo is called


    }
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        service = new DTMemberServiceImp(repo, converter);
    }

    @Test
    public void addTest(){

        DTMemberDTO memberDTO=DTMemberDTO.builder()
                .name("manar")
                .team("ms")
                .build();

        DTMemberDTO returnedDTO=service.addDTMember(memberDTO);

         // captured object passeed into mocked mathod-> repo.save()
        DTArgumentCapture= ArgumentCaptor.forClass(DTMember.class);

        verify(repo).save(DTArgumentCapture.capture());

        DTMember capturedMemberValue = DTArgumentCapture.getValue();
        given(repo.save(DTArgumentCapture.capture()))
                       .willReturn(capturedMemberValue);

        DTMember returned=converter.convert(returnedDTO, DTMember.class);

//        Assertions.assertThat(returnedDTO.getTeam()).isEqualTo("ms");
//        Assertions.assertThat(returnedDTO.getName()).isEqualTo("manar");
//        Assertions.assertThat(returnedDTO).isNotNull();
    }





}
