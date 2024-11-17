package School;


// SubjectView.java - View Component
import java.util.List;

public class SubjectView {
    public void printSubjectDetails(String subjectCode, String subjectName, int subjectCredits,
            String gradingBehavior, String examType, int timeslot) {
        System.out.println("This is " + subjectCode + ":" + subjectName + " with credit hours " + subjectCredits
                + "\nGrading: "
                + gradingBehavior + "\nFinal Exam: " + examType + "\nTime Slot: " + timeslot);
    }

    public void printAssessments(List<Assessment> assessments) {
        System.out.println("Assessments: ");
        for (Assessment assessment : assessments) {
            System.out.println(assessment);
        }
    }

    public void printTeacher(Donor teacher) {
        System.out.println("Teacher: " + teacher);
    }

    public void printTimeslot(int timeslot) {
        System.out.println("Timeslot: " + timeslot);
    }
}
