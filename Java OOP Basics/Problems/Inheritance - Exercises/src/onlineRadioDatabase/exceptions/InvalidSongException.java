package onlineRadioDatabase.exceptions;

public class InvalidSongException extends IllegalArgumentException {
    public InvalidSongException(String s) {
        super(s);
    }
}
