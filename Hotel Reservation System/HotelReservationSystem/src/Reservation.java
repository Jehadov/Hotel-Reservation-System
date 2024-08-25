public class Reservation {          
    private Room room;
    private String guestName;
    private int nights;
    private double totalCost;

    public Reservation(Room room, String guestName, int nights) {         // constractor
        this.room = room;
        this.guestName = guestName;
        this.nights = nights;
        this.totalCost = room.getPricePerNight() * nights;
    }

    public Room getRoom() {         // room class
        return room;
    }

    public String getGuestName() {      // guestName
        return guestName;
    }

    public int getNights() {            // total nights
        return nights;
    }

    public double getTotalCost() {       // total cost*Nights
        return totalCost;
    }

    @Override
    public String toString() {              //Reservation details
        return "Reservation{" +
                "room=" + room +
                ", guestName='" + guestName + '\'' +
                ", nights=" + nights +
                ", totalCost=" + totalCost +
                '}';
    }
}
