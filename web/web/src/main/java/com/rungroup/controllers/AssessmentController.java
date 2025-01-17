package com.rungroup.controllers;

import com.rungroup.models.Active;
import com.rungroup.models.Assessment;
import com.rungroup.models.Course;
import com.rungroup.models.Draft;
import com.rungroup.models.State;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AssessmentController {

    // List to store all assessments
    private static List<Assessment> assessments = new ArrayList<>();

    // Method to retrieve all assessments
    public static List<Assessment> getAssessments() {
        return new ArrayList<>(assessments);
    }

    // Method to add a new assessment
    public boolean addAssessment(Assessment assessment) {
        return assessments.add(assessment);
    }

    // Method to remove an assessment by its ID
    public boolean removeAssessment(Long id) {
        return assessments.removeIf(assessment -> assessment.getId().equals(id));
    }

    // Get active assessments for a specific course
    public static List<Assessment> getActiveAssessmentsForCourse(Course course) {
        return assessments.stream()
                .filter(assessment -> assessment.getCourse().getId().equals(course.getId()))
                .filter(assessment -> assessment.getState() instanceof Active) // Filter only active state
                .collect(Collectors.toList());
    }

    // Display the details of all assessments (for testing purposes)
    public String getDetails() {
        StringBuilder details = new StringBuilder("Assessment Details:\n");
        for (Assessment assessment : assessments) {
            details.append(assessment.toString()).append("\n");
        }
        return details.toString();
    }

    // Show the form for creating an assessment
    @GetMapping("/create-assessment")
    public String showCreateAssessmentForm(@RequestParam Long courseId, Model model) {
        Course selectedCourse = CourseController.getAvailableCourses().stream()
                .filter(course -> course.getId().equals(courseId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));
    
        model.addAttribute("selectedCourse", selectedCourse);
        return "create-assessment";
    }
    // Handle form submission to create a new assessment
//     @PostMapping("/create-assessment")
// public String createAssessment(@RequestParam("courseId") Long courseId,
//                                @RequestParam("name") String name,
//                                @RequestParam("weight") double weight,
//                                @RequestParam("maxScore") double maxScore,
//                                @RequestParam("deadline") LocalDateTime deadline,
//                                Model model) {
//     Course selectedCourse = CourseController.getAvailableCourses().stream()
//             .filter(course -> course.getId().equals(courseId))
//             .findFirst()
//             .orElseThrow(() -> new IllegalArgumentException("Course not found"));

//     Assessment newAssessment = new Assessment();
//     newAssessment.setName(name);
//     newAssessment.setWeight(weight);
//     newAssessment.setMaxScore(maxScore);
//     newAssessment.setDeadline(deadline);
//     newAssessment.setState(new Draft());
//    // newAssessment.setCourse(selectedCourse);
    

//     // Add the new assessment to the list
//     assessments.add(newAssessment);

//     // Debugging log
//     System.out.println("Assessment added successfully: " + newAssessment);
//     System.out.println("All assessments: " + assessments);
//     model.addAttribute("selectedCourse", newAssessment);
//     System.out.println("jjjj");

//     return "view-assessments";
// }
@PostMapping("/create-assessment")
public String createAssessment(@RequestParam("courseId") Long courseId,
                               @RequestParam("name") String name,
                               @RequestParam("weight") double weight,
                               @RequestParam("maxScore") double maxScore,
                               @RequestParam("deadline") LocalDateTime deadline,
                               Model model) {
    Course selectedCourse = CourseController.getAvailableCourses().stream()
            .filter(course -> course.getId().equals(courseId))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Course not found"));

    Assessment newAssessment = new Assessment();
    newAssessment.setName(name);
    newAssessment.setWeight(weight);
    newAssessment.setMaxScore(maxScore);
    newAssessment.setDeadline(deadline);
    newAssessment.setState(new Draft());
    newAssessment.setCourse(selectedCourse); // Link the course to the assessment

    assessments.add(newAssessment); // Add the new assessment to the list

    System.out.println("Assessment added successfully: " + newAssessment);
    System.out.println("All assessments: " + assessments);

    return "redirect:/view-assessments"; // Redirect to refresh the list
}


@GetMapping("/view-assessments")
public String viewAssessments(Model model) {
    System.out.println("Assessments being passed to the view:");
    for (Assessment assessment : assessments) {
        System.out.println("Assessment: " + assessment);
    }
    model.addAttribute("assessments", assessments); // Pass assessments to the model
    return "view-assessments"; // Return the view name for Thymeleaf
}


@PostMapping("/change-state")
public String changeState(@RequestParam("assessmentName") String assessmentName) {
    // Find the assessment by name
    Assessment assessment = assessments.stream()
            .filter(a -> a.getName().equals(assessmentName))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Assessment not found"));

    // Change the state
    System.out.println("Current State: " + assessment.getState().toString());
    assessment.changeState();
    System.out.println("New State: " + assessment.getState().toString());

    // Redirect back to the assessments page to refresh the model
    return "redirect:/view-assessments";
}








    // // Constructor with sample data for demonstration purposes
    // public AssessmentController() {
    //     Course course1 = new Course(3L, "Maths", "Learn advanced mathematics.", "/images/maths.jpg", 3, 1, 0.0);
    //     Course course2 = new Course(2L, "Science", "Explore the world of science.", "/images/science.jpg", 4, 2, 0.0);

    //     // Assessments for course1 with initial states
    //     assessments.add(new Assessment(1L, "Quiz 1", 10.0, 100.0, LocalDateTime.now().plusDays(7), course1, new Draft()));
    //     assessments.add(new Assessment(2L, "Midterm Exam", 30.0, 200.0, LocalDateTime.now().plusDays(14), course1, new Active()));
    //     assessments.add(new Assessment(3L, "Final Exam", 60.0, 300.0, LocalDateTime.now().plusDays(30), course1, new Draft()));

    //     // Assessments for course2 with initial states
    //     assessments.add(new Assessment(4L, "Lab Report", 20.0, 100.0, LocalDateTime.now().plusDays(10), course2, new Active()));
    //     assessments.add(new Assessment(5L, "Science Project", 50.0, 200.0, LocalDateTime.now().plusDays(20), course2, new Draft()));
    // }

    // // Sample courses for testing (mocked data)
    // private List<Course> getSampleCourses() {
    //     List<Course> courses = new ArrayList<>();
    //     courses.add(new Course(3L, "Maths", "Learn advanced mathematics.", "/images/maths.jpg", 3, 1, 0.0));
    //     courses.add(new Course(2L, "Science", "Explore the world of science.", "/images/science.jpg", 4, 2, 0.0));
    //     return courses;
    // }
}