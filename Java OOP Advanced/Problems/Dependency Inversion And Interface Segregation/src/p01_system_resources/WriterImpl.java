package p01_system_resources;

public class WriterImpl implements Writer {
    @Override
    public void println(String value) {
        System.out.println(value);
    }
}
