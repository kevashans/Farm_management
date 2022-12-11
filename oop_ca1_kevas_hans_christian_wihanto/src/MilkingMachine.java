public class MilkingMachine{

    private MilkTank cowTank;
    private MilkTank goatTank;

    public MilkingMachine(MilkTank cowTank, MilkTank goatTank) {
        this.cowTank = cowTank;
        this.goatTank = goatTank;
    }

    public MilkingMachine(MilkTank cowTank) {
        this.cowTank = cowTank;

    }
    public MilkingMachine() {
    }



    public MilkTank getCowTank() {
        return cowTank;
    }

    public MilkTank getGoatTank() {
        return goatTank;
    }

    public void setCowTank(MilkTank cowTank) {
        this.cowTank = cowTank;
    }

    public void setGoatTank(MilkTank goatTank) {
        this.goatTank = goatTank;
    }

    void milk(Milkable milkable){
        if (milkable instanceof DairyCow){
            if (this.cowTank != null) {
                this.cowTank.addToTank(milkable.milk());
            } else {
                throw new IllegalStateException();
            }}
        else if (milkable instanceof Goat){
            if (this.goatTank != null) {
                this.goatTank.addToTank(milkable.milk());
            } else {
                throw new IllegalStateException();
            }
        }

    }

    @Override
    public String toString() {
        return "MilkingMachine{" +
                "cowTank=" + cowTank +
                ", goatTank=" + goatTank +
                '}';
    }
}
