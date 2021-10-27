package ru.job4j.stream;

public class Application {

    public static void main(String[] args) {
        User user = new User.Builder()
                .buildName("name")
                .buildSurname("surname")
                .buildAge((byte) 32)
                .buildLogin("login")
                .buildPassword("password")
                .buildActivated(true)
                .buildGender("male")
                .build();
        System.out.println(user);

        Cat kisa = new Cat.Builder()
                .buildName("Киса Васильев")
                .buildAge((byte) 2)
                .buildBreed("Као-мани")
                .buildCoatColor("Бело-серый")
                .buildEyeColor("Разноцветные")
                .buildSleepy(true)
                .build();
        System.out.println(kisa);
    }

}
