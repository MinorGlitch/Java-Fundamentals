package P05_Square;

public class Square extends Tetragon {
    @Override
    protected void setWidth(int width) {
        this.setSide(width);
    }

    @Override
    protected void setHeight(int height) {
        this.setSide(height);
    }

    private void setSide(int side) {
        super.setHeight(side);
        super.setWidth(side);
    }
}
