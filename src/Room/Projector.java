package Room;
public class Projector extends RoomAddOn {
    public  Projector(Room room) {
        super(room);
    }
    @Override
    public float getTotalValue() {
        return config.PROJECTOR_VALUE + this.room.getTotalValue();
    }

    @Override
    public float getDailyRunningCost() {
        return config.PROJECTOR_DAILY_RUNNING_COST + this.room.getDailyRunningCost();
    }

    @Override
    public boolean hasProjector() {
        // TODO Auto-generated method stub
        return true;
    }

}
