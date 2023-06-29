package sk.carbooking.booking;

public class BookingDAO {
    private final static Booking[] carBooking;

    static {
        carBooking = new Booking[10];
    }

    public static Booking[] getCarBooking() {
        return carBooking;
    }
}
