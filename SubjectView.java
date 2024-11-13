
// SubjectView.java - View Component
import java.util.List;

public class SubjectView {
    public void printSubjectDetails(String subjectName, String subjectCode, int subjectCredit, List<Student> students) {
        System.out.println("Subject: " + subjectName);
        System.out.println("Code: " + subjectCode);
        System.out.println("Credit: " + subjectCredit);
        System.out.println("Students enrolled: " + students);
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
