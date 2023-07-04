package com.example.content.controller;

import com.example.content.entity.Department;
import com.example.content.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentController {


    DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

@GetMapping("/names")
    public List<String> getAllDepartmentsNames(){

       List<String> depNames= new ArrayList<String>();
        List<Department> departments =  departmentRepository.findAll();
        for(Department obj : departments ){
           depNames.add(obj.getDepartmentName());
        }
        return depNames;
    }


}
