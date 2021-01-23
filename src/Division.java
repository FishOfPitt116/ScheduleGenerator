package src;

public class Division implements Section {
    

    public Division (String n, int rg, ArrayList<Team> tl) {
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
