package src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Team> teamList = new ArrayList<Team>();

        Conference conference0 = new Conference("Atlantic", 2, 7);
        Conference conference1 = new Conference("Coastal", 2, 7);
        // for(int i = 1; i <= 4; i++) {
        //     teamList.add(new Team("Team " + ((Integer) i).toString()));
        // }
        teamList.add(new Team("Boston College"), conference0);
        teamList.add(new Team("Clemson"), conference0);
        teamList.add(new Team("Duke"), conference1);
        teamList.add(new Team("Florida State"), conference0);
        teamList.add(new Team("Georgia Tech"), conference1);
        teamList.add(new Team("Louisville"), conference0);
        teamList.add(new Team("Miami"), conference1);
        teamList.add(new Team("North Carolina"), conference1);
        teamList.add(new Team("NC State"), conference0);
        // teamList.add(new Team("Notre Dame"));
        teamList.add(new Team("Pittsburgh"), conference1);
        teamList.add(new Team("Syracuse"), conference0);
        teamList.add(new Team("Virginia"), conference1);
        teamList.add(new Team("Virginia Tech"), conference1);
        teamList.add(new Team("Wake Forest"), conference0);

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