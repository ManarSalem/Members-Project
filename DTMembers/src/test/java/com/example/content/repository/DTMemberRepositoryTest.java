package com.example.content.repository;

import com.example.content.entity.Address;
import com.example.content.entity.DTMember;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DTMemberRepositoryTest {

    @Autowired
    private DTMemberRepository repo;

    @Autowired
    private AddressRepository addRepo;


    @Test
    public  void additionTest(){
        Address adress = Address
                .builder()
                .city("riyadh")
                .id(1).build();


        DTMember member= DTMember.builder()
                .name("manar")
                .team("ms")
                .address(adress)
                .build();

      DTMember savedMember= repo.save(member);

      Optional<Address> savedAddress= addRepo.findById(1);

      List<DTMember> members=repo.findAll();
        Optional<DTMember> notFoundMember= repo.findById(90);

        Assertions.assertThat(savedMember).isNotNull();

        Assertions.assertThat(notFoundMember).isEmpty();
        Assertions.assertThat(members.size()).isEqualTo(1);
        Assertions.assertThat(savedMember.getName()).isEqualTo("manar");
        Assertions.assertThat(savedMember.getTeam()).isEqualTo("ms");
        Assertions.assertThat(savedMember.getAddress().getCity()).isNotEqualTo("jeddah");

        Assertions.assertThat(savedAddress).isNotEmpty();
        Assertions.assertThat(savedAddress.get().getCity()).isEqualTo("riyadh");


        assertAll("addition operation test",
                ()-> Assertions.assertThat(members.size()).isEqualTo(1),
                ()-> Assertions.assertThat(savedMember.getName()).isEqualTo("manar"),
                ()->Assertions.assertThat(savedMember.getTeam()).isEqualTo("ms") );


    }

    @Test
    public void updationTest(){
        Address address = Address
                .builder()
                .city("riyadh")
                .id(1).build();
        DTMember member= DTMember.builder()
                .name("manar")
                .team("ms")
                .address(address)
                .build();

         DTMember savedMember=repo.save(member);

        savedMember.setTeam("micro");
        savedMember.setName("meme");
        savedMember.getAddress().setCity("Jeddah");


        Assertions.assertThat(savedMember.getName()).isEqualTo("meme");
        Assertions.assertThat(savedMember.getTeam()).isEqualTo("micro");
        Assertions.assertThat(savedMember.getId()).isEqualTo(1);
        Assertions.assertThat(savedMember.getAddress().getCity()).isEqualTo("Jeddah");


    }

    @Test
    public void deletionTest(){
        DTMember member= DTMember.builder()
                .Id(1)
                .name("manar")
                .team("ms")
                .build();

        repo.save(member);

        repo.deleteById(1);

        List<DTMember> members= repo.findAll();

        Optional<DTMember> member2=repo.findById(1);

        Assertions.assertThat(member2).isEmpty();
        Assertions.assertThat(members).isEmpty();

    }

}