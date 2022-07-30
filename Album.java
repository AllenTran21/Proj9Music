//package proj9music;

/**
 * Album class for Album objects
 * @author Allen
 */
public class Album {
/**
 * Used to create, get, set, and print info pertaining to Album
 */
    private String title;
    private String artist;
    private int year;

    public Album() {
        title = "";
        artist = "";
        year = 0;
    }
    /**
     *
     * @param newTitle title name when created
     * @param newArtist artist name when created
     * @param newYear year when created
     */
    public Album(String newTitle, String newArtist, int newYear) {
        this.title = newTitle;
        this.artist = newArtist;
        this.year = newYear;
    }

    /**
     * Getters for Proj9Music to access
     *
     * @return returns title, artist, or year as requested
     */
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    /**
     * Modifiers to change musicCollection information
     *
     * @param new information to change info
     */
    public void changeTitle(String newTitle) {
        this.title = newTitle;
    }

    public void changeArtist(String newArtist) {
        this.artist = newArtist;
    }

    public void changeYear(int newYear) {
        this.year = newYear;
    }

    /**
     *Prints all songs that are currently stored in the array
     */
    public static void printAlbum(Album[] musicCollection, int songsInArray) {
        for (int i = 0; i < songsInArray; i++) {
            System.out.println("Title:  " + musicCollection[i].getTitle());
            System.out.println("Artist: " + musicCollection[i].getArtist());
            System.out.println("Year:   " + musicCollection[i].getYear());
        }
    }
}
