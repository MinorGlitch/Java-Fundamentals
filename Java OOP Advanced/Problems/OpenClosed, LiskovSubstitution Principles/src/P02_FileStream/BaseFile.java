package P02_FileStream;

public abstract class BaseFile implements Streamable {
    private int length;
    private int bytesSent;

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getBytesSent() {
        return this.bytesSent;
    }
}
