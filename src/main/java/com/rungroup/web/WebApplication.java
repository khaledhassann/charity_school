package com.rungroup.web;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rungroup.web.models.Course;
import com.rungroup.web.models.TeachDetails;
import com.rungroup.web.models.Verb;
import com.rungroup.web.models.Volunteer;
import com.rungroup.web.repositories.Implementations.CourseRepository;
import com.rungroup.web.repositories.Implementations.TeachDetailsRepository;
import com.rungroup.web.repositories.Implementations.VerbRepository;
import com.rungroup.web.repositories.Implementations.VolunteerRepository;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);

		// Create a Verb instance
		VerbRepository verbRepository = new VerbRepository();
		Verb teachVerb = new Verb("Teaching");
		verbRepository.insert(teachVerb);

		Volunteer volunteer = new Volunteer("Khaled", "khaled@email", "pass123");
		VolunteerRepository vr = new VolunteerRepository();
		vr.insert(volunteer);
		Course course = new Course(null, "Math", "This is a maths course", "", 3, 1, 0.5, null, null);
		CourseRepository cr = new CourseRepository();
		cr.insert(course);

		// Create a TeachDetails instance
		TeachDetails teachDetails = new TeachDetails(volunteer.getId(), course.getId(), teachVerb.getId(), 12L);

		TeachDetailsRepository tdr = new TeachDetailsRepository();
		tdr.insert(teachDetails);

		// Test getInteractionDetails method
		System.out.println(teachDetails.getInteractionDetails());

		// Test getUser method
		System.out.println(teachDetails.getUser());

		// Test getTargetAdapter method
		System.out.println(teachDetails.getTargetAdapter().getTargetData());

		// Test getVerb method
		System.out.println(teachDetails.getVerb());

	}

}
