package logger.files;

import logger.interfaces.File;

public class LogFile implements File {
    private StringBuilder sb;

    public LogFile() {
        this.sb = new StringBuilder();
    }

    @Override
    public void write(String message) {
        sb.append(message).append(System.lineSeparator());
    }

    @Override
    public long getSize() {
        char[] characters = this.sb.toString().toCharArray();

        long sum = 0;

        for (int i = 0; i < characters.length; i++) {
            if (String.valueOf(characters[i]).matches("[A-Za-z]")) {
                sum += characters[i];
            }
        }

        return sum;
    }
}
