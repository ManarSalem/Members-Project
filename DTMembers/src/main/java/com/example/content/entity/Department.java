package com.example.content.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Builder
@Slf4j
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Department {

    @Id
    @SequenceGenerator(
            name = "Department_sequence",
            sequenceName = "Department_sequence" ,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Department_sequence"
    )
    private Integer departmentId;

    private String departmentName;

    private String manager;

    @OneToMany(mappedBy = "department")
    //@JoinColumn(name="department_id")
     private List<DTMember> members ;

    public Department(Integer id, String departmentName){
        this.departmentId=id;
        this.departmentName=departmentName;
    }

    public Department(String departmentName)
    {
        this.departmentName=departmentName;
    }
}
