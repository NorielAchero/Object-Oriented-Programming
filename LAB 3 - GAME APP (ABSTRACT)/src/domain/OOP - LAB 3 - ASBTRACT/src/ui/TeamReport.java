package domain.OOP;
import java.io.FileNotFoundException;
import java.util.List;


public class TeamReport {

    public TeamReport() throws FileNotFoundException {
        List<domain.OOP.Team> teamList = new domain.OOP.TeamDA().getTeamList();

        System.out.println("Team Standing Report");
        System.out.println();
        for (domain.OOP.Team team:teamList) {
            System.out.println(team);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        new TeamReport();
    }
}