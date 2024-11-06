public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        Room room = new BasicRoom();
        room = new Chair(room);
        room = new Bench(room);
        room = new Projector(room);
        room = new SmartBoard(room);
        System.out.println(room.getCapacity());
        System.out.println(room.getTotalValue());
        System.out.println(room.getDailyRunningCost());
        System.out.println(room.hasProjector());
        System.out.println(room.hasSmartBoard());
        
    }
}
