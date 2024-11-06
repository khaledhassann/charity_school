## Objective

Implement the Class Room part of the class diagram using decorative desgin pattern, Where a class room can be "Upgraded" 
with new :
- seats
- benches
- smart boards
- projectors

and these upgrades will reflect on the rooms' :
- Capacity
- Value
- Daily Running Cost

A config file was used to read constant values (for example: the value of a projector), A database would be later used.



## Folder Structure

The workspace `src` folder contains the main files, where:

- `App.java`: contains the main function and the unit testing.
- `Room.java`: the interface for any room.
- `BasicRoom.java`: the standard attributes of any room.
- `RoomAddOn.java`: the abstract class for any upgrade for a room.
- `Bench.java`: a class for upgrading a room with a bench.
- `Chair.java`: a class for upgrading a room with a chair.
- `Projector.java`: a class for upgrading a room with a projector.
- `SmartBoard.java`: a class for upgrading a room with a smart board.
- `config.java`: a class for reading constant values from the config file.


