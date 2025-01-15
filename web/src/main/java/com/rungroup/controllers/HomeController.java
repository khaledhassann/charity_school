package com.rungroup.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;
import com.rungroup.models.*;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(Model model) {

        return "home";
    }
}