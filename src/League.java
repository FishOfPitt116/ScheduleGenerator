package src;

import java.util.ArrayList;

public class League {
    private int gameCount;

    private int teamCount;

    private ArrayList<Team> teamList;

    private ArrayList<Game> leagueSchedule;

    private int maxDuplicateGames;


    public League(ArrayList<Team> tl, int gc) {
        teamList = tl;
        teamCount = tl.size();
        
        gameCount = gc;

        maxDuplicateGames = 0;

        leagueSchedule = setLeagueSchedule();
    }
    
    public League(ArrayList<Team> tl, int gc, int mdg) {
        teamList = tl;
        teamCount = tl.size();

        gameCount = gc;

        maxDuplicateGames = mdg;

        leagueSchedule = setLeagueSchedule();
    }

    public ArrayList<Game> setLeagueSchedule() {
        ArrayList<Game> ls = new ArrayList<Game>();
        int scheduleSize = (gameCount * teamCount)/2;
        int gamesScheduled = 0;
        int[] teamGamesScheduled = new int[teamCount];
        int failureCount = 0;
        
        while (gamesScheduled < scheduleSize) {
           int homeNum = (int) (Math.random()*teamCount);
           int awayNum = (int) (Math.random()*teamCount);

           Game g = new Game(gamesScheduled, teamList.get(homeNum), teamList.get(awayNum));

           boolean equalValidity = homeNum != awayNum; //Team not playing itself
           boolean homeGameCtValidity = teamGamesScheduled[homeNum] != gameCount; //Home team has played under the max # of games
           boolean awayGameCtValidity = teamGamesScheduled[awayNum] != gameCount; //Away team has played under the max # of games
           boolean matchupCountValidity = true;

           int duplicationIndex = 0;
           if (maxDuplicateGames != 0) {
                for (int i = 0; i < ls.size(); i++) {
                    if (ls.get(i).areSameOpponents(g)) {
                        duplicationIndex++;
                    }
                    if (duplicationIndex >= maxDuplicateGames) {
                        matchupCountValidity = false;
                    }
                }
            }  //The teams have not yet played the maximum allowed games against each other for the season

           if(equalValidity && homeGameCtValidity && awayGameCtValidity && matchupCountValidity) {
               ls.add(g);
               teamGamesScheduled[homeNum]++;
               teamGamesScheduled[awayNum]++;
               gamesScheduled++;
           } else {
               failureCount++;
           }

           if(failureCount > 10000) {
               ls = new ArrayList<Game>();
               gamesScheduled = 0;
               teamGamesScheduled = new int[teamCount];
               failureCount = 0;
           }
        }

        return ls;

        /**
         * Conditions to check for:
         * Are the teams the same?
         * Has one team or the other been scheduled for the max number of games?
         * (Have the teams played x number of times?)
         **/
    }

    public void printLeagueSchedule() {
        for (int i = 0; i <= leagueSchedule.size() - 1; i++) {
            System.out.println("Day " + leagueSchedule.get(i).getCalendarDate() + ": " + leagueSchedule.get(i).toString());
        }
    }

}
