import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schedule {
    private Map<Subject, Integer> subjectTimeSlots = new HashMap<>();
    private Map<Subject, String> subjectNames = new HashMap<>();

    public Schedule(List<Subject> subjects) {
        for (Subject subject : subjects) {
            subjectTimeSlots.put(subject, subject.getTimeSlot());
            subjectNames.put(subject, subject.getName());
        }
    }

    public Map<String, Integer> createSchedule(List<Subject> selectedSubjects) {
        Map<String, Integer> scheduleMap = new HashMap<>();

        System.out.println("Creating schedule:");
        for (Subject subject : selectedSubjects) {
            Integer timeSlot = subject.getTimeSlot();
            String name = subject.getName();
            if (timeSlot != null) {
                scheduleMap.put(name, timeSlot);
                System.out.println("Subject: " + name + " - Time Slot: " + timeSlot);
            }
        }

        return scheduleMap;
    }

    // public Map<String, Integer> scheduleSubjects(List<Subject> subjects) {
    //     Map<String, Integer> scheduleMap = new HashMap<>();

    //     System.out.println("Creating schedule:");
    //     for (Subject subject : subjects) {
    //         Integer timeSlot = subjectTimeSlots.get(subject);
    //         String name = subjectNames.get(subject);
    //         if (timeSlot != null) {
    //             scheduleMap.put(name, timeSlot);
    //             System.out.println("Subject: " + name + " - Time Slot: " + timeSlot);
    //         }
    //     }

    //     return scheduleMap;
    // }
    
}
