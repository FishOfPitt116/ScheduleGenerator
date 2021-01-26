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

           boolean equalValidity = ValidityTests.equalValidity(g);

           boolean gameCtValidity = ValidityTests.gameCtValidity(g, gameCount);

           boolean matchupCtValidity = ValidityTests.matchupCtValidity(g, ls, maxDuplicateGames);

           if (g.isInConference()) {
                matchupCtValidity = ValidityTests.inConferenceMatchupCtValidity(g);
           }
           
           boolean homeGamesValidity = ValidityTests.homeGamesValidity(g, maxHomeGames);
           
           boolean awayGamesValidity = ValidityTests.awayGamesValidity(g, maxAwayGames);

           boolean homeOutOfConferenceCtValidity = ValidityTests.homeOutOfConferenceValidity(g, gameCount);

           boolean awayOutOfConferenceCtValidity = ValidityTests.awayOutOfConferenceValidity(g, gameCount);
            

           if(equalValidity && gameCtValidity && matchupCtValidity && homeGamesValidity && awayGamesValidity && homeOutOfConferenceCtValidity && awayOutOfConferenceCtValidity) {
               ls.add(g);
               teamList.get(homeNum).addToSchedule(g);
               teamList.get(awayNum).addToSchedule(g);
               failureCount = 0;
           } else {
               failureCount++;
           }

           if(failureCount > 10000000) {
               ls = new ArrayList<Game>();
               for (int i = 0; i < teamList.size(); i++) {
                   teamList.get(i).clearSchedule();
               }
               failureCount = 0;
               System.out.println("Schedule production failed. Retrying...");
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
