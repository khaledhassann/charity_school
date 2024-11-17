package Room;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        RoomController controller = new RoomController();

        Room room = controller.createRoom();

        controller.readRoom(room);

        room = controller.updateRoom(room);

        controller.readRoom(room);

        controller.deleteRoom(room);

    }
}
