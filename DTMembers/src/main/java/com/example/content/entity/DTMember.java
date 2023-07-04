package com.example.content.entity;

import com.example.content.dto.DTMemberDTO;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Builder
@Slf4j
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="DTMember")


public class DTMember {
@Id

@SequenceGenerator(
        name = "DTMember_sequence",
        sequenceName = "DTMember_sequence" ,
        allocationSize = 1
)
@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "DTMember_sequence"
)
    private Integer Id;

    private String name ;
    private String team;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="department_id")
    private Department department;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="member_courses",
            joinColumns = @JoinColumn(name="member_id"),
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private List<Course> courses;


 public DTMember(String name, String team)
 {
   // department.setDepId(depId);
     this.name=name;
     this.team=team;


 }



}
