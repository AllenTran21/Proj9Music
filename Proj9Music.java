/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//package proj9music;

/**
 *
 * @author Allen
 */
import java.util.*;

public class Proj9Music {

//    public static Album[] fillSong(Scanner input){
//    
//}
    public static int findSong(String songToFind, Album[] musicCollection) {
        int position = -1;
        for (int i = 0; i < musicCollection.length; i++) {
            if (songToFind.equals(musicCollection[i].getTitle())) {
                position = i;
                break;
            }
        }
        return position;
    }

    public static int findArtist(String artistToFind, Album[] musicCollection, int startPoint, int songsInArray) {
        int artistPosition = -1;
        for (int i = startPoint; i < songsInArray; i++) {
            if (artistToFind.equals(musicCollection[i].getArtist())) {
                artistPosition = i;
                break;
            }
        }
        return artistPosition;
    }

    public static void handlePrintArtist(Scanner input, Album[] musicCollection, int songsInArray) {
        int startPoint = 0;
        System.out.println("Please enter an artist: ");
        String artistName = input.nextLine();

        while (startPoint < songsInArray) {
            int artistPosition = findArtist(artistName, musicCollection, startPoint, songsInArray);
            printSongInfo(artistPosition, musicCollection);
            startPoint = artistPosition + 1;
        }
    }

    public static int findYear(String yearToFind, Album[] musicCollection) {
        int yearPosition = -1;
        for (int i = 0; i < musicCollection.length; i++) {
            if (yearToFind.equals(musicCollection[i].getYear())) {
                yearPosition = i;
                break;
            }
        }
        return yearPosition;
    }

    public static void handleAddAlbum(Scanner input, Album[] musicCollection, int firstBlank) {
        System.out.println("Please enter a title: ");
        String inputTitle = input.nextLine();
        System.out.println("Please enter an artist: ");
        String inputArtist = input.nextLine();
        System.out.println("Please enter a year: ");
        int inputYear = input.nextInt();
        musicCollection[firstBlank] = new Album(inputTitle, inputArtist, inputYear);

    }

    public static void handleUpdateAlbum(Scanner input, Album[] musicCollection) {
        System.out.println("Please enter a title: ");
        String toEmpty = input.nextLine();
        System.out.println("Please enter a title: ");
        String toFill = input.nextLine();
        int songLocation = findSong(toEmpty, musicCollection);
        if (songLocation == -1) {
            return;
        }
        System.out.println("Please enter an artist: ");
        String updateArtist = input.nextLine();
        System.out.println("Please enter a year: ");
        int updateYear = input.nextInt();

        musicCollection[songLocation].changeTitle(toFill);
        musicCollection[songLocation].changeArtist(updateArtist);
        musicCollection[songLocation].changeYear(updateYear);
    }

    public static void handleRemoveAlbum(Scanner input, Album[] musicCollection) {
        System.out.println("Please enter a title: ");
        String songTitle = input.nextLine();
        int songPosition = findSong(songTitle, musicCollection);
        if (songPosition == -1) {
            return;
        }
        for (int i = 0; i < musicCollection.length - songPosition - 1; i++) {
            musicCollection[songPosition + i] = musicCollection[songPosition + i + 1];
        }

    }

    public static void handlePrintCollection(Album[] musicCollection, int moviesInArray) {
        Album.printAlbum(musicCollection, moviesInArray);
    }

    public static void handlePrintYear(Scanner input, Album[] musicCollection) {
        System.out.println("Please enter a year: ");
        String artistName = input.nextLine();
        int artistPosition = findYear(artistName, musicCollection);

        printSongInfo(artistPosition, musicCollection);
    }

    public static void printSongInfo(int position, Album[] musicCollection) {
        System.out.println("Title:  " + musicCollection[position].getTitle());
        System.out.println("Artist: " + musicCollection[position].getArtist());
        System.out.println("Year:   " + musicCollection[position].getYear());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Album[] musicCollection = new Album[50];
//        for(int i = 0; i < musicCollection.length; i++){
//            musicCollection[i] = new Album();
//        }
        int userInput;
        int songsInArray = 0;
        do {
            System.out.println("Please make a selection:\n"
                    + "1 - Add a new album\n"
                    + "2 - Update an album\n"
                    + "3 - Remove an album\n"
                    + "4 - Print entire collection\n"
                    + "5 - Print by artist\n"
                    + "6 - Print by year\n"
                    + "7 - Quit");
            userInput = input.nextInt();
            if (input.hasNextLine() == true) {
                input.nextLine();
            }
            while (userInput <= 0 || userInput > 7) {
                System.out.println("Invalid response, try again.");
                userInput = input.nextInt();
            }

            switch (userInput) {
                case 1:
                    handleAddAlbum(input, musicCollection, songsInArray);
                    songsInArray++;
                    break;
                case 2:
                    handleUpdateAlbum(input, musicCollection);
                    break;
                case 3:
                    songsInArray--;
                    if (songsInArray < 0) {
                        return;
                    }
                    handleRemoveAlbum(input, musicCollection);
                    break;
                case 4:
                    handlePrintCollection(musicCollection, songsInArray);
                    break;
                case 5:
                    handlePrintArtist(input, musicCollection, songsInArray);
                    break;
                case 6:
                    handlePrintYear(input, musicCollection);
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

            }
        } while (userInput <= 7 && userInput > 0);
    }
}
