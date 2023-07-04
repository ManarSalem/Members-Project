package com.example.content.repository;

import com.example.content.entity.Address;
import com.example.content.entity.DTMember;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AddressRepositoryTest {

    @Autowired
    DTMemberRepository dtRepo;

    @Autowired
    AddressRepository addRepo;

        DTMember member = DTMember
                                .builder()
                                .name("Manar")
                                .team("ms")
                                .build();

        Address adress = Address
                            .builder()
                            .city("riyadh")
                            .id(1).build();




    @Test
    void memberWithAddressTest(){
        member.setAddress(adress);
     //   adress.setMember(member);

        DTMember savedMember= dtRepo.save(member);
        Address savedAddress=  addRepo.save(adress);

        Integer memberId=savedMember.getId();
        Optional<DTMember> savedMem= dtRepo.findById(memberId);

        Assertions.assertThat(savedMember.getName()).isEqualTo("Manar");
        Assertions.assertThat(savedMember.getAddress().getCity()).isEqualTo("riyadh");

      //  Assertions.assertThat(savedAddress.getMember().getName()).isEqualTo("Manar");
    }




}
