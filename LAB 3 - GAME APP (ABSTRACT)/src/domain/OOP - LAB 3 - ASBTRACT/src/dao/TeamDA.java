package domain.OOP;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamDA {

    private ArrayList<domain.OOP.Team> teamList;

    public ArrayList<domain.OOP.Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(ArrayList<domain.OOP.Team> teamList) {
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

            domain.OOP.WarriorDA warriorDA = new domain.OOP.WarriorDA(rowTeamInfoSpecific[0]);

            teamList.add(new domain.OOP.Team(rowTeamInfoSpecific[0], rowTeamInfoSpecific[1], warriorDA.getKillsTotal(), warriorDA.getWarriorList()));

        }

    }
}