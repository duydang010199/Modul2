package com.LopFan;

public class Fan {
    final int Slow = 1;
    final int Medium = 2;
    final int Fast = 3;

    private int speed = Slow;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSlow() {
        return Slow;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMedium(){
        return Medium;
    }
    public void setMedium(){
        System.out.println(Medium);
    }
    public int getFast(){
        return Fast;
    }
    public void setFast(){
        System.out.println(Fast);
    }
    public Fan(){
        this.speed = getSpeed();
        this.on = isOn();
        this.radius = getRadius();
        this.color = getColor();
    }
    public Fan(int speed, boolean on, double radius, String color){
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }
    public String toString(){
        String str = "";
        if (this.isOn()){
            str += ("fan is on \n");
            str += ("Speed: " + this.speed + "\n");
        } else {
            str += ("fan is off \n");
        }
        str += ("Color: " + this.color + "\n");
        str += ("Radius: " + this.radius + "\n");
        return str;
    }

}
