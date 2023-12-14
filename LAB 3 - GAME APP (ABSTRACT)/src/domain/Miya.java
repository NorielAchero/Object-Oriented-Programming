package domain;

public class Miya implements Warrior{
    private String warriorCode;
    private String weapon;
    private Integer arrowsLeft;
    private Integer noOfKills;

    public Miya(String warriorCode, String weapon, Integer arrowsLeft, Integer noOfKills) {
        this.warriorCode = warriorCode;
        this.weapon = "Archery";
        this.arrowsLeft = arrowsLeft;
        this.noOfKills = noOfKills;
    }

    public String getWarriorCode() {
        return warriorCode;
    }

    public String getWeapon() {
        return weapon;
    }

    public Integer getArrowsLeft() {
        return arrowsLeft;
    }

    public Integer getNoOfKills() {
        return noOfKills;
    }

    @Override
    public String showWarriorAndKills() {
        return "Miya is using " + weapon + "! has " + arrowsLeft + " arrows left and killed " + noOfKills;
    }
}
