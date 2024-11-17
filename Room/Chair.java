package Room;
public class Chair extends RoomAddOn {

    public Chair(Room room) {
        super(room);
    }

    @Override
    public int getCapacity() {
        return config.CHAIR_CAPACITY + this.room.getCapacity();
    }

    @Override
    public float getTotalValue() {
        return config.CHAIR_VALUE + this.room.getTotalValue();
    }

    @Override
    public float getDailyRunningCost() {
        return config.CHAIR_DAILY_RUNNING_COST + this.room.getDailyRunningCost();
    }


}
