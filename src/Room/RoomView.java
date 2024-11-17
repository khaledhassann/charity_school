package Room;

import java.util.ArrayList;
import java.util.Scanner;

public class RoomView {

    // List to store all rooms
    private ArrayList<Room> rooms = new ArrayList<>();
    private RoomController controller = new RoomController(); // RoomController instance
    private Scanner scanner = new Scanner(System.in); // Scanner for user input

    public void showMenu() {
        int choice;
        do {
            // Pre initialize 5 tooms
            initializeRooms();

            // Display menu
            System.out.println("\n==== Room Management System ====");
            System.out.println("1. List all rooms");
            System.out.println("2. Create a new room");
            System.out.println("3. Upgrade a room");
            System.out.println("4. View room details");
            System.out.println("5. Delete a room");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listAllRooms();
                    break;
                case 2:
                    createRoom();
                    break;
                case 3:
                    upgradeRoom();
                    break;
                case 4:
                    viewRoomDetails();
                    break;
                case 5:
                    deleteRoom();
                    break;
                case 6:
                    // exit
                
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }


    private void listAllRooms() {
        System.out.println("\n==== List of Rooms ====");
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            for (int i = 0; i < rooms.size(); i++) {
                System.out.println("Room #" + (i + 1) + ":");
                controller.readRoom(rooms.get(i)); 
                System.out.println("--------------------------");
            }
        }
    }


    private void createRoom() {
        Room newRoom = controller.createRoom();
        rooms.add(newRoom); // Add the new room to the list
        System.out.println("Room created and added to the list.");
    }

    private void upgradeRoom() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available to upgrade.");
            return;
        }
        System.out.println("\n==== Upgrade a Room ====");
        listAllRooms();
        System.out.print("Enter the room number to upgrade: ");
        int roomIndex = scanner.nextInt() - 1;

        if (roomIndex >= 0 && roomIndex < rooms.size()) {
            Room upgradedRoom = controller.updateRoom(rooms.get(roomIndex));
            rooms.set(roomIndex, upgradedRoom);
            System.out.println("Room upgraded successfully.");
        } else {
            System.out.println("Invalid room number.");
        }
    }

    private void viewRoomDetails() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available to view.");
            return;
        }
        System.out.println("\n==== View Room Details ====");
        listAllRooms();
        System.out.print("Enter the room number to view details: ");
        int roomIndex = scanner.nextInt() - 1;

        if (roomIndex >= 0 && roomIndex < rooms.size()) {
            controller.readRoom(rooms.get(roomIndex));
        } else {
            System.out.println("Invalid room number.");
        }
    }


    private void deleteRoom() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available to delete.");
            return;
        }
        System.out.println("\n==== Delete a Room ====");
        listAllRooms();
        System.out.print("Enter the room number to delete: ");
        int roomIndex = scanner.nextInt() - 1;

        if (roomIndex >= 0 && roomIndex < rooms.size()) {
            controller.deleteRoom(rooms.get(roomIndex));
            rooms.remove(roomIndex); 
            System.out.println("Room deleted successfully.");
        } else {
            System.out.println("Invalid room number.");
        }
    }


    public void initializeRooms() {
        for (int i = 0; i < 5; i++) {
            Room room = controller.createRoom();
            room = new Chair(room);
            room = new Bench(room);
            rooms.add(room);
        }
        // System.out.println("5 rooms pre-created and added to the list.");
    }
}

