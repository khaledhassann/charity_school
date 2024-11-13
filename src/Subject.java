public class Subject {
    private String name;
    private int TimeSlot;

    public Subject(String name, int TimeSlot) {
        this.name = name;
        this.TimeSlot = TimeSlot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeSlot() {
        return TimeSlot;
    }

    public void setTimeSlot(int TimeSlot) {
        this.TimeSlot = TimeSlot;
    }
}