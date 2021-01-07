package src;

import src.Team;

public class Game {
    private int date;

    private Team home;
    private Team away;

    public Game(int gd, Team home, Team away) {
        date = gd;
        this.home = home;
        this.away = away;
    }

    public int getDate() {
        return date;
    }

    public String getCalendarDate() {
        return "Algorithm not yet finalized";
    }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    public String getMatchup() {
        return away.toString() + " @ " + home.toString();
    }
}
