public class MilkingMachine {
    private MilkTank tank;

    public MilkingMachine(MilkTank tank) {
        this.tank = tank;
    }

    public MilkTank getMilkTank() {
        return tank;
    }

    public void setMilkTank(MilkTank tank) {
        this.tank = tank;
    }

    void milk(Milkable milkable){
        this.tank.addToTank(milkable.milk());
    }
}
