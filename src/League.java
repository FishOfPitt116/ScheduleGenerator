package src;

import java.util.ArrayList;

public class League {
    private int gameCount;

    private int teamCount;

    private ArrayList<Team> teamList;

    private ArrayList<Game> leagueSchedule;


    public League(ArrayList<Team> tl, int gc) {
        teamList = tl;
        teamCount = tl.size();

        gameCount = gc;

        leagueSchedule = setLeagueSchedule();
    }

    public ArrayList<Game> setLeagueSchedule() {
        ArrayList<Game> ls = new ArrayList<Game>();

        int scheduleSize = (gameCount * teamCount)/2;
        int gamesScheduled = 0;
        int[] teamGamesScheduled = new int[teamCount];
        
        while (gamesScheduled < scheduleSize) {
           int homeNum = (int) (Math.random()*teamCount);
           int awayNum = (int) (Math.random()*teamCount);

           boolean equalValidity = homeNum != awayNum;
           boolean homeGameCtValidity = teamGamesScheduled[homeNum] != gameCount;
           boolean awayGameCtValidity = teamGamesScheduled[awayNum] != gameCount;

           if(equalValidity && homeGameCtValidity && awayGameCtValidity) {
               ls.add(new Game(gamesScheduled, teamList.get(homeNum), teamList.get(awayNum)));
               gamesScheduled++;
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
            System.out.println(leagueSchedule.get(i).toString());
        }
    }

}
