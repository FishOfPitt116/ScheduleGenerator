package src;

public class Conference implements Section {
     

    public Group (String n, int rg, ArrayList<Team> tl) {
        name = n;
        requiredGames = rg;
        teamList = tl;
        size = tl.size();
    }

    public ArrayList<Game> requiredGames() {

    }

    public ArrayList<Game> otherGames() {
        
    }
}
