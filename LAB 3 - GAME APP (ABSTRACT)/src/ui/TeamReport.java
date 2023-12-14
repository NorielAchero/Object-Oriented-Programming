package ui;
import domain.*;
import dao.*;
import java.io.FileNotFoundException;
import java.util.List;


public class TeamReport {

    public TeamReport() throws FileNotFoundException {
        List<Team> teamList = new TeamDA().getTeamList();

        System.out.println("Team Standing Report");
        System.out.println();
        for (Team team:teamList) {
            System.out.println(team);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        new TeamReport();
    }
}