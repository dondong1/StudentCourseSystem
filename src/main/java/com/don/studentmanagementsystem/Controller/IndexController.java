package com.don.studentmanagementsystem.Controller;

import com.don.studentmanagementsystem.Entity.Course;
import com.don.studentmanagementsystem.Entity.StudentDAO;
import com.don.studentmanagementsystem.Repository.StudentRepository;
import com.don.studentmanagementsystem.Service.CourseService;
import com.don.studentmanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private CourseService service;
    @Autowired
    private StudentService student;
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String viewStudentPage(Model model){
        List<StudentDAO> li = new ArrayList<>();
        for(Object[] o : studentRepository.findStudent()){
            StudentDAO student = new StudentDAO();
            student.setId(Long.parseLong(String.valueOf(o[0])));
            student.setStname((String) o[1]);
            student.setCoursename((String) o[2]);
            li.add(student);
        }
        model.addAttribute("liststudent", li);
        return "Student";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public String viewHomePage(Model model) {
        List<Course> listcourse = service.listAll();
        model.addAttribute("listcourse", listcourse);
//        model.addAttribute("course", new Course());
        return "course";
    }

    public StudentService getStudent() {
        return student;
    }

    public void setStudent(StudentService student) {
        this.student = student;
    }
}
