package sk.carbooking;

import sk.carbooking.booking.Booking;
import sk.carbooking.booking.BookingService;
import sk.carbooking.user.User;
import sk.carbooking.user.UserService;

import java.util.Scanner;

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
                    case 1 -> System.out.println("choice 1");
                    case 2 -> System.out.println("choice 1");
                    case 3 -> displayAllBookings(bookingService);
                    case 4 -> System.out.println("choice 1");
                    case 5 -> System.out.println("choice 1");
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
        Booking[] bookings = bookingService.getAllBookings();

        if (bookings.length == 0) {
            System.out.println("No bookings available 😕");
            return;
        }

        for (Booking booking : bookings) {
            System.out.println("booking =  " + booking);
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