package classBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (isNegative(length)) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (isNegative(width)) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (isNegative(height)) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    private double getLength() {
        return length;
    }

    private double getWidth() {
        return width;
    }

    private double getHeight() {
        return height;
    }

    public double calculateSurfaceArea() {
        return (2 * getLength() * getWidth()) + (2 * getLength() * getHeight()) + (2 * getWidth() * getHeight());
    }

    public double calculateLateralSurfaceArea() {
        return (2 * getLength() * getHeight()) + (2 * getWidth() * getHeight());
    }

    public double calculateVolume() {
        return getLength() * getWidth() * getHeight();
    }

    private boolean isNegative(double side) {
        return side <= 0;
    }
}
