import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LeaderBoard {
    public ArrayList<Player> leaderboard = new ArrayList<Player>();
    public void read() {
        try {
            FileReader scoresReader = new FileReader("Scores.txt");
            BufferedReader bufferedReader = new BufferedReader(scoresReader);

            FileReader namesReader = new FileReader("Names.txt");
            BufferedReader bufferedReader2 = new BufferedReader(namesReader);      
            
            FileReader profileReader = new FileReader("pfp.txt");
            BufferedReader bufferedReader3 = new BufferedReader(profileReader);      

            String name;
            int score;
            String profile;


            for (int i = 0; i < 10; i++) {
                score = Integer.parseInt(bufferedReader.readLine());
                name = bufferedReader2.readLine();
                profile = bufferedReader3.readLine();
                leaderboard.add(new Player(name, score, profile));
            }
            scoresReader.close();
            namesReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void clear() {
    leaderboard.clear();
    }

    public void insert(String name, int score) {
        leaderboard.add(new Player(name, score));
        Collections.sort(leaderboard, Collections.reverseOrder());
        System.out.println(leaderboard);
        //leaderboard.sort(Player::compareTo);
    }
    
    public void insert(String name, int score, String pfp) {
        leaderboard.add(new Player(name, score, pfp));
        Collections.sort(leaderboard, Collections.reverseOrder());
        System.out.println(leaderboard);
        //leaderboard.sort(Player::compareTo);
    }


    public void update () {
        try {

            // attach a file to FileWriter
            FileWriter fw1 = new FileWriter("Scores.txt", false);
            FileWriter fw2 = new FileWriter("Names.txt", false);
            FileWriter fw3 = new FileWriter("pfp.txt", false);


            for (int i = 0; i < 10; i++) {
                Player temp = leaderboard.get(i);
                fw1.write(temp.score + "\n");
                fw2.write(temp.name + "\n");
                fw3.write(temp.profile + "\n");
            }
            // read each character from string and write
            // into FileWriter
            fw1.close();
            fw2.close();
            fw3.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
        class Player implements Comparable<Player> {
            String name;
            int score;
            String profile;

            public Player(String n, int s) {
                name = n;
                score = s;
            }
            
            public Player(String n, int s, String pfp) {
                name = n;
                score = s;
                profile = pfp;
            }

            @Override
            public int compareTo(Player p) {
                return this.score - p.score;
            }
            
            public int getScore() {
               return score;
            }
            
            public String getName() {
               return name;
            }
            
            public String getProfile() {
               return profile;
            }
            
            public String toString() {
        return name + ": " + score;
    }
        }

}