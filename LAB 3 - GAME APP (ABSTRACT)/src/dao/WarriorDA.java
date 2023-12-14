package dao;
import java.io.*;
import java.util.*;
import domain.*;

public class WarriorDA {

    private  List<Warrior> warriorList;
    private Integer killsTotal = 0;


    public List<Warrior> getWarriorList() {
        return warriorList;
    }

    public void setWarriorList(List<Warrior> warriorList) {
        this.warriorList = warriorList;
    }

    public Integer getKillsTotal() {
        return killsTotal;
    }

    public void setKillsTotal(Integer killsTotal) {
        this.killsTotal = killsTotal;
    }

    public WarriorDA(String teamID) throws FileNotFoundException {

        Scanner teamStatInfo = new Scanner(new FileReader("C:\\Users\\User\\IdeaProjects\\OOP - LAB ABSTRACT\\OOP - LAB 3 - ASBTRACT\\src\\teamStatInfo.csv"));
        warriorList = new ArrayList<>();

        while (teamStatInfo.hasNext()){

            String rowWarrior = new String ();
            rowWarrior = teamStatInfo.nextLine();
            String[] rowWarriorSpecific = new String[4];
            rowWarriorSpecific = rowWarrior.split(",");

            if(teamID.equals(rowWarriorSpecific[0])){
                switch (rowWarriorSpecific[1]) {
                    case "warrior1": warriorList.add(new Clint(rowWarriorSpecific[1], null ,Integer.parseInt(rowWarriorSpecific[2]), Integer.parseInt(rowWarriorSpecific[3]))); break;
                    case "warrior2": warriorList.add(new Miya(rowWarriorSpecific[1], null ,Integer.parseInt(rowWarriorSpecific[2]), Integer.parseInt(rowWarriorSpecific[3]))); break;
                    case "warrior3": warriorList.add(new Vexana(rowWarriorSpecific[1], null ,Integer.parseInt(rowWarriorSpecific[2]), Integer.parseInt(rowWarriorSpecific[3]))); break;
                    default: break;
                }
                killsTotal = killsTotal + Integer.parseInt(rowWarriorSpecific[3]);
            }

        }



    }

}
