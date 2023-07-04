package com.example.content.dto;

import com.example.content.entity.Address;
import com.example.content.entity.Course;
import com.example.content.entity.Department;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DTMemberDTO {

    private Integer Id;
    private String name ;
    private String team;
   // private Integer departmentId;
    private Address address;
    private Department department;

    private List<Course> courses;

}
