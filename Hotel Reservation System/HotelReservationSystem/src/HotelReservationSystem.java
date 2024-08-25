import java.util.ArrayList;

public class HotelReservationSystem {

    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    public HotelReservationSystem() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {                                                         //rooms in the hotel
        rooms.add(new Room(101, "Single", 100.0));
        rooms.add(new Room(102, "Single", 100.0));
        rooms.add(new Room(201, "Double", 150.0));
        rooms.add(new Room(202, "Double", 150.0));
        rooms.add(new Room(301, "Suite", 300.0));
        rooms.add(new Room(302, "Suite", 300.0));
        rooms.add(new Room(303, "Suite", 300.0));
    }

    public ArrayList<Room> searchAvailableRooms(String category) {              //check in each room  where Catagory ==  Reservation catagory   and insert it inside the the new list and return availableRooms
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && !room.isBooked()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Reservation makeReservation(Room room, String guestName, int nights) {  // check if the room got book or not if not the Customers will get the room and save his data 
        if (room.isBooked()) {
            System.out.println("Room is already booked.");
            return null;
        }
        Reservation reservation = new Reservation(room, guestName, nights);
        reservations.add(reservation);
        room.setBooked(true);
        return reservation;
    }

    public void viewReservationDetails(Reservation reservation) {         // check if the room got reservation or not if reservation the get the Customers data 
        if (reservation != null) {
            System.out.println(reservation);
        } else {
            System.out.println("No reservation found.");
        }
    }

    public ArrayList<Room> getRooms() {     //return rooms data
        return rooms;
    }

    public ArrayList<Reservation> getReservations() { //return reservations data
        return reservations;
    }
}
