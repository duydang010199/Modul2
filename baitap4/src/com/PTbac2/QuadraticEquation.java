package com.PTbac2;

public class QuadraticEquation {
    double a, b, c;

    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant(){
        return (this.b * this.b) - 4 * this.a * this.c;
    }
    public void coditionDelta(double a, double b, double c){
        double delta = getDiscriminant();
        if (a == 0 && b == 0 && c == 0){
            System.out.println("The equation has infinitely many solutions");
        } else if (a == 0 && b == 0) {
            System.out.println("Undefined equation");
        } else if (a == 0){
            System.out.println("The equation with 1 solution is: " + (-c / b));
        } else if (delta == 0){
            System.out.println("X = " + getRoot1(a, b, c));
        } else if (delta > 0){
            System.out.println("X1 = " + getRoot1(a, b, c) + " và X2 = " + getRoot2(a, b, c));
        } else {
            System.out.println("The equation has no roots");
        }
    }
    public double getRoot1 (double a, double b, double c){
        return (-b + (Math.sqrt((b * b) - 4 * a * c))) / 2 * a;
    }
    public double getRoot2 (double a, double b, double c){
        return (-b - (Math.sqrt((b * b) - 4 * a * c))) / 2 * a;
    }
}
