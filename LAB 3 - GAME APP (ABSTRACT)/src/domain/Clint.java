package domain;

public class Clint implements Warrior{
    private String warriorCode;
    private String weapon;
    private Integer bulletsLeft;
    private Integer noOfKills;


    public Clint(String warriorCode, String weapon, Integer bulletsLeft, Integer noOfKills) {
        this.warriorCode = warriorCode;
        this.weapon = "Guns";
        this.bulletsLeft = bulletsLeft;
        this.noOfKills = noOfKills;
    }

    public String getWarriorCode() {
        return warriorCode;
    }

    public String getWeapon() {
        return weapon;
    }

    public Integer getBulletsLeft() {
        return bulletsLeft;
    }

    public Integer getNoOfKills() {
        return noOfKills;
    }

    @Override
    public String showWarriorAndKills() {
        return String.format("Clint is using " + weapon + "! has " + bulletsLeft + " bullets left and killed " + noOfKills);
    }
}
