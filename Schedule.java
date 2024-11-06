import java.util.ArrayList;
import java.util.List;


public class Schedule {
    private List<TimeSlot> availableSlots = new ArrayList<>();
    private List<TimeSlot> assignedSlots = new ArrayList<>();

    public void addAvailableSlot(TimeSlot slot) {
        availableSlots.add(slot);
    }

    public void assignSlot(TimeSlot slot) {
        if (slot.isAvailable()) {
            slot.bookSlot(); 
            availableSlots.remove(slot);
            assignedSlots.add(slot);
            System.out.println("Slot assigned: " + slot.getDate() + " " + slot.getTime());
        } else {
            System.out.println("Error: Slot is already booked or unavailable.");
        }
    }

    public void releaseSlot(TimeSlot slot) {
        if (assignedSlots.contains(slot)) {
            slot.releaseSlot();  
            assignedSlots.remove(slot);
            availableSlots.add(slot);
            System.out.println("Slot released: " + slot.getDate() + " " + slot.getTime());
        } else {
            System.out.println("Error: Slot not found in assigned slots.");
        }
    }

    public List<TimeSlot> getAvailableSlots() {
        return availableSlots;
    }

    public List<TimeSlot> getAssignedSlots() {
        return assignedSlots;
    }

    public void setAvailableSlots(List<TimeSlot> availableSlots) {
        this.availableSlots = availableSlots;
    }
    
    public void setAssignedSlots(List<TimeSlot> assignedSlots) {
        this.assignedSlots = assignedSlots;
    }
}