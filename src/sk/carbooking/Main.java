package sk.carbooking;

import sk.carbooking.car.CarService;
import sk.carbooking.user.UserService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        CarService carService = new CarService();

        boolean keepLooping = true;

        try {
            while (keepLooping) {
                displayMenu();
                String choice = scanner.nextLine();
                switch (Integer.parseInt(choice)) {
                    case 1 -> System.out.println("choice 1");
                    case 2 -> System.out.println("choice 1");
                    case 3 -> System.out.println("choice 1");
                    case 4 -> System.out.println(Arrays.toString(carService.getAllCars()));
                    case 5 -> System.out.println(Arrays.toString(carService.getAllElectricCars()));
                    case 6 -> System.out.println(Arrays.toString(userService.getUsers()));
                    case 7 -> keepLooping = false;
                    default -> System.out.println(choice + " not a valid option ❌");
                }
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