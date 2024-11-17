import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schedule {
    private Map<SubjectModel, Integer> subjectTimeSlots = new HashMap<>();
    private Map<SubjectModel, String> subjectNames = new HashMap<>();

    public Schedule(List<SubjectModel> subjects) {
        for (SubjectModel subject : subjects) {
            subjectTimeSlots.put(subject, subject.getTimeslot());
            subjectNames.put(subject, subject.getSubjectName());
        }
    }

    public Map<String, Integer> createSchedule(List<SubjectModel> selectedSubjects) {
        Map<String, Integer> scheduleMap = new HashMap<>();

        System.out.println("Creating schedule:");
        for (SubjectModel subject : selectedSubjects) {
            Integer timeSlot = subject.getTimeslot();
            String name = subject.getSubjectName();
            if (timeSlot != null) {
                scheduleMap.put(name, timeSlot);
                System.out.println("Subject: " + name + " - Time Slot: " + timeSlot);
            }
        }

        return scheduleMap;
    }

    // public Map<String, Integer> scheduleSubjects(List<Subject> subjects) {
    // Map<String, Integer> scheduleMap = new HashMap<>();

    // System.out.println("Creating schedule:");
    // for (Subject subject : subjects) {
    // Integer timeSlot = subjectTimeSlots.get(subject);
    // String name = subjectNames.get(subject);
    // if (timeSlot != null) {
    // scheduleMap.put(name, timeSlot);
    // System.out.println("Subject: " + name + " - Time Slot: " + timeSlot);
    // }
    // }

    // return scheduleMap;
    // }

}