package com.example.content.serviceImp;

import com.example.content.dto.DTMemberDTO;
import com.example.content.entity.DTMember;
import com.example.content.repository.DTMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ExtendWith(MockitoExtension.class)
class DTMemberServiceImpTest {

    @Mock
    DTMemberRepository repo;

    //AutoCloseable closeable;
    @InjectMocks
    DTMemberServiceImp service;




//    @BeforeEach
//    void setUp(){
//        closeable= MockitoAnnotations.openMocks(this);
//        service= new DTMemberServiceImp(repo,converter);
//    }
//
//    @AfterEach
//    void tearDown()throws Exception{
//        closeable.close();
//    }
    @Test
    public void creationTest(){
        DTMember member= DTMember.builder()
                .Id(1)
                .name("manar")
                .team("ms")
                .build();
        DTMemberDTO memberDTO=DTMemberDTO.builder()
                .Id(1)
                .name("manar")
                .team("ms")
                .build();


        when(repo.save(Mockito.any(DTMember.class))).thenReturn(member);

        DTMemberDTO savedMemberDTO= service.addDTMember(memberDTO);

        Assertions.assertThat(savedMemberDTO).isNotNull();
        Assertions.assertThat(savedMemberDTO.getId()).isEqualTo(1);
        Assertions.assertThat(savedMemberDTO.getName()).isEqualTo("manar");
        Assertions.assertThat(savedMemberDTO.getTeam()).isEqualTo("ms");


    }


}