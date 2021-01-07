package src;

import java.util.ArrayList;

import src.Team;

public class Main {
    public static void main(String[] args) {
        Team team0 = new Team("Team 0");
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        Team team3 = new Team("Team 3");

        ArrayList<Team> tl = new ArrayList<Team>();
        tl.add(team0);
        tl.add(team1);
        tl.add(team2);
        tl.add(team3);

        int gc = 1;

        League l = new League(tl, gc);

        l.printLeagueSchedule();
    }
}