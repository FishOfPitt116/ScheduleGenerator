package src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Team> teamList = new ArrayList<Team>();

        for(int i = 0; i <= 3; i++) {
            teamList.add(new Team("Team " + ((Integer) i).toString()));
        }

        int gameCount = 6;

        int maxDuplicateGames = 2;

        League l = new League(teamList, gameCount, maxDuplicateGames);

        l.printLeagueSchedule();
    }
}