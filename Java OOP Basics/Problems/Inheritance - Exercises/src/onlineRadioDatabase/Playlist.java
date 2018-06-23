package onlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songs;

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public String printPlaylistTime() {
        int playlistLength = getPlaylistLength(this.songs);

        int hours = playlistLength / 3600;
        int minutes = (playlistLength % 3600) / 60;
        int seconds = playlistLength % 60;

        return String.format("Playlist length: %dh %dm %ds", hours, minutes, seconds);
    }

    public int getSongsCount() {
        return this.songs.size();
    }

    private int getPlaylistLength(List<Song> songs) {
        return songs.stream().mapToInt(s -> s.getSongLength().getTotalTime()).sum();
    }
}
