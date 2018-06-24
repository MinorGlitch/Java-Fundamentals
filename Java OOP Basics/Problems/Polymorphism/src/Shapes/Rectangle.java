package Shapes;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double length) {
        this.width = width;
        this.height = length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculatePerimeter() {
        return (2 * width) + (2 * height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
