public class Reservation {
    String customer;
    int roomNo;
    String roomType;
    int days;
    int rent;
    String paymentStatus;

    public Reservation(String customer, int roomNo, String roomType,
                       int days, int rent, String paymentStatus) {
        this.customer = customer;
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.days = days;
        this.rent = rent;
        this.paymentStatus = paymentStatus;
    }
}