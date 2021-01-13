package src;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Game> schedule;
    
    public Team(String n) {
        name = n;
        schedule = new ArrayList<Game>();
    }

    public String toString() {
        return name;
    }

    public boolean equals(Team t) {
        return t.toString().equals(name);
    }

    public int scheduleSize() {
        return schedule.size();
    }

    public void addToSchedule(Game g) {
        schedule.add(g);
    }

    public void clearSchedule() {
        schedule = new ArrayList<Game>();
    }

    public int homeGamesScheduled() {
        int counter = 0;
        for (int i = 0; i <= schedule.size(); i++) {
            if (schedule.get(i).getHome().equals(this)) {
                counter++;
            }
        }

        return counter;
    }

    public int awayGamesScheduled() {
        int counter = 0;
        for (int i = 0; i <= schedule.size(); i++) {
            if (schedule.get(i).getAway().equals(this)) {
                counter++;
            }
        }

        return counter; 
    }

    public void printTeamSchedule() {
        for (int i = 0; i < schedule.size(); i++) {
            if (i == 0)
                System.out.println(this.toString() + " Team Schedule:");
            System.out.println(schedule.get(i).toString());
        }
    }
}
