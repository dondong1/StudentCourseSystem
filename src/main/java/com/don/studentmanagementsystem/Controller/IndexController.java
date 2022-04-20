package com.don.studentmanagementsystem.Controller;

import com.don.studentmanagementsystem.Entity.Course;
import com.don.studentmanagementsystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private CourseService service;
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public String viewHomePage(Model model) {
        List<Course> listcourse = service.listAll();
        model.addAttribute("listcourse", listcourse);
        model.addAttribute("course", new Course());
        return "Course";
    }
}
