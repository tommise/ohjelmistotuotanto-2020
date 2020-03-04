
package ohtu;

import java.util.ArrayList;

public class Player implements Comparable <Player> {
    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public int getPoints() {
        return goals + assists;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    @Override
    public String toString() {
        return name + " " + team + " " + nationality + " " + goals + " + " + assists + " = " + getPoints();
    }

    @Override
    public int compareTo(Player player) {
        return player.getPoints() - this.getPoints();
    }  
}