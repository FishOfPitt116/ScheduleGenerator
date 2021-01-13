package src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Team> teamList = new ArrayList<Team>();

        for(int i = 0; i <= 3; i++) {
            teamList.add(new Team("Team " + ((Integer) i).toString(), i));
        }

        int gameCount = 6;

        int maxDuplicateGames = 2;

        boolean evenHomeAwayGames = true;

        League l = new League(teamList, gameCount, maxDuplicateGames, evenHomeAwayGames);

        l.printLeagueSchedule();

        System.out.println();
        System.out.println();

        for (int i = 0; i < teamList.size(); i++) {
            teamList.get(i).printTeamSchedule();
            System.out.println();
        }
    }
}