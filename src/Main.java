package src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Team> teamList = new ArrayList<Team>();

        // for(int i = 1; i <= 4; i++) {
        //     teamList.add(new Team("Team " + ((Integer) i).toString()));
        // }
        teamList.add(new Team("Boston College"));
        teamList.add(new Team("Clemson"));
        teamList.add(new Team("Duke"));
        teamList.add(new Team("Florida State"));
        teamList.add(new Team("Georgia Tech"));
        teamList.add(new Team("Louisville"));
        teamList.add(new Team("Miami"));
        teamList.add(new Team("North Carolina"));
        teamList.add(new Team("NC State"));
        teamList.add(new Team("Notre Dame"));
        teamList.add(new Team("Pittsburgh"));
        teamList.add(new Team("Syracuse"));
        teamList.add(new Team("Virginia"));
        teamList.add(new Team("Virginia Tech"));
        teamList.add(new Team("Wake Forest"));

        int gameCount = 20;

        int maxDuplicateGames = 2;

        boolean evenHomeAwayGames = true;

        League l = new League(teamList, gameCount, maxDuplicateGames, evenHomeAwayGames);

        l.printLeagueSchedule();

        System.out.println();
        System.out.println();

        // for (int i = 0; i < teamList.size(); i++) {
        //     teamList.get(i).printTeamSchedule();
        //     System.out.println();
        // }
        teamList.get(10).printTeamSchedule();
    }
}