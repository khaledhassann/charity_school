package Room;
public abstract class RoomAddOn implements Room {
    protected Room room;

    public int getRoomNumber() {
        return this.room.getRoomNumber();
    }

    public RoomAddOn(Room room) {   
        this.room = room;   
    }

    public int getCapacity(){
        return this.room.getCapacity();
    }

    // these 2 functions have to be overrided by subclasses, since
    // they are used by all add-ons
    abstract public float getTotalValue();

    abstract public float getDailyRunningCost();

    public boolean hasProjector(){
        return this.room.hasProjector();
    }
    
    public boolean hasSmartBoard(){
        return this.room.hasSmartBoard();
    }
}
