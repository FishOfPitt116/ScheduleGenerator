package src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Team> tl = new ArrayList<Team>();

        for(int i = 0; i <= 30; i++) {
            tl.add(new Team("Team " + ((Integer) i).toString()));
        }

        int gc = 82;

        League l = new League(tl, gc);

        l.printLeagueSchedule();
    }
}