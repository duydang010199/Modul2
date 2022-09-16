package com.HCN;

public class Rectangle {
    double width, height;

    public Rectangle (double widht, double height){
        this.width = widht;
        this.height = height;
    }
    public double getArea() {
        return this.width * this.height;
    }
    public double getPerimeter(){
        return  (this.width + this.height) * 2;
    }
    public String display(){
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }

}
