// package com.rungroup.controllers;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import com.rungroup.models.*;

// @Controller
// public class ViewScheduleController {

//     @GetMapping("/view-schedule")
//     public String viewSchedule(Model model) {
//         List<ScheduleEntry> scheduleEntries = Arrays.asList(
//             new ScheduleEntry("Monday", "Period 1", "History", "Room 101"),
//             new ScheduleEntry("Tuesday", "Period 2", "Science", "Lab 202"),
//             new ScheduleEntry("Wednesday", "Period 5", "Maths", "Room 103"),
//             new ScheduleEntry("Thursday", "Period 3", "English", "Room 104"),
//             new ScheduleEntry("Friday", "Period 6", "History", "Room 109"),
//             new ScheduleEntry("Saturday", "Period 6", "History", "Room 109")
//         );

//         model.addAttribute("scheduleEntries", scheduleEntries);
//         return "view-schedule";
//     }
// }
