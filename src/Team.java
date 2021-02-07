package src;

import java.util.ArrayList;

/**
 * This Team class represents a Team in a given league and/or conference
 * for my schedule generation algorithm.
 * 
 * @author fishofpitt116
 * @version 1.0
 * @since 2-7-2021
 */
public class Team {
    private String location;
    private String name;
    private int teamId;
    
    public Team(String l, String n, int id) {
        location = l;
        name = n;
        teamId = id;
    }

    /**
     * Gets the Team's home location
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the Team's nickname
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the Team's ID, as will be defined when the program runs
     * @return team ID
     */
    public int getId() {
        return teamId;
    }

    /**
     * String representation of the team's name; the concatenation of the home location and nickname
     * @return a string representation of Team
     */
    public String toString() {
        return location + " " + name;
    }

    /**
     * Determines whether this Team object is "equal to" some other by determining equality of ID numbers
     * @return true if the Team is the same as the t argument, false otherwise
     */
    public boolean equals(Team t) {
        return t.getId() == this.getId();
    }
}
