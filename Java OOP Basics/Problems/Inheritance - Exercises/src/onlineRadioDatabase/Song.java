package onlineRadioDatabase;

import onlineRadioDatabase.constants.ExceptionConstants;
import onlineRadioDatabase.exceptions.InvalidArtistNameException;
import onlineRadioDatabase.exceptions.InvalidSongLengthException;
import onlineRadioDatabase.exceptions.InvalidSongNameException;

public class Song {
    private String artist;
    private String name;
    private SongLength songLength;

    public Song(String artist, String name, String[] timeArgs) {
        this.setArtist(artist);
        this.setName(name);
        this.songLength = new SongLength(timeArgs);
    }

    public SongLength getSongLength() {
        return songLength;
    }

    private void setName(String name) {
        if (name.length() < 3 || name.length() > 20) {
            throw new InvalidSongNameException(ExceptionConstants.INVALID_SONG_NAME_MESSAGE);
        }
        this.name = name;
    }

    private void setArtist(String artist) {
        if (artist.length() < 3 || artist.length() > 20) {
            throw new InvalidArtistNameException(ExceptionConstants.INVALID_ARTIST_NAME_MESSAGE);
        }

        this.artist = artist;
    }
}
