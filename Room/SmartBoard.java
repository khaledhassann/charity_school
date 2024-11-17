package Room;

public class SmartBoard extends RoomAddOn {
    public  SmartBoard(Room room) {
        super(room);
    }
    @Override
    public float getTotalValue() {
        return config.SMARTBOARD_VALUE + this.room.getTotalValue();
    }

    @Override
    public float getDailyRunningCost() {
        return config.SMARTBOARD_DAILY_RUNNING_COST + this.room.getDailyRunningCost();
    }

    @Override
    public boolean hasSmartBoard() {
        // TODO Auto-generated method stub
        return true;
    }
}
