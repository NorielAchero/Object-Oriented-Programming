package domain;


public class Vexana implements Warrior{
    private String warriorCode;
    private String weapon;
    private Integer bombsLeft;
    private Integer noOfKills;

    public Vexana(String warriorCode, String weapon, Integer bombsLeft, Integer noOfKills) {
        this.warriorCode = warriorCode;
        this.weapon = "bombs";
        this.bombsLeft = bombsLeft;
        this.noOfKills = noOfKills;
    }

    public String getWarriorCode() {
        return warriorCode;
    }

    public String getWeapon() {
        return weapon;
    }

    public Integer getBombsLeft() {
        return bombsLeft;
    }

    public Integer getNoOfKills() {
        return noOfKills;
    }

    @Override
    public String showWarriorAndKills() {
        return "Vexana is using " + weapon + "! has " + bombsLeft + " bombs left and killed " + noOfKills;
    }
}
