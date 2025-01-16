package com.rungroup.controllers;

import com.rungroup.models.Active;
import com.rungroup.models.Assessment;
import com.rungroup.models.Course;
import com.rungroup.models.Draft;

import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AssessmentController {

    // List to store all assessments
    private List<Assessment> assessments = new ArrayList<>();

    // Method to retrieve all assessments
    public List<Assessment> getAssessments() {
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

    public List<Assessment> getActiveAssessmentsForCourse(Course course) {
        return assessments.stream()
                .filter(assessment -> assessment.getCourse().getId().equals(course.getId()))
                .filter(assessment -> assessment.getState() instanceof Active) // Filter only active state
                .collect(Collectors.toList());
    }
    
    
    

    // Method to display the details of all assessments (for testing)
    public String getDetails() {
        StringBuilder details = new StringBuilder("Assessment Details:\n");
        for (Assessment assessment : assessments) {
            details.append(assessment.toString()).append("\n");
        }
        return details.toString();
    }

    // Constructor with sample data for demonstration purposes
   public AssessmentController() {
    Course course1 = new Course(3L, "Maths", "Learn advanced mathematics.", "/images/maths.jpg", 3, 1, 0.0);
    Course course2 = new Course(2L, "Science", "Explore the world of science.", "/images/science.jpg", 4, 2, 0.0);

    // Assessments for course1 with initial states
    assessments.add(new Assessment(1L, "Quiz 1", 10.0, 100.0, LocalDateTime.now().plusDays(7), course1, new Draft()));
    assessments.add(new Assessment(2L, "Midterm Exam", 30.0, 200.0, LocalDateTime.now().plusDays(14), course1, new Active()));
    assessments.add(new Assessment(3L, "Final Exam", 60.0, 300.0, LocalDateTime.now().plusDays(30), course1, new Draft()));

    // Assessments for course2 with initial states
    assessments.add(new Assessment(4L, "Lab Report", 20.0, 100.0, LocalDateTime.now().plusDays(10), course2, new Active()));
    assessments.add(new Assessment(5L, "Science Project", 50.0, 200.0, LocalDateTime.now().plusDays(20), course2, new Draft()));
}

}
