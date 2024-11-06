public class Bench extends RoomAddOn {
    public Bench(Room room) {
        super(room);
    }

    @Override
    public int getCapacity() {
        return config.BENCH_CAPACITY + this.room.getCapacity();
    }

    @Override
    public float getTotalValue() {
        return config.BENCH_VALUE + this.room.getTotalValue();
    }

    @Override
    public float getDailyRunningCost() {
        return config.BENCH_DAILY_RUNNING_COST + this.room.getDailyRunningCost();
    }
}
