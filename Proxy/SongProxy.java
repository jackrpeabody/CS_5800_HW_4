package Proxy;

import java.util.*;

// Proxy
public class SongProxy implements SongService{
    
    private SongLibrary songLibrary;

    private HashMap<Integer, Song> idCache;
    private HashMap<String, List<Song>> titleCache;
    private HashMap<String, List<Song>> albumCache;

    public SongProxy(SongLibrary songLibrary){
        this.songLibrary = songLibrary;
        this.idCache = new HashMap<>();
        this.titleCache = new HashMap<>();
        this.albumCache = new HashMap<>();
    }

    public Song searchById(Integer songId){
        if(idCache.containsKey(songId)){
            return idCache.get(songId);
        }
        else{
            Song s = songLibrary.searchById(songId);
            if(s != null){
                idCache.put(songId, s);
            }
            return s;
        }
    }

    public List<Song> searchByTitle(String title){
        if(titleCache.containsKey(title)){
            return titleCache.get(title);
        }
        else{
            List<Song> s = songLibrary.searchByTitle(title);
            if(s != null){
                titleCache.put(title, s);
            }
            return s;
        }
    }

    public List<Song> searchByAlbum(String album){
        if(albumCache.containsKey(album)){
            return albumCache.get(album);
        }
        else{
            List<Song> s = songLibrary.searchByAlbum(album);
            if(s != null){
                albumCache.put(album, s);
            }
            return s;
        }
    }
}
