package ru.job4j.oop;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Point {

    private int x;

    private int y;

    public Point(int first, int second){
        this.x = first;
        this.y = second;
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        System.out.println(a.distance(b));
    }

    public double distance(Point another) {
        return sqrt(pow(this.x - another.x, 2) + pow(this.y - another.y, 2));
    }
}
