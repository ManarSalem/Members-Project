package com.example.content.repository;

import com.example.content.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends
        JpaRepository<Course,Integer> {
}
