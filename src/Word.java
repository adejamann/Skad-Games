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
    
    public Word () {
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
        
      }

}