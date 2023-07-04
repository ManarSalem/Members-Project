package com.example.content.configuration;

import com.example.content.entity.DTMember;
import com.example.content.entity.Department;
import com.example.content.repository.DTMemberRepository;
import com.example.content.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DTMemberConfig {

    @Bean
    CommandLineRunner commandLineRunner(DTMemberRepository repository, DepartmentRepository departmentRepository) {
        return args -> {
            DTMember Manar = new DTMember(
                    "Manar BinOwayid",
                    "MS");

            DTMember Tarek = new DTMember(
                    "Tarek Asseri",
                    "MS");

            DTMember Mohammad = new DTMember(
                    "Mohammad ALdress",
                    "MS");

            DTMember Faisal = new DTMember(
                    "Faisal ALtweely",
                    "MS");

            DTMember Ziyad = new DTMember(
                    "Ziyad ALmotlaq",
                    "MS");

            DTMember Abdullah = new DTMember(
                    "Abdullah ALmelfi",
                    "MS");

            DTMember Abdullah_Alhabib = new DTMember(
                    "Abdullah ALhabib",
                    "EP");

            DTMember Alwaleed = new DTMember(
                    "Alwaleed ALsamlaq",
                    "EP");
            DTMember Faris = new DTMember(
                    "Faris ALmutairi",
                    "EP");
            DTMember Mohammad_Aba = new DTMember(
                    "Mohammad Aba ALkhayl",
                    "EP");
            DTMember Mohammad_ALsaawi = new DTMember(
                    "Mohammad ALsaawi",
                    "EP");

            List<DTMember> members = List.of(Manar
                    , Tarek
                    , Mohammad
                    , Faisal
                    , Abdullah
                    , Ziyad
                    , Abdullah_Alhabib
                    , Alwaleed
                    , Faris
                    , Mohammad_ALsaawi
                    , Mohammad_Aba);
            repository.saveAll(members);

//            Department department= new Department(
//                    1
//                    ,"OCP"
//                    ,"Mohammad Alrashidi",
//                    members  );
            Department department2= new Department(
                    2
                    ,"Dev"
                  );
            Department department3= new Department(
                    3
                    ,"buisness"
            );
            Department department4= new Department(
                    4
                    ,"test"
            );

            List<Department> depList=List.of(department3,department2,department4);
           // departmentRepository.save(department);
            departmentRepository.saveAll(depList);
        };






    }

}