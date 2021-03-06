package src;

import java.util.ArrayList;

public class ValidityTests {

    public static boolean equalValidity(Game g) {
        return !g.getHome().equals(g.getAway());
    } // Team not playing itself

    public static boolean gameCtValidity(Game g, int gameCount) {
        return (g.getHome().scheduleSize() != gameCount) && (g.getAway().scheduleSize() != gameCount);
    } // Teams have played under the # of max games

    public static boolean matchupCtValidity(Game g, ArrayList<Game> leagueSchedule, int maxDuplicateGames) {
        int duplicationIndex = 0;
           if (maxDuplicateGames != 0) {
                for (int i = 0; i < leagueSchedule.size(); i++) {
                    if (leagueSchedule.get(i).areSameOpponents(g)) {
                        duplicationIndex++;
                    }
                    if (duplicationIndex >= maxDuplicateGames) {
                        return false;
                    }
                }
            }
            return true;
    } // Teams have not yet played the maximum allowed games against each other for the season

    public static boolean homeOutOfConferenceValidity(Game g, int gc) {
        Team t = g.getHome();
        int counter = 0;
        int limit = gc - ((t.getConference().getSize()-1) * t.getConference().getRequiredGames());
        if (t.getConference().equals(null)) {
            return true;
        }
        for (int i = 0; i < t.getSchedule().size(); i++) {
            if (t.getSchedule().get(i).isInConference()) {
                counter++;
            }
            if (counter == limit) {
                return false;
            }
        }
        return true;
    }

    public static boolean awayOutOfConferenceValidity(Game g, int gc) {
        Team t = g.getAway();
        int counter = 0;
        int limit = gc - ((t.getConference().getSize()-1) * t.getConference().getRequiredGames());
        if (t.getConference().equals(null)) {
            return true;
        }
        for (int i = 0; i < t.getSchedule().size(); i++) {
            if (t.getSchedule().get(i).isInConference()) {
                counter++;
            }
            if (counter == limit) {
                return false;
            }
        }
        return true;
    }

    public static boolean inConferenceMatchupCtValidity(Game g) {
        int maxDuplicateGames = g.getHome().getConference().getRequiredGames();
        ArrayList<Game> teamSchedule = g.getHome().getSchedule();
        int duplicationIndex = 0;
           if (maxDuplicateGames != 0) {
                for (int i = 0; i < teamSchedule.size(); i++) {
                    if (teamSchedule.get(i).areSameOpponents(g)) {
                        duplicationIndex++;
                    }
                    if (duplicationIndex >= maxDuplicateGames) {
                        return false;
                    }
                }
            }
            return true;
    } // Teams have not yet played the maximum allowed games against each other for the season, in the case the teams are in the same Conference

    public static boolean homeGamesValidity(Game g, int maxHomeGames) {
        if (maxHomeGames != 0) {
            return g.getHome().homeGamesScheduled() != maxHomeGames;
        }
        return true;
    } //The home team has played under the maximum number of home games

    public static boolean awayGamesValidity(Game g, int maxAwayGames) {
        if (maxAwayGames != 0) {
            return g.getAway().awayGamesScheduled() != maxAwayGames;
        }
        return true;
    } //The away team has played under the maximum number of away games


}
