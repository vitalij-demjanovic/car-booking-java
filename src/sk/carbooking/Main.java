package sk.carbooking;

import sk.carbooking.booking.Booking;
import sk.carbooking.booking.BookingService;
import sk.carbooking.car.Car;
import sk.carbooking.user.User;
import sk.carbooking.user.UserService;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        BookingService bookingService = new BookingService();

        boolean keepLooping = true;

        try {
            while (keepLooping) {
                displayMenu();
                String choice = scanner.nextLine();
                switch (Integer.parseInt(choice)) {
                    case 1 -> bookCar(userService, bookingService, scanner);
                    case 2 -> displayAllUserBookedCars(userService, bookingService, scanner);
                    case 3 -> displayAllBookings(bookingService);
                    case 4 -> displayAvailableCars(bookingService, false);
                    case 5 -> displayAvailableCars(bookingService, true);
                    case 6 -> displayAllUsers(userService);
                    case 7 -> keepLooping = false;
                    default -> System.out.println(choice + " not a valid option ❌");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void displayAllUsers(UserService userService) {
        User[] users = userService.getUsers();

        if (users.length == 0) {
            System.out.println("❌ No users in the system");
        }

        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void displayAllBookings(BookingService bookingService) {
        Booking[] bookings = bookingService.getBookings();

        if (bookings.length == 0) {
            System.out.println("No bookings available 😕");
            return;
        }

        for (Booking booking : bookings) {
            System.out.println("booking =  " + booking);
        }
    }

    private static void displayAvailableCars(BookingService carBookingService, boolean isElectric) {
        Car[] availableCars = isElectric ? carBookingService.getAvailableElectricCars() : carBookingService.getAvailableCars();
        if (availableCars.length == 0) {
            System.out.println("❌ No cars available for renting");
            return;
        }
        for (Car availableCar : availableCars) {
            System.out.println(availableCar);
        }
    }

    private static void displayAllUserBookedCars(UserService userService, BookingService bookingService, Scanner scanner) {
        displayAllUsers(userService);

        System.out.println("➡️ select user id");
        String userId = scanner.nextLine();

        User user = userService.getUserById(UUID.fromString(userId));

        if (user == null) {
            System.out.println("❌ No user found with id " + userId);
        }

        Car[] userBookedCars = bookingService.getUserBookedCars(user.getId());
        if (userBookedCars.length == 0) {
            System.out.printf("❌ user %s has no cars booked", user);
            return;
        }

        for (Car userBookedCar : userBookedCars) {
            System.out.println(userBookedCar);
        }

    }

    private static void bookCar(UserService userService, BookingService bookingService, Scanner scanner) {
        displayAvailableCars(bookingService, false);

        System.out.println("➡️ select car reg number");
        String regNumber = scanner.nextLine();

        displayAllUsers(userService);
        String userId = scanner.nextLine();

        try {
            User user = userService.getUserById(UUID.fromString(userId));
            if(user == null) {
                System.out.println("❌ No user found with id " + userId);
            } else {
                UUID bookingId = bookingService.bookCar(user, regNumber);
                String confirmationMessage = """
                        🎉 Successfully booked car with reg number %s for user %s
                        Booking ref: %s
                        """.formatted(regNumber, user, bookingId);
                System.out.println(confirmationMessage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private static void displayMenu() {
        System.out.println("""
                \n
                1️⃣ - Book Car
                2️⃣ - View All User Booked Cars
                3️⃣ - View All Bookings
                4️⃣ - View Available Cars
                5️⃣ - View Available Electric Cars
                6️⃣ - View all users
                7️⃣ - Exit
                """);
    }
}