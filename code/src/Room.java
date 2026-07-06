public class Room {

    int roomNo;
    String type;
    int rentPerDay;
    boolean available;

    public Room(int roomNo, String type) {
        this.roomNo = roomNo;
        this.type = type;
        this.available = true;

        if (type.equalsIgnoreCase("Standard")) {
            rentPerDay = 1000;
        } else if (type.equalsIgnoreCase("Deluxe")) {
            rentPerDay = 2000;
        } else if (type.equalsIgnoreCase("Suite")) {
            rentPerDay = 3000;
        }
    }
}