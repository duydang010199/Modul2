package com.PTbac2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number A: ");
        double numberA = sc.nextDouble();
        System.out.print("Enter number B: ");
        double numberB = sc.nextDouble();
        System.out.print("Enter number C: ");
        double numberC = sc.nextDouble();
        QuadraticEquation qd = new QuadraticEquation(numberA, numberB, numberC);

        System.out.println("Delta = " + qd.getDiscriminant());

        qd.coditionDelta(numberA, numberB, numberC);
    }
}
