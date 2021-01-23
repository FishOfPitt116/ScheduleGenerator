public interface Section {
    private String name;
    private int size;
    private int requiredGames;
    private ArrayList<Team> teamList;

    public ArrayList<Game> requiredGames();
    public ArrayList<Game> otherGames();
}
