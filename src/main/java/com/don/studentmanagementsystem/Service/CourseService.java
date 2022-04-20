package com.don.studentmanagementsystem.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.don.studentmanagementsystem.Entity.Course;
import com.don.studentmanagementsystem.Repository.CourseRepository;

@Service
public class CourseService
{
    @Autowired
    private CourseRepository repo;
    public List<Course> listAll() {
        return repo.findAll();
    }

    public void save(Course course) {
        repo.save(course);
    }

    public Course get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

}