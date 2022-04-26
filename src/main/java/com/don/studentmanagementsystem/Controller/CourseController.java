package com.don.studentmanagementsystem.Controller;
import java.util.List;

import com.don.studentmanagementsystem.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.don.studentmanagementsystem.Entity.Course;
import com.don.studentmanagementsystem.Service.CourseService;

@Controller
@RequestMapping("/Course")
public class CourseController {
    @Autowired
    private CourseService service;

    @GetMapping("/search")
    public ResponseEntity<List<Course>> searchCourses(@RequestParam("query") String query){
        return ResponseEntity.ok(service.searchServices(query));
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return service.createCourse(course);
    }

    @GetMapping("/addcourse")
    public String add(Model model) {
        List<Course> listcourse = service.listAll();
        model.addAttribute("listcourse", listcourse);
        model.addAttribute("course", new Course());
        return "addcourse";
    }

    @RequestMapping(value = "Course/save", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("course") Course course) {
        service.save(course);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCoursePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("addcourse");
        Course course = service.get(id);
        mav.addObject("course", course);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deleteCoursePage(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }

//    @Autowired
//    private CourseRepository courseRepository;
//
//    @GetMapping("/getAllCourses")
//    public List<Course> getAllCourses() {
//        return courseRepository.findAll();}



}