import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelManager hotel = new HotelManager();

        while (true) {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. View Bookings");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    hotel.showRooms();
                    break;

                case 2:
                    sc.nextLine();

                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();

                    System.out.println("Room Type");
                    System.out.println("1. Standard (₹1000/day)");
                    System.out.println("2. Deluxe (₹2000/day)");
                    System.out.println("3. Suite (₹3000/day)");

                    int typeChoice = sc.nextInt();

                    String roomType = "";
                    int rentPerDay = 0;

                    if (typeChoice == 1) {
                        roomType = "Standard";
                        rentPerDay = 1000;
                    } else if (typeChoice == 2) {
                        roomType = "Deluxe";
                        rentPerDay = 2000;
                    } else if (typeChoice == 3) {
                        roomType = "Suite";
                        rentPerDay = 3000;
                    } else {
                        System.out.println("Invalid Room Type");
                        break;
                    }

                    System.out.print("Room Number: ");
                    int room = sc.nextInt();

                    System.out.print("Number of Days: ");
                    int days = sc.nextInt();

                    int totalRent = rentPerDay * days;

                    System.out.println("Total Rent = ₹" + totalRent);
                    System.out.print("Confirm Payment (Y/N): ");
                    String pay = sc.next();

                    String status;

                    if (pay.equalsIgnoreCase("Y"))
                        status = "Paid";
                    else
                        status = "Pending";

                    Reservation r = new Reservation(name, room, roomType, days, totalRent, status);

                    hotel.bookRoom(r);

                    break;

                case 3:
                    hotel.viewBookings();
                    break;

                case 4:
                    System.out.print("Enter Booking ID: ");
                    int id = sc.nextInt();
                    hotel.cancelBooking(id);
                    break;

                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}