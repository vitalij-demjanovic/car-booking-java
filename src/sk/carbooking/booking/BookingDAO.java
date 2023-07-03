package sk.carbooking.booking;

public class BookingDAO {
    private final static Booking[] carBookings;

    static {
        carBookings = new Booking[10];
    }

    public Booking[] getCarBookings() {
        return carBookings;
    }

    public void book(Booking carBooking) {
        int nextFreeIndex = -1;

        for (int i = 0; i < carBookings.length; i++) {
            if (carBookings[i] == null) {
                nextFreeIndex = i;
            }
        }

        if (nextFreeIndex > -1) {
            carBookings[nextFreeIndex] = carBooking;
            return;
        }

        // full array
        // copy all bookings to new array with bigger space
        Booking[] biggerCarBookings = new Booking[carBookings.length + 10];

        for (int i = 0; i < carBookings.length; i++) {
            biggerCarBookings[i] = carBookings[i];
        }

        // finally add new booking
        biggerCarBookings[carBookings.length] = carBooking;

    }
}
