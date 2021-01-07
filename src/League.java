package src;

import java.util.ArrayList;

import src.Schedule;
import src.Team;

public class League {
    private int gameCount;

    private int teamCount;
    private ArrayList<Conference> conferenceList;
    private ArrayList<Division> divisionList;

    private ArrayList<Team> teamList;


    public League(ArrayList<Conference> cl, ArrayList<Division> dl, ArrayList<Team> tl, int gc) {
        conferenceList = cl;
        divisionList = dl;
        teamList = tl;
        teamCount = tl.size();

        gameCount = gc;
    }

    public void setLeagueSchedule() {

    }

}
