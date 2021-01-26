package src;

public class Conference {
     
    private String name;
    private int requiredGames;
    private int size;

    public Conference (String n, int rg, int s) {
        name = n;
        requiredGames = rg;
        size = s;
    }

    public int getRequiredGames() {
        return requiredGames;
    }

    public int getSize() {
        return size;
    }

    // public ArrayList<Game> requiredGames() {

    // }

    // public ArrayList<Game> otherGames() {
        
    // }
}
