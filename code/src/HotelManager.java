import java.sql.*;

public class HotelManager {

    Room[] rooms = {
        new Room(101, "Standard"),
        new Room(102, "Standard"),
        new Room(201, "Deluxe"),
        new Room(202, "Deluxe"),
        new Room(301, "Suite")
    };

    void showRooms() {
        System.out.println("\nAvailable Rooms");
        for (Room r : rooms) {
            if (r.available) {
                System.out.println(r.roomNo + " - " + r.type);
            }
        }
    }

    void bookRoom(Reservation r) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO bookings(customer_name, room_no, room_type, days, rent, payment_status) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, r.customer);
            ps.setInt(2, r.roomNo);
            ps.setString(3, r.roomType);
            ps.setInt(4, r.days);
            ps.setInt(5, r.rent);
            ps.setString(6, r.paymentStatus);

            ps.executeUpdate();

            System.out.println("Booking Successful");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void viewBookings() {
        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM bookings");

            System.out.println("\nBooking Details");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("customer_name") + " | Room " +
                        rs.getInt("room_no") + " | " +
                        rs.getString("room_type") + " | " +
                        rs.getInt("days") + " Days | ₹" +
                        rs.getInt("rent") + " | " +
                        rs.getString("payment_status"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void cancelBooking(int id) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement("DELETE FROM bookings WHERE id=?");

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Booking Cancelled");
            else
                System.out.println("Booking Not Found");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}