import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        HotelReservationSystem system = new HotelReservationSystem();           //in Main i create a menu it will not get out untill we chose option 4 and it will Exit the loop 
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Hotel Reservation System!");

        while (true) {
            System.out.println("\n1. Search Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter room category (Single/Double/Suite): ");
                    String category = scanner.next();
                    ArrayList<Room> availableRooms = system.searchAvailableRooms(category);
                    if (availableRooms.isEmpty()) {
                        System.out.println("No available rooms in this category.");
                    } else {
                        System.out.println("Available rooms:");
                        for (Room room : availableRooms) {
                            System.out.println(room);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    Room room = null;
                    for (Room r : system.getRooms()) {
                        if (r.getRoomNumber() == roomNumber && !r.isBooked()) {
                            room = r;
                            break;
                        }
                    }
                    if (room == null) {
                        System.out.println("Room is not available or does not exist.");
                    } else {
                        System.out.print("Enter guest name: ");
                        String guestName = scanner.next();
                        System.out.print("Enter number of nights: ");
                        int nights = scanner.nextInt();
                        Reservation reservation = system.makeReservation(room, guestName, nights);
                        system.viewReservationDetails(reservation);
                    }
                    break;

                case 3:
                    System.out.print("Enter room number to view reservation: ");
                    roomNumber = scanner.nextInt();
                    for (Reservation res : system.getReservations()) {
                        if (res.getRoom().getRoomNumber() == roomNumber) {
                            system.viewReservationDetails(res);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
