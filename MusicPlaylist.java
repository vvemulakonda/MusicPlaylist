// Vivek Vemulakonda
// 05/30/2024
// CSE 122
//C3:OOP It!
// TA: Megana Kommareddy, Rucha Kher
// This class replicates all of the features in the music playlist project
import java.util.*;
import java.io.*;
public class MusicPlaylist {
    private Queue<String> playlist;
    private Stack<String> history;

    //Construcor method
    public MusicPlaylist(){
        this.playlist = new LinkedList<>();
        this.history = new Stack<>();
    }

    //Pre:no Parameters
    //Post:Return a queue that is the playlist
    public Queue<String> getPlaylist(){
        return this.playlist;
    }

    //Pre:No Parameters
    //Post:Return a stack that is the history
    public Stack<String> getHistory(){
        return this.history;
    }

    //Behavior:Adds a song to the Playlist
    //Parameters:Queue<String> songs: songs in playlist, Scanner console:user input
    //Returns:No return; prints message
    public void addSong(String song){
        playlist.add(song);
        System.out.println("Successfully added " + song);
    }

    //Behavior:Will play song and remove it from the song playlist, will add to history
    //Exception:If the playlist is empty it will throw a IllegalStateException
    //Parameters:Queue<String> songs: songs in playlist, Scanner console:user input,
    //Stack<String> history:songs played
    //Returns:no return;will print out message
    public void playSong(){
        if(playlist.isEmpty()){
            throw new IllegalStateException();
        }
        String currSong = playlist.remove();
        System.out.println("Playing song: " + currSong);
        history.push(currSong);
    }

    //Behavior:Will delete user's choice of amount of songs from history, either from beginning 
    //or most recent in history postive standing for most recently played, and negative
    //chronologically-first song
    //Parameters:Stack<String> history:songs played, Scanner console:user input
    //Returns: no return; will print out message
    public void delHistory(String response){
        int num=Integer.parseInt(response);
        int absVal=Math.abs(num);
        if(absVal>history.size()){
            throw new IllegalArgumentException();
        }
        if(num>0){
            for(int i=0;i<num;i++){
                history.pop();
            }
        }else if(num<0){
            Stack<String> reverse = new Stack<>();
            reverseStack(reverse, history);
            for(int j=0;j<absVal;j++){
                reverse.pop();
            }
            int size=reverse.size();
            for(int k=0;k<size;k++){
                history.push(reverse.pop());
            }
        }
    }

    //Behavior:Will put the history songs into reverse order
    //Returns:There are no Returns
    //Parameters: Stack<String> history:songs played, Stack<String> reverse:reverse order stack
    private static void reverseStack(Stack<String> reverse, Stack<String> history){
        while(!history.isEmpty()){
            reverse.push(history.pop());
        }
    }

    public void clearHistory(){
        history.clear();
    }

    //Behavior:Will print out songs played in reverse order, first song displayed 
    //being the most recent
    //Exception:If history is empty will throw IllegalStateException
    //Parameters:Stack<String> history:songs played
    //Returns:no return
    public  void print(){
        if(history.isEmpty()){
            throw new IllegalStateException();
        }
        Stack<String> reverseSongs = new Stack<>();
            reverseStack(reverseSongs, history);
            System.out.println(reverseSongs);
        while(!reverseSongs.isEmpty()){
            String currSong=reverseSongs.pop();
            history.push(currSong);
        }
    }
}
