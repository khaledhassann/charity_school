package com.rungroup.web.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;
import com.rungroup.web.models.*;
import com.rungroup.web.models.Course;
import com.rungroup.web.repositories.Implementations.*;

@Controller
public class HomeController {
    private CourseRepository cr = new CourseRepository();
    private TeacherRepository tr = new TeacherRepository();
    private EventRepository er = new EventRepository(); 
    @GetMapping("/home")
    public String homePage(Model model) {

        List<Course> courses = cr.findAll();

        List<Teacher> teachers = tr.findAll();

        List<Event> events = er.findAll();

        model.addAttribute("courses", courses);
        model.addAttribute("teachers", teachers);
        model.addAttribute("events", events);

        return "home";
    }
}
