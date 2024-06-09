// Vivek Vemulakonda
// 05/30/2024
// CSE 122
//C3:OOP It!
// TA: Megana Kommareddy, Rucha Kher
//This program will make a music playlist that includes adding songs, playing songs, printing
//the history of played songs, and clearing or deleting history
import java.util.*;
import java.io.*;

public class MusicPlaylistMain {
    public static void main(String[] args){
        System.out.println("Welcome to the CSE 122 Music Playlist!");
        Scanner console = new Scanner(System.in);
        MusicPlaylist playlist= new MusicPlaylist();
        String response= "";
        while(!response.equalsIgnoreCase("q")){
            response= options(console);
            if(response.equalsIgnoreCase("a")){
                System.out.print("Enter song name: ");
                String songName = console.nextLine();
                playlist.addSong(songName);
            }else if(response.equalsIgnoreCase("p")){
                playlist.playSong();
            }else if(response.equalsIgnoreCase("pr")){
                playlist.print();
            }else if(response.equalsIgnoreCase("c")){
                playlist.clearHistory();
            }else if(response.equalsIgnoreCase("d")){
                System.out.println("A positive number will delete from recent history.");
                System.out.println("A negative number will delete from the beginning of history.");
                System.out.print("Enter number of songs to delete: ");
                String reply= console.nextLine();
                playlist.delHistory(reply);
            }
        System.out.println();
        System.out.println();
        }
    }

    //Behavior:Prints out a list of options asking for response
    //Parameters:Scanner console:user input
    //Returns:String:user's choice
    public static String options(Scanner console){
        System.out.println("(A) Add song");
        System.out.println("(P) Play song");
        System.out.println("(Pr) Print history");
        System.out.println("(C) Clear history");
        System.out.println("(D) Delete from history");
        System.out.println("(Q) Quit");
        System.out.println();
        System.out.print("Enter your choice: ");
        String choice=console.nextLine();
        return choice;
    }
}