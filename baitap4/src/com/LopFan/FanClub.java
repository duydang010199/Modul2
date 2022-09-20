package com.LopFan;

public class FanClub {
    public static void main(String[] args) {
        Fan fan = new Fan(3, true, 1, "red");
        System.out.println(fan.toString());
        Fan fan1 = new Fan();
        System.out.println(fan1.toString());
        fan1.setColor("Black");
        fan1.setOn(true);
        fan1.setSpeed(fan1.getMedium());
        System.out.println(fan1.toString());
    }
}
