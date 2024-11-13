package Room;
public class BasicRoom implements Room {
    private int capacity = 30;
    
    
    @Override
    public int getCapacity() {
        return capacity; // how many students can be in the room
    }

    @Override
    public float getTotalValue() {
        return 10000; // valuation of the room itself
    }

    @Override
    public float getDailyRunningCost() {
        return 100; // such as cleaning the room, electricity for lights, maintenance, etc.
    }

    @Override
    public boolean hasProjector() {
        return false;
    }

    @Override
    public boolean hasSmartBoard() {
        return false;
    }

}
