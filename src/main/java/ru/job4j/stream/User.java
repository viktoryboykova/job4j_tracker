package ru.job4j.stream;

public class User {
    private String name;

    private String surname;

    private byte age;

    private String login;

    private String password;

    private boolean activated;

    private String gender;

    public static class Builder {
        private String name;
        private String surname;
        private byte age;
        private String login;
        private String password;
        private boolean activated;
        private String gender;

        public Builder buildName(String name) {
            this.name = name;
            return this;
        }

        public Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        public Builder buildLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder buildPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder buildActivated(boolean activated) {
            this.activated = activated;
            return this;
        }

        public Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        public User build() {
            User user = new User();
            user.name = name;
            user.surname = surname;
            user.age = age;
            user.login = login;
            user.password = password;
            user.activated = activated;
            user.gender = gender;
            return user;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", activated=" + activated +
                ", gender='" + gender + '\'' +
                '}';
    }
}
