package src;

import java.util.ArrayList;

public class League {
    private int gameCount;

    private int teamCount;

    private ArrayList<Team> teamList;

    private ArrayList<Game> leagueSchedule;

    private int maxDuplicateGames;

    private int maxHomeGames;

    private int maxAwayGames;


    public League(ArrayList<Team> tl, int gc, boolean ehag) {
        teamList = tl;
        teamCount = tl.size();
        
        gameCount = gc;

        maxDuplicateGames = 0;

        if (ehag) {
            maxHomeGames = (gameCount+1)/2;
            maxAwayGames = (gameCount+1)/2;
        } else {
            maxHomeGames = 0;
            maxAwayGames = 0;
        }

        leagueSchedule = setLeagueSchedule();
    }
    
    public League(ArrayList<Team> tl, int gc, int mdg, boolean ehag) {
        teamList = tl;
        teamCount = tl.size();

        gameCount = gc;

        maxDuplicateGames = mdg;

        if (ehag) {
            maxHomeGames = gameCount/2;
            maxAwayGames = gameCount/2;
        } else {
            maxHomeGames = 0;
            maxAwayGames = 0;
        }
        
        leagueSchedule = setLeagueSchedule();
    }

    public ArrayList<Game> setLeagueSchedule() {
        ArrayList<Game> ls = new ArrayList<Game>();
        int scheduleSize = (gameCount * teamCount)/2;
        //int[] teamGamesScheduled = new int[teamCount];
        int failureCount = 0;
        
        while (ls.size() < scheduleSize) {
           int homeNum = (int) (Math.random()*teamCount);
           int awayNum = (int) (Math.random()*teamCount);

           Game g = new Game(ls.size(), teamList.get(homeNum), teamList.get(awayNum));

           boolean equalValidity = homeNum != awayNum; //Team not playing itself

           boolean homeGameCtValidity = teamList.get(homeNum).scheduleSize() != gameCount; //Home team has played under the max # of games

           boolean awayGameCtValidity = teamList.get(awayNum).scheduleSize() != gameCount; //Away team has played under the max # of games

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

            boolean homeGamesValidity = true;
            if (maxHomeGames != 0) {
                homeGamesValidity = teamList.get(homeNum).homeGamesScheduled() != maxHomeGames;
            } //The home team has played under the maximum number of home games

            boolean awayGamesValidity = true;
            if (maxAwayGames != 0) {
                awayGamesValidity = teamList.get(awayNum).awayGamesScheduled() != maxAwayGames;
            } // The away team has played under the maximum number of away games
            

           if(equalValidity && homeGameCtValidity && awayGameCtValidity && matchupCountValidity && homeGamesValidity && awayGamesValidity) {
               ls.add(g);
               teamList.get(homeNum).addToSchedule(g);
               teamList.get(awayNum).addToSchedule(g);
           } else {
               failureCount++;
           }

           if(failureCount > 100000) {
               ls = new ArrayList<Game>();
               for (int i = 0; i < teamList.size(); i++) {
                   teamList.get(i).clearSchedule();
               }
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
            System.out.println(leagueSchedule.get(i).toString());
        }
    }

}
