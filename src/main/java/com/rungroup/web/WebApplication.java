package com.rungroup.web;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.yaml.snakeyaml.events.Event;

import com.rungroup.web.models.Beneficiary;
import com.rungroup.web.models.Course;
import com.rungroup.web.models.DeviceTargetting;
import com.rungroup.web.models.Event;
import com.rungroup.web.models.GeoTargetting;
import com.rungroup.web.models.ParticipateDetails;
import com.rungroup.web.models.RegisterDetails;
import com.rungroup.web.models.TeachDetails;
import com.rungroup.web.models.TimeSensitive;
import com.rungroup.web.models.Twitter;
import com.rungroup.web.models.Verb;
import com.rungroup.web.models.VerbDetails;
import com.rungroup.web.models.Volunteer;
import com.rungroup.web.repositories.Implementations.BeneficiaryRepository;
import com.rungroup.web.repositories.Implementations.CourseRepository;
import com.rungroup.web.repositories.Implementations.EventRepository;
import com.rungroup.web.repositories.Implementations.ParticipateDetailsRepository;
import com.rungroup.web.repositories.Implementations.RegisterDetailsRepository;
import com.rungroup.web.repositories.Implementations.TeachDetailsRepository;
import com.rungroup.web.repositories.Implementations.TimeSensitiveRepository;
import com.rungroup.web.repositories.Implementations.TwitterRepository;
import com.rungroup.web.repositories.Implementations.VerbRepository;
import com.rungroup.web.repositories.Implementations.VolunteerRepository;
import com.rungroup.web.utils.VerbDetailsFactory;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);

		// Creating the verbs in the database (TEACH, PARTICIPATE, REGISTER)
		VerbRepository verbRepository = new VerbRepository();
		Verb teachVerb = new Verb("Teaching");
		verbRepository.insert(teachVerb);
		Verb participateVerb = new Verb("Participating");
		verbRepository.insert(participateVerb);
		Verb registerVerb = new Verb("Registering");
		verbRepository.insert(registerVerb);

		// Creating the verb doers (2 different volunteers, 1 beneficiary)
		VolunteerRepository vr = new VolunteerRepository();
		Volunteer volunteer1 = new Volunteer("Khaled", "khaled@email", "pass123");
		vr.insert(volunteer1);
		Volunteer volunteer2 = new Volunteer("Adham", "ahmed@email", "pass123");
		vr.insert(volunteer2);
		BeneficiaryRepository br = new BeneficiaryRepository();
		Beneficiary beneficiary1 = new Beneficiary("Omar", "beneficiary1@email",
				"pass123");
		br.insert(beneficiary1);

		// Creating the targets (1 course and 1 event)
		CourseRepository cr = new CourseRepository();
		Course course1 = new Course("Math", "This is a maths course", "", 3, 1, 0.5);
		cr.insert(course1);
		EventRepository er = new EventRepository();
		Event event1 = new Event("DJ your own concert", "We are going to organize a DJ events for our beneficiaries",
				"",
				LocalDateTime.now(), "Sigma66");
		er.insert(event1);

		// Create a TeachDetails instance
		TeachDetails teachDetails = (TeachDetails) VerbDetailsFactory.createVerbDetails(teachVerb.getId(),
				volunteer1.getId(),
				"volunteer", course1.getId(),
				"course", new HashMap<String, Object>() {
					{
						put("hours_taught", 12L);
					}
				});

		// Create a TeachDetails instance
		ParticipateDetails participateDetails = (ParticipateDetails) VerbDetailsFactory.createVerbDetails(
				participateVerb.getId(),
				volunteer2.getId(),
				"volunteer", event1.getId(),
				"event", new HashMap<String, Object>() {
					{
						put("role", "Usher");
					}
				});

		// Create a TeachDetails instance
		RegisterDetails registerDetails = (RegisterDetails) VerbDetailsFactory.createVerbDetails(registerVerb.getId(),
				beneficiary1.getId(),
				"beneficiary", course1.getId(),
				"course", new HashMap<String, Object>() {
					{
						put("status", "pending");
					}
				});

		TeachDetailsRepository tdr = new TeachDetailsRepository();
		tdr.insert(teachDetails);
		ParticipateDetailsRepository pdr = new ParticipateDetailsRepository();
		pdr.insert(participateDetails);
		RegisterDetailsRepository rdr = new RegisterDetailsRepository();
		rdr.insert(registerDetails);

		// Test getInteractionDetails method
		System.out.println(teachDetails.getInteractionDetails());
		// Test getInteractionDetails method
		System.out.println(participateDetails.getInteractionDetails());
		// Test getInteractionDetails method
		System.out.println(registerDetails.getInteractionDetails());

		Twitter twitter = new Twitter("Twitter campaign", "Twitter", "Upcoming",
				LocalDateTime.now(), event1.getId());
		TwitterRepository twitterRepository = new TwitterRepository();
		twitterRepository.insert(twitter);
		System.out.println(twitter.getDecorated_ad());
		System.out.println(twitter.getId());
		TimeSensitive timeSensitiveTwitterAd = new TimeSensitive(twitter);
		twitterRepository.update(twitter);
		System.out.println(twitter.getDecorated_ad());
		GeoTargetting geoTargetting = new GeoTargetting(twitter);
		twitterRepository.update(twitter);
		System.out.println(twitter.getDecorated_ad());
		DeviceTargetting deviceTargetting = new DeviceTargetting(twitter);
		twitterRepository.update(twitter);
		System.out.println(twitter.getDecorated_ad());
		// // TimeSensitiveRepository tsr = new TimeSensitiveRepository();
		// // tsr.insert(timeSensitiveTwitterAd);

		// System.out.println(twitter.showAdString());
		// System.out.println(timeSensitiveTwitterAd.showAdString());

		// // Test getUser method
		// System.out.println(teachDetails.getUser());

		// // Test getTargetAdapter method
		// System.out.println(teachDetails.getTargetAdapter().getTargetData());

		// // Test getVerb method
		// System.out.println(teachDetails.getVerb());

	}

}
