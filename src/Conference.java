package src;

public class Conference {
     
/**
 * This Conference class represents a Conference in a given league
 * for my schedule generation algorithm.
 * 
 * @author fishofpitt116
 * @version 1.0
 * @since 2-7-2021
 */
    private String name;
    private Team[] list;
    private int conferenceId;

    public Conference (String n, int sz, int id) {
        name = n;
        list = new Team[sz];
        conferenceId = id;
    }

    public Conference(String n, Team[] l, int id) {
        name = n;
        list = l;
        conferenceId = id;
    }

    /**
     * Gets the conference's name
     * @return the Conference's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the references to all Teams in the conference, particuarly in the form of an array
     * @return array with all Team references in conference
     */
    public Team[] getConf() {
        return list;
    }

    /**
     * Gets the Team reference at index i in the list of all teams in the conference
     * @return a reference to the team at index i in the list of all teams in the conference
     */
    public Team getTeam(int i) {
        return list[i];
    }

    /**
     * Adds Team t to the list of teams in the conference.
     * @return True if the team was successfully added to the conference, false otherwise.
     */
    public boolean addTeam(Team t) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                list[i] = t;
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the Conference's ID, will be determined when the program runs
     * @return conference ID
     */
    public int getId() {
        return conferenceId;
    }

    /**
     * String representation of the conferences's name, and a list of the string representation of all of the Teams in the given conference
     * @return a string representation of Conference
     */
    public String toString() {
        String result = "Conference " + name + ": ";
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                result += list[i].toString() + " ";
            }
        }
        return result;
    }
}
