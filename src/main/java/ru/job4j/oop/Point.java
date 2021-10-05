package ru.job4j.oop;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Point {

    private int x;

    private int y;

    private int z;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0, 0);
        Point b = new Point(2, 0, 1);
        System.out.println(a.distance3d(b));
    }

    public double distance(Point another) {
        return sqrt(pow(this.x - another.x, 2) + pow(this.y - another.y, 2));
    }

    public double distance3d(Point another) {
        return sqrt(pow(this.x - another.x, 2) + pow(this.y - another.y, 2) + pow(this.z - another.z, 2));
    }
}
