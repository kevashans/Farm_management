import java.util.ArrayList;

public class Shed {
    private String id;
    private static int idCount = 0;
    private MilkingMachine milkingmachine;
    private MilkTank tank;
    private ArrayList<Animal> animals;
//    private MilkTank tank;


    public Shed(MilkingMachine milkingmachine, MilkTank tank, ArrayList<Animal> animals) {
        this.id = "shed " + idCount;
        this.milkingmachine = milkingmachine;
        this.tank = tank;
        this.milkingmachine.setMilkTank(tank);
        this.animals = animals;
        idCount++;
    }
    public Shed( ArrayList<Animal> animals) {
        this.id = "shed " +idCount;
        this.animals = animals;
        idCount++;
    }

    public Shed(MilkTank tank) {
        this.milkingmachine.setMilkTank(tank);
    }
    public void installMilkingMachine(MilkingMachine milkingMachine){
        this.milkingmachine = milkingMachine;
        this.milkingmachine.setMilkTank(this.tank)
        ;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    public Animal getAnimal(int index){
        return animals.get(index);
    }

    public void setTank(MilkTank tank) {
        this.tank = tank;
    }

    public MilkTank getMilkTank(){
        return this.tank;
    }
    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }

    public void milkAnimal(Animal animal) {
        for (int i = 0; i < this.animals.size(); i++) {
            if (animal.getId() == this.animals.get(i).getId()) {
                if (animal instanceof Milkable) {
                    this.tank.addToTank(((Milkable) animal).milk());
                }


            }
        }
    }
    public void milkAllAnimal(ArrayList<Animal>animals){
        for (int i =0; i<animals.size(); i++){
            if (animals.get(i) instanceof Milkable){
                this.tank.addToTank(((Milkable) animals.get(i)).milk());
            }
        }
    }
    public void death(Animal animal){
        animals.remove(animal);
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
