package sk.carbooking.user;

import java.util.UUID;

public class UserService {
    private final static UserDAO userDao = new UserDAO();

    public User[] getUsers(){
      return userDao.getUsers();
    };

    public User getUserById(UUID id) {
        for (User user : userDao.getUsers()) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    };
}
