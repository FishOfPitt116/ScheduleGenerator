package src;

public class Group implements Section {
    
    public Group (String n, int rg, ArrayList<Team> tl, boolean ehag, boolean eml) {
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
