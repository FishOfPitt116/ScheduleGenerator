package src;

public class Team {
    private String name;
    
    public Team(String n) {
        name = n;
    }

    public String toString() {
        return name;
    }

    public boolean equals(Team t) {
        return t.toString().equals(name);
    }
}
