package tuple;

public class Tuple<I1, I2> {
    private I1 item1;
    private I2 item2;

    public Tuple(I1 item1, I2 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public I1 getItem1() {
        return item1;
    }

    public void setItem1(I1 item1) {
        this.item1 = item1;
    }

    public I2 getItem2() {
        return item2;
    }

    public void setItem2(I2 item2) {
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return item1 + " -> " + item2;
    }
}
