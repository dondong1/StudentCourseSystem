package com.don.studentmanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.don.studentmanagementsystem.Entity.Course;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    @Query("SELECT p FROM Course p WHERE " + "p.coursename LIKE CONCAT('%',:query, '%') ")
    List<Course> searchServices(String query);
}