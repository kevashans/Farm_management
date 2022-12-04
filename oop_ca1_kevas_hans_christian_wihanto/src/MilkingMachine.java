public class MilkingMachine extends Equipment {

    private MilkTank tank;

    public MilkingMachine(MilkTank tank,String type) {
        super(type); // goats and dairy cow needs different machine
        this.tank = tank;
    }

    public MilkTank getMilkTank() {
        return tank;
    }

    public void setMilkTank(MilkTank tank) {
        this.tank = tank;
    }

    void milk(Milkable milkable){
        if (super.getType().equals( milkable.getClass())) {
            if (this.tank != null) {
                this.tank.addToTank(milkable.milk());
            } else {
                throw new IllegalStateException();
            }
        }


    }

    @Override
    public String toString() {
        return "MilkingMachine{" +
                "tank=" + tank +
                " type=" + super.getType()+
                '}';
    }
}
