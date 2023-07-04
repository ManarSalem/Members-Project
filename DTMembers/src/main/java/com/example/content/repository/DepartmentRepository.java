package com.example.content.repository;

import com.example.content.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository
        extends JpaRepository<Department,Integer> {
}
