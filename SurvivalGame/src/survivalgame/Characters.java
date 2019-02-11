package survivalgame;

public class Characters {
    
    String name;
    int bricksPerCycle;
    int costMultiplier;
    int residentMultiplier;

    public int getResidentMultiplier() {
        return residentMultiplier;
    }

    public void setResidentMultiplier(int residentMultiplier) {
        this.residentMultiplier = residentMultiplier;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBricksPerCycle() {
        return bricksPerCycle;
    }

    public void setBricksPerCycle(int bricksPerCycle) {
        this.bricksPerCycle = bricksPerCycle;
    }

    public int getCostMultiplier() {
        return costMultiplier;
    }

    public void setCostMultiplier(int costMultiplier) {
        this.costMultiplier = costMultiplier;
    }

    public Characters(String name, int bricksPerCycle, int costMultiplier, int residentMultiplier) {
        this.name = name;
        this.bricksPerCycle = bricksPerCycle;
        this.costMultiplier = costMultiplier;
        this.residentMultiplier = residentMultiplier;
    }
    
}
