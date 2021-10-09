package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (int i = 0; i < users.length; i++) {
            User user = users[i];
            if (login.equals(user.getUsername())) {
                return users[i];
            }
        }
        throw new UserNotFoundException("User didn't find");
    }

    public static boolean validate(User user) throws UserInvalidException {
        String username = user.getUsername();
        if(!user.isValid() || username.length() < 3) {
            throw new UserInvalidException("User isn't valid");
        }
        return true;
    }

    public static void main (String[]args){
        User[] users = {
                new User("petr", false)
        };
        try {
            User user = findUser(users, "petr");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e1) {
            e1.printStackTrace();
        } catch (UserNotFoundException e2) {
            e2.printStackTrace();
        }
    }
}
