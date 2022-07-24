import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.net.MalformedURLException;
import java.io.IOException;

public class Word {
    public String word;
    public static ArrayList<String> words = new ArrayList<> (Arrays.asList( 
   "great", "noise", "night", "zebra", "voice", "sight", "print", "brave",
   "vocal", "chain", "crate", "right", "crave", "adobe", "break", "while",
   "sedan", "white", "grave", "chase", "acted", "brake", "clear", "paste",
   "shown", "dream", "crazy", "about", "cabin", "trace", "nodes", "paint",
   "light", "steam", "aunty", "among", "alert", "focal", "satin", "world",
   "faint", "might", "stare", "store", "power", "anime", "inset", "focus",
   "urban", "close", "whole", "whale", "flake", "flare", "token", "taken",
   "train", "brain", "extra", "pixel", "quail", "poise", "bound", "waste",
   "taste", "touch", "hover", "write", "image", "logic", "eight", "cover",
   "codes", "value", "yacht", "lover", "break", "adpot", "mouse", "baked")); 

    
    public Word () {
       word = words.get((int)(Math.random() * words.size())); 
       
    /**
    try {
            String sUrl = "https://random-word-api.herokuapp.com/word?length=5";
            URL url = new URL(sUrl);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                word = inputLine.substring(2, 7);
            in.close();
        } catch (MalformedURLException mue) {
            System.out.println("Malformed url exception");
        } catch (IOException ioe) {
            System.out.println("IO Exception");
        }
        */
      }
      
      



















            
      
      

}