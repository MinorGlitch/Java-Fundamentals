package threeuple;

public class Threeuple<I1, I2, I3> {
    private I1 item1;
    private I2 item2;
    private I3 item3;

    public Threeuple(I1 item1, I2 item2, I3 item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
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

    public I3 getItem3() {
        return item3;
    }

    public void setItem3(I3 item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return item1 + " -> " + item2 + " -> " + item3;
    }
}
