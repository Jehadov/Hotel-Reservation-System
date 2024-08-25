public class Room {
    private int roomNumber;
    private String category;
    private double pricePerNight;
    private boolean isBooked;

    public Room(int roomNumber, String category, double pricePerNight) {            // constructor
        this.roomNumber = roomNumber;
        this.category = category;
        this.pricePerNight = pricePerNight;
        this.isBooked = false;
    }

    public int getRoomNumber() {        //return room number
        return roomNumber;
    }

    public String getCategory() {       //return room type
        return category;
    }

    public double getPricePerNight() {      //return room price
        return pricePerNight;
    }

    public boolean isBooked() {         //return room Booked or not for "if" 
        return isBooked;
    }

    public void setBooked(boolean booked) {     //return room true to a room witch get booked
        isBooked = booked;
    }

    @Override
    public String toString() {      //return room detailes
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", category='" + category + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", isBooked=" + isBooked +
                '}';
    }
}
