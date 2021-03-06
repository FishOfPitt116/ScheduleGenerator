package src;

public class Game {
    // private int date;

    private Team home;
    private Team away;

    public Game(/*int gd, */Team home, Team away) {
        // date = gd;
        this.home = home;
        this.away = away;
    }

    // public int getDate() {
    //     return date;
    // }

    // public String getCalendarDate() {
    //     return "Algorithm not yet finalized";
    // }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    public String toString() {
        return "Day " + getCalendarDate() + ": " + away.toString() + " @ " + home.toString();
    }

    public boolean equals(Game g) {
        return g.getHome().equals(home) && g.getAway().equals(away);
    }

    public boolean areSameOpponents(Game g) {
        return (g.getHome().equals(home) && g.getAway().equals(away)) || (g.getHome().equals(away) && g.getAway().equals(home));
    }

    public boolean isInConference() {
        return home.getConference().equals(away.getConference());
    }
}
