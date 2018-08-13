package logger.interfaces;

public interface File {
    void write(String message);
    long getSize();
}
