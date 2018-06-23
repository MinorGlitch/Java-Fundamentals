package onlineRadioDatabase;

import onlineRadioDatabase.constants.ExceptionConstants;
import onlineRadioDatabase.exceptions.InvalidSongLengthException;
import onlineRadioDatabase.exceptions.InvalidSongMinutesException;
import onlineRadioDatabase.exceptions.InvalidSongSecondsException;

public class SongLength {
    private int minutes;
    private int seconds;
    private int totalTime;

    public SongLength(String[] timeArgs) {
        String minutes = timeArgs[0];
        String seconds = timeArgs[1];

        if (timeArgs.length != 2 || !timeArgs[0].matches("\\d+") || !timeArgs[1].matches("\\d+")) {
            throw new InvalidSongLengthException(ExceptionConstants.INVALID_SONG_LENGTH_MESSAGE);
        }

        this.setMinutes(Integer.valueOf(minutes));
        this.setSeconds(Integer.valueOf(seconds));
        this.setTotalTime();
    }

    public int getTotalTime() {
        return totalTime;
    }

    private void setTotalTime() {
        this.totalTime = (this.minutes * 60) + this.seconds;
    }

    private void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException(ExceptionConstants.INVALID_SONG_SECONDS_MESSAGE);
        }

        this.seconds = seconds;
    }

    private void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException(ExceptionConstants.INVALID_SONG_MINUTES_MESSAGE);
        }

        this.minutes = minutes;
    }
}
