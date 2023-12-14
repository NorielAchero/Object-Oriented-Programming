package dao;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import domain.*;

public class TeamDA {

    private ArrayList<Team> teamList;

    public ArrayList<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(ArrayList<Team> teamList) {
        this.teamList = teamList;
    }

    public TeamDA() throws FileNotFoundException {

        Scanner teamInfoCsv = new Scanner(new FileReader("C:\\Users\\User\\IdeaProjects\\OOP - LAB ABSTRACT\\OOP - LAB 3 - ASBTRACT\\src\\teamInfo.csv"));
        teamList = new ArrayList<>();
        while (teamInfoCsv.hasNext()) {

            String rowTeamInfo = new String();
            rowTeamInfo = teamInfoCsv.nextLine();

            String[] rowTeamInfoSpecific = new String[2];
            rowTeamInfoSpecific = rowTeamInfo.split(",");

            WarriorDA warriorDA = new WarriorDA(rowTeamInfoSpecific[0]);

            teamList.add(new Team(rowTeamInfoSpecific[0], rowTeamInfoSpecific[1], warriorDA.getKillsTotal(), warriorDA.getWarriorList()));

        }
    }
}