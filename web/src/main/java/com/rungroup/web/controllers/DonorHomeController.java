package com.rungroup.web.controllers;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rungroup.web.models.Course;
import com.rungroup.web.models.Event;
import com.rungroup.web.models.Teacher;
import com.rungroup.web.repositories.Implementations.CourseRepository;
import com.rungroup.web.repositories.Implementations.EventRepository;
import com.rungroup.web.repositories.Implementations.TeacherRepository;

@Controller
public class DonorHomeController {

    @GetMapping("/donor")
    public String DonorHomePage(Model model) {
        List<Course> courses = new CourseRepository().findAll();
        List<Teacher> teachers = new TeacherRepository().findAll();
        List<Event> events = new EventRepository().findAll();

        model.addAttribute("courses", courses);
        model.addAttribute("teachers", teachers);
        model.addAttribute("events", events);

        return "donorHome"; 
    }
}
