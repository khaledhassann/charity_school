package Room;

public class RoomController {

    public Room createRoom(boolean doPrint) {
        Room room = new BasicRoom();
        if (doPrint)
            System.out.println("New room created with room number: " + room.getRoomNumber());
        return room;
    }

    // Read: Displays details of the room
    public void readRoom(Room room) {
        System.out.println("Room Details:");
        System.out.println("Room Number: " + room.getRoomNumber());
        System.out.println("Capacity: " + room.getCapacity());
        System.out.println("Total Value: " + room.getTotalValue());
        System.out.println("Daily Running Cost: " + room.getDailyRunningCost());
        System.out.println("Has Projector: " + room.hasProjector());
        System.out.println("Has SmartBoard: " + room.hasSmartBoard());
    }

    public Room updateRoom(Room room) {
        for (int i = 0; i < 5; i++) {
            room = new Chair(room); // Add 5 chairs
        }
        room = new Bench(room); // Add 1 bench
        room = new SmartBoard(room); // Add a SmartBoard
        room = new Projector(room); // Add a Projector

        System.out.println("Room upgraded successfully.");
        return room;
    }

    public void deleteRoom(Room room) {

        System.out.println("Room deleted (placeholder).");
    }
}
