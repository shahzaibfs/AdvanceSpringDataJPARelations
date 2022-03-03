package com.example.rdbmsPractice.repository;

import com.example.rdbmsPractice.entity.CourseContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseContentRepo extends JpaRepository<CourseContent,Integer> {

    CourseContent findById(int id);
}
