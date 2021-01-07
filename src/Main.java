package src;

import java.util.ArrayList;

import src.Team;

public class Main {
    public static void main(String[] args) {
        Team teamLillian = new Team("Team Lillian");

        ArrayList<Team> tl = new ArrayList<Team>();

        tl.add(teamLillian);

        for(int i = 1; i <= 6; i++) {
            tl.add(new Team("Team " + ((Integer) i).toString()));
        }

        int gc = 1;

        League l = new League(tl, gc);

        l.printLeagueSchedule();
    }
}