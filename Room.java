public class Room {
    private int stdCapacity;
    private int roomNumber;

    // SETTERS AND GETTERS
    public int getStdCapacity() {
        return stdCapacity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setStdCapacity(int stdCapacity) {
        this.stdCapacity = stdCapacity;
    }

    public boolean hasProjector() {
        return true;
    }

    public boolean hasSmartBoard() {
        return true;
    }

    public boolean hasComputer() {
        return true;
    }
}
