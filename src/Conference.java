package src;

public class Conference {
     
    private ArrayList<Team> teamList;
    private String name;
    private int requiredGames;

    public Conference (String name, int requiredGames) {
        teamList = new ArrayList<Team>();
        this.name = name;
        this.requiredGames = requiredGames;
    }

    public void addTeam(Team t) {
        teamList.add(t);
    }

    public int getRequiredGames() {
        return requiredGames;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return teamList.size();
    }

    // public ArrayList<Game> requiredGames() {

    // }

    // public ArrayList<Game> otherGames() {
        
    // }
}
