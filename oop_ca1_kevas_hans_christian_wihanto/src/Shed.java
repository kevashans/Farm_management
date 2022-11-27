import java.util.ArrayList;

public class Shed {
    private int id;
    private MilkingMachine milkingmachine;
    private MilkTank tank;
    private ArrayList animals;
//    private MilkTank tank;

    public Shed(int id, MilkingMachine milkingmachine, MilkTank tank) {
        this.id = id;
        this.milkingmachine = milkingmachine;

    }
    public Shed(MilkTank tank) {
        this.milkingmachine.setMilkTank(tank);
    }
    public void installMilkingMachine(MilkingMachine milkingMachine){
        this.milkingmachine = milkingMachine;
        this.milkingmachine.setMilkTank(this.tank)
        ;
    }
    public MilkTank getMilkTank(){
        return this.tank;
    }

    public void milkAnimal(Milkable animal){
        this.tank.addToTank(animal.milk());
    }

    @Override
    public String toString() {
        return "Shed{" +
                "id=" + id +
                ", milkingmachine=" + milkingmachine +
                ", tank=" + tank +
                '}';
    }
}
