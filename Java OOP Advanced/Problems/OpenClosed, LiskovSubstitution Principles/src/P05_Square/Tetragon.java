package P05_Square;

public abstract class Tetragon {
    int width;
    int height;

    protected Tetragon() {};

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    protected int getArea() {
        return this.getWidth() * this.getHeight();
    }
}
