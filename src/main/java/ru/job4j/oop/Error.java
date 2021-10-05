package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;
    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
            }

    public static void main(String[] args) {
        Error error1 = new Error();
        error1.printInfo();
        Error error2 = new Error(true, 1, "Привет, Егор");
        error2.printInfo();
        Error error3 = new Error(true, 500, "Киса носится по комнате");
        error3.printInfo();
    }

    private void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }
}
