package sk.carbooking;

import sk.carbooking.user.UserService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println(userService.gerUserById(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3")));
    }
}