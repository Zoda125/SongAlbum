import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Album()
    {

    }
    public Song findSong(String title)
    {
        for(Song checkSong : songs)
        {
            if(checkSong.getTitle().equals(title)) return checkSong;
        }
        return null;
    }
    public boolean addSong(String title,double duration)
    {
        if(findSong(title)==null)
        {
            songs.add(new Song(title,duration));
           // System.out.println(title + " Successfully Added To The List ");
            return true;
        }
        else{
           // System.out.println("Song with name "+title+" already exist in the list");
            return false;
        }
    }
    public boolean addToPlaylist(int trackNumber, LinkedList<Song>Playlist)
    {
        int index=trackNumber - 1;
        if (index>0 && index <=this.songs.size())
        {
            Playlist.add(this.songs.get(index));
            return true;
        }
       // System.out.println("This Album Doesn't Have Song With TrackNumber "+trackNumber);
        return false;
    }
    public boolean addToPlaylist(String title,LinkedList<Song>Playlist)
    {
        for (Song checkSong : this.songs)
        {
            if (checkSong.getTitle().equals(title))
            {
                Playlist.add(checkSong);
                return true;
            }
        }
       // System.out.println(title+" There Is No Such Song In Album");
        return false;
    }
}
