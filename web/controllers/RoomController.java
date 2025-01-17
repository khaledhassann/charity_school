// package com.rungroup.web.controllers;

// import com.rungroup.web.models.Room;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;

// import java.util.ArrayList;
// import java.util.List;

// @Controller
// public class RoomController {

//     private List<Room> createdRooms = new ArrayList<>();

//     @GetMapping("/create-room")
//     public String showCreateRoomPage(Model model) {
//         model.addAttribute("message", null);
//         return "create-room";
//     }

//     @PostMapping("/create-room")
// public String createRoom(@RequestParam("name") String name,
//                          @RequestParam("capacity") int capacity,
//                          @RequestParam(value = "amendment", required = false) String amendment,
//                          Model model) {
//     List<String> amendments = new ArrayList<>();
//     if (amendment != null && !amendment.isEmpty()) {
//         amendments.add(amendment);
//     }

//     Room newRoom = new Room(name, capacity, amendments);
//     createdRooms.add(newRoom);

//     // Debugging room creation
//     System.out.println("New Room Created: " + newRoom);

//     model.addAttribute("message", "Room created successfully!");
//     return "create-room";
// }


// @GetMapping("/upgrade-room")
// public String showUpgradeRoomPage(Model model) {
//     System.out.println("Created Rooms Debug:");
//     for (Room room : createdRooms) {
//         System.out.println("Room ID: " + room.getId());
//         System.out.println("Room Name: " + room.getName());
//         System.out.println("Room Capacity: " + room.getCapacity());
//         System.out.println("Room Amendments: " + room.getAmendments());
//     }

//     if (createdRooms.isEmpty()) {
//         model.addAttribute("rooms", new ArrayList<>());
//     } else {
//         model.addAttribute("rooms", createdRooms);
//     }

//     // Add the amendments list
//     model.addAttribute("amendments", List.of("Projector", "Smartboard", "Chairs"));

//     model.addAttribute("selectedRoom", null);
//     model.addAttribute("selectedAmendment", null);
//     return "upgrade-room";
// }




// @PostMapping("/upgrade-room")
// public String upgradeRoom(@RequestParam("room") String roomName,
//                           @RequestParam("amendment") String amendment,
//                           @RequestParam(value = "chairsNumber", required = false) Integer chairsNumber,
//                           Model model) {
//     Room selectedRoom = null;
//     for (Room room : createdRooms) {
//         if (room.getName().equals(roomName)) {
//             selectedRoom = room;
//             if (!room.getAmendments().contains(amendment)) {
//                 room.addAmendment(amendment);
//             }
//             if ("Chairs".equals(amendment) && chairsNumber != null) {
//                 room.setCapacity(chairsNumber);
//             }
//         }
//     }

//     model.addAttribute("rooms", createdRooms);
//     model.addAttribute("selectedRoom", selectedRoom);
//     model.addAttribute("selectedAmendment", amendment);
//     model.addAttribute("message", "Room upgraded successfully!");
//     model.addAttribute("amendments", List.of("Projector", "Smartboard", "Chairs")); // Ensure amendments list is passed
//     return "upgrade-room";
// }

// }
package com.rungroup.web.controllers;

import com.rungroup.web.models.Room;
import com.rungroup.web.repositories.Implementations.RoomRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RoomController {

    private List<Room> createdRooms = new ArrayList<>();
    private RoomRepository rs;

    public RoomController(){
        this.rs = new RoomRepository();
        this.createdRooms = rs.findAll();
    }

    @GetMapping("/create-room")
    public String showCreateRoomPage(Model model) {
        model.addAttribute("message", null);
        return "create-room";
    }

    @PostMapping("/create-room")
    public String createRoom(@RequestParam("name") String name,
                             @RequestParam("capacity") int capacity,
                             @RequestParam(value = "amendment", required = false) String amendment,
                             Model model) {
        List<String> amendments = new ArrayList<>();
        if (amendment != null && !amendment.isEmpty()) {
            amendments.add(amendment);
        }

        Room newRoom = new Room();
        newRoom.setName(name); newRoom.setCapacity(capacity); newRoom.setAmendments(amendments);
        createdRooms.add(newRoom);
        this.rs.insert(newRoom);
        // Debugging room creation
        System.out.println("New Room Created: " + newRoom);

        model.addAttribute("message", "Room created successfully!");
        return "create-room";
    }

    @GetMapping("/upgrade-room")
public String showUpgradeRoomPage(@RequestParam(value = "room", required = false) String selectedRoomName, Model model) {
    System.out.println("Created Rooms Debug:");
    for (Room room : createdRooms) {
        System.out.println("Room ID: " + room.getId());
        System.out.println("Room Name: " + room.getName());
        System.out.println("Room Capacity: " + room.getCapacity());
        System.out.println("Room Amendments: " + room.getAmendments());
    }

    Room selectedRoom = null;
    if (selectedRoomName != null) {
        for (Room room : createdRooms) {
            if (room.getName().equals(selectedRoomName)) {
                selectedRoom = room;
                break;
            }
        }
    }

    if (selectedRoom != null) {
        System.out.println("Selected Room for Upgrade:");
        System.out.println("Room Name: " + selectedRoom.getName());
        System.out.println("Room Amendments: " + selectedRoom.getAmendments());
    }

    model.addAttribute("rooms", createdRooms.isEmpty() ? new ArrayList<>() : createdRooms);
    model.addAttribute("amendments", List.of("Projector", "Smartboard", "Chairs"));
    model.addAttribute("selectedRoom", selectedRoom);
    return "upgrade-room";
}



    @PostMapping("/upgrade-room")
public String upgradeRoom(@RequestParam("room") String roomName,
                          @RequestParam("amendment") String amendment,
                          @RequestParam(value = "chairsNumber", required = false) Integer chairsNumber,
                          Model model) {
    System.out.println("Upgrade Room POST Request:");
    System.out.println("Selected Room: " + roomName);
    System.out.println("Selected Amendment: " + amendment);
    if (chairsNumber != null) {
        System.out.println("Number of Chairs: " + chairsNumber);
    }

    Room selectedRoom = null;
    boolean isAmendmentAdded = false;

    for (Room room : createdRooms) {
        if (room.getName().equals(roomName)) {
            selectedRoom = room;
            System.out.println("Room Found: " + room.getName());
            if (!room.getAmendments().contains(amendment)) {
                room.addAmendment(amendment);
                isAmendmentAdded = true; // Mark as successful
                
            }
            if ("Chairs".equals(amendment) && chairsNumber != null) {
                room.setCapacity(chairsNumber);
            }
            // Update the database
            this.rs.update(room);
            break; // Room found, exit the loop
        }
    }

    // Debug updated room
    if (selectedRoom != null) {
        System.out.println("Updated Room: " + selectedRoom);
    }

    model.addAttribute("rooms", createdRooms);
    model.addAttribute("selectedRoom", selectedRoom);
    model.addAttribute("selectedAmendment", amendment);
    model.addAttribute("amendments", List.of("Projector", "Smartboard", "Chairs"));

    // Add success message only if a new amendment was added
    if (isAmendmentAdded) {
        model.addAttribute("message", "Room upgraded successfully!");
    } else {
        model.addAttribute("message", null);
    }

    return "upgrade-room";
}

}
