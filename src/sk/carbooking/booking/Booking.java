package sk.carbooking.booking;

import sk.carbooking.car.Car;
import sk.carbooking.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {
    private UUID bookingId;
    private User user;
    private Car car;
    private LocalDateTime bookingTime;
    private boolean isCanceled;

    public Booking(UUID bookingId, User user, Car car, LocalDateTime bookingTime, boolean isCanceled) {
        this.bookingId = bookingId;
        this.user = user;
        this.car = car;
        this.bookingTime = bookingTime;
        this.isCanceled = isCanceled;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }
}
