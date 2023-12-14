package domain;
import java.util.*;

public class Team {
    private String teamID;
    private String teamName;
    private Integer totalKills;
    private List<Warrior> warriorList;

    public Team(String teamID, String teamName, Integer totalKills, List<Warrior> warriorList) {
        this.teamID = teamID;
        this.teamName = teamName;
        this.totalKills = totalKills;
        this.warriorList = warriorList;
    }


    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTotalKills(Integer totalKills) {
        this.totalKills = totalKills;
    }

    public void setWarriorList(List<Warrior> warriorList) {
        this.warriorList = warriorList;
    }

    @Override
    public String toString() {
        String printer = "";

        printer += "Team ID: " + this.teamID + "\n";
        printer += "Team Name:" + this.teamName + "\n";
        printer += "Total Kill: " + this.totalKills + "\n";

        for (Warrior warrior : warriorList) {
            printer += "\t" + warrior.showWarriorAndKills() + "\n";
        }
        return printer;
    }
}


