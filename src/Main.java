import java.util.*;

public class Main {
    private static ArrayList<Album>albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("ROCK", "Linkin Park");
        album.addSong("In The End", 3.39);
        album.addSong("Numb", 3.08);
        album.addSong("Lost", 3.19);
        album.addSong("One More Light", 4.31);
        album.addSong("Castle Of Glass", 4.50);
        album.addSong("Heavy", 2.49);
        album.addSong("New Divide", 4.29);
        album.addSong("Burn It Down", 3.54);

        albums.add(album);

        album = new Album("RAP", "50 Cent");
        album.addSong("In Da Club", 4.08);
        album.addSong("Candy Shop", 4.10);
        album.addSong("P.I.M.P", 4.59);

        albums.add(album);

        LinkedList<Song> playlist_1 = new LinkedList<>();

        albums.get(0).addToPlaylist("In The End", playlist_1);
        albums.get(0).addToPlaylist("Numb", playlist_1);
        albums.get(0).addToPlaylist("Lost", playlist_1);
        albums.get(0).addToPlaylist("One More Light", playlist_1);
        albums.get(1).addToPlaylist("In Da Club", playlist_1);
        albums.get(1).addToPlaylist("Candy Shop", playlist_1);

        play(playlist_1);
    }
        private static void play(LinkedList<Song> playlist){
            Scanner sc = new Scanner(System.in);
            boolean quit = false;
            boolean forward = true;
            ListIterator<Song> listIterator = playlist.listIterator();

            if(playlist.size()==0)
            {
                System.out.println("This Playlist Have No Song");
            }
            else {
                System.out.println("Now Playing "+listIterator.next().toString());
                printMenu();
            }
            while (!quit==true)
            {
                int action = sc.nextInt();
                sc.nextLine();
                switch (action)
                {
                    case 0:
                        System.out.println("Playlist Complete");
                        quit=true;
                        break;
                    case 1:

                        if (!forward)
                        {
                            if (listIterator.hasNext())
                            {
                                listIterator.next();
                            }
                            forward=true;
                        }
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now Playing "+listIterator.next().toString());
                        }
                        else {
                            System.out.println("No Songs Available , Reached To The End Of The List");
                            forward=false;
                        }
                        break;
                    case 2:
                        if (forward)
                        {
                            if (listIterator.hasPrevious())
                            {
                                listIterator.previous();
                            }
                            forward = false;
                        }
                        if (listIterator.hasPrevious())
                        {
                            System.out.println("Now Playing "+listIterator.previous().toString());
                        }
                        else {
                            System.out.println("We Are At The First Song ");
                            forward=false;
                        }
                        break;
                    case 3:
                        if (forward) {
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now Playing " + listIterator.previous().toString());
                                forward = false;
                            } else {
                                System.out.println("We Are At The Start Of The List ");
                            }
                        }
                            else{
                                if (listIterator.hasNext())
                                {
                                    System.out.println("Now Playing "+listIterator.next().toString() );
                                    forward=true;
                                }
                                else
                                {
                                    System.out.println("We Have Reached To The End Of List");
                                }
                        }

                        break;
                    case 4:
                        printList(playlist);
                        break;
                    case 5:
                        printMenu();
                        break;
                    case 6:
                        if (playlist.size()>0)
                        {
                            listIterator.remove();
                            if(listIterator.hasNext())
                            {
                                System.out.println("Now Playing "+listIterator.next().toString());

                            }
                            else
                            {
                                if (listIterator.hasPrevious())
                                {
                                    System.out.println("Now Playing "+listIterator.previous().toString());
                                }
                            }
                        }
                }
            }
        }
        private static void printMenu()
        {
            System.out.println("Available Options\n Press");
            System.out.println("0 - To Quit \n"+
                    "1  - To Play Next Song \n"+
                    "2 - To Play Previous Song\n"+
                    "3 - To Replay Current Song\n"+
                    "4 - List Of All Songs\n"+
                    "5 - Print All Available Options\n"+
                    "6 - Delete The Current Song");
        }
        private static void printList(LinkedList<Song>playlist)
        {
            Iterator<Song>iterator = playlist.iterator();
            System.out.println("----------------");
            while (iterator.hasNext())
            {
                System.out.println(iterator.next());
            }
            System.out.println("---------------");
        }
    }
