package Proxy;

import java.util.*;

public class Driver {
    
    public static void main(String[] args){

        HashMap<Integer, Song> songs = new HashMap<>();
        Song song1 = new Song("A", "AA", "AAA", 1);
        Song song2 = new Song("B", "BB", "BBB", 2);
        Song song3 = new Song("C", "CC", "CCC", 3);
        Song song4 = new Song("D", "DD", "DDD", 4);
        Song song5 = new Song("E", "EE", "EEE", 5);
        Song song6 = new Song("A", "BB", "CCC", 6);
        Song song7 = new Song("B", "CC", "DDD", 7);
        Song song8 = new Song("C", "DD", "EEE", 8);
        Song song9 = new Song("D", "EE", "FFF", 9);
        Song song10 = new Song("E", "FF", "GGG", 1);
        songs.put(1, song1);
        songs.put(2, song2);
        songs.put(3, song3);
        songs.put(4, song4);
        songs.put(5, song5);
        songs.put(6, song6);
        songs.put(7, song7);
        songs.put(8, song8);
        songs.put(9, song9);
        songs.put(10, song10);

        SongLibrary songLibrary = new SongLibrary(songs);
        SongService songProxy = new SongProxy(songLibrary);

        // Search for songs
        System.out.println(songProxy.searchById(1));
        System.out.println(songProxy.searchById(1));
        System.out.println(songProxy.searchById(10));
        System.out.println(songProxy.searchByTitle("A"));
        System.out.println(songProxy.searchByTitle("B"));
        System.out.println(songProxy.searchByTitle("E"));
        System.out.println(songProxy.searchByAlbum("CCC"));
        System.out.println(songProxy.searchByAlbum("CCC"));
        System.out.println(songProxy.searchByAlbum("GGG"));
        System.out.println(songProxy.searchById(6));
        System.out.println(songProxy.searchById(3));
        System.out.println(songProxy.searchByTitle("C"));
        System.out.println(songProxy.searchByTitle("D"));
        System.out.println(songProxy.searchByAlbum("DDD"));
        System.out.println(songProxy.searchByAlbum("FFF"));
    }
}
