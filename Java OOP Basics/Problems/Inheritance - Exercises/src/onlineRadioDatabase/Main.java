package onlineRadioDatabase;

import onlineRadioDatabase.constants.ExceptionConstants;
import onlineRadioDatabase.exceptions.InvalidSongException;
import onlineRadioDatabase.exceptions.InvalidSongLengthException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        List<Song> songs = new ArrayList<>();

        Playlist playlist = new Playlist();

        for (int i = 0; i < n; i++) {
            String[] songArgs = reader.readLine().split(";");

            String artist = songArgs[0];
            String name = songArgs[1];
            String[] timeArgs = songArgs[2].split(":");


            try {
                playlist.addSong(new Song(artist, name, timeArgs));
                System.out.println("Song added.");
            } catch (InvalidSongException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.printf("Songs added: %d%n", playlist.getSongsCount());

        System.out.println(playlist.printPlaylistTime());
    }


}
