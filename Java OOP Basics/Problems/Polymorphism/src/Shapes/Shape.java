package Shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    protected Shape() {

    }

    protected double getPerimeter() {
        return perimeter;
    }

    protected double getArea() {
        return area;
    }

    protected abstract double calculatePerimeter();

    protected abstract double calculateArea();
}
