public class TimeSlot {
    private String date;
    private String time;
    private Subject subject;
    private boolean isBooked;  
    public TimeSlot(String date, String time, Subject subject) {
        this.date = date;
        this.time = time;
        this.subject = subject;
        this.isBooked = false;
    }

    public boolean isAvailable() {
        return !isBooked;
    }

    public void bookSlot() {
        this.isBooked = true;
    }

    public void releaseSlot() {
        this.isBooked = false;
    }
    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Subject getSubject() {
        return subject;
    }

}