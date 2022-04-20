package com.don.studentmanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.don.studentmanagementsystem.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}