import java.util.*;

class Track {
    String trackName;
    String singerName;

    Track(String name, String singer) {
        trackName = name;
        singerName = singer;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Track)) return false;

        Track item = (Track) other;

        return trackName.equals(item.trackName)
            && singerName.equals(item.singerName);
    }

    public int hashCode() {
        return Objects.hash(trackName, singerName);
    }

    public String toString() {
        return trackName + " by " + singerName;
    }
}

public class Main {
    static LinkedList<Track> musicLine = new LinkedList<>();
    static LinkedList<Track> playedTracks = new LinkedList<>();

    static void appendTrack(Track item) {
        musicLine.addLast(item);
    }

    static void prioritizeTrack(Track item) {
        musicLine.addFirst(item);
    }

    static void placeTrack(int slot, Track item) {
        if (slot < 0 || slot > musicLine.size()) {
            System.out.println("Invalid slot");
            return;
        }

        musicLine.add(slot, item);
    }

    static void eliminateRepeats() {
        HashSet<Track> uniqueTracks = new HashSet<>();
        Iterator<Track> cursor = musicLine.iterator();

        while (cursor.hasNext()) {
            Track current = cursor.next();

            if (!uniqueTracks.add(current)) {
                cursor.remove();
            }
        }
    }

    static void playTrack() {
        if (musicLine.isEmpty()) {
            System.out.println("No tracks available");
            return;
        }

        Track current = musicLine.removeFirst();
        playedTracks.addLast(current);

        System.out.println("Playing: " + current);
    }

    static void printHistory() {
        ListIterator<Track> navigator = playedTracks.listIterator();

        while (navigator.hasNext()) {
            System.out.println(navigator.next());
        }
    }

    static void navigatePlaylist() {
        ListIterator<Track> navigator = musicLine.listIterator();

        System.out.println("Forward traversal:");

        while (navigator.hasNext()) {
            System.out.println(navigator.next());
        }

        System.out.println("Reverse traversal:");

        while (navigator.hasPrevious()) {
            System.out.println(navigator.previous());
        }
    }

    static void printQueue() {
        System.out.println(musicLine);
    }

    public static void main(String[] args) {
        Track first = new Track("Believer", "Imagine Dragons");
        Track second = new Track("Perfect", "Ed Sheeran");
        Track third = new Track("Believer", "Imagine Dragons");
        Track fourth = new Track("Numb", "Linkin Park");

        appendTrack(first);
        appendTrack(second);
        appendTrack(third);
        prioritizeTrack(fourth);

        placeTrack(2, new Track("Faded", "Alan Walker"));

        System.out.println("Playlist before cleanup:");
        printQueue();

        eliminateRepeats();

        System.out.println("Playlist after cleanup:");
        printQueue();

        navigatePlaylist();

        playTrack();

        System.out.println("Recently played tracks:");
        printHistory();
    }
}