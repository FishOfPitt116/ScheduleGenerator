public class Settings {
    private ArrayList<Team> teamList;
    private int gameCount;
    private int maxDuplicateGames;
    private int maxHomeGames;
    private int maxAwayGames;

    public Settings(ArrayList<Team> teamList, int gameCount, int maxDuplicateGames, int maxHomeGames, int maxAwayGames) {
        this.teamList = teamList;
        this.gameCount = gameCount;
        this.maxDuplicateGames = maxDuplicateGames;
        this.maxHomeGames = maxHomeGames;
        this.maxAwayGames = maxAwayGames;
    }

    public ArrayList<Team> getTeamList() {
        return teamList;
    }

    public Team getTeam(int index) {
        return teamList.get(index);
    }

    public int getLeagueSize() {
        return teamList.size();
    }

    public int getGameCount() {
        return gameCount;
    }

    public int getMaxDuplicateGames() {
        return maxDuplicateGames;
    }

    public int getMaxHomeGames() {
        return maxHomeGames;
    }

    public int getMaxAwayGames() {
        return maxAwayGames;
    }
}
