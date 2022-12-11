import java.util.ArrayList;
import java.util.Collections;

public class Shed {
    private String id;
    private static int idCount = 0;
    private MilkingMachine milkingmachine;
    private MilkTank cowTank;
    private MilkTank goatTank;
    private ArrayList<Animal> animals;
//    private MilkTank tank;


    public Shed(MilkingMachine milkingmachine, MilkTank goatTank,MilkTank cowTank, ArrayList<Animal> animals) {
        this.id = "shed " + idCount;
        this.milkingmachine = milkingmachine;
        this.goatTank = goatTank;
        this.cowTank = cowTank;
        this.milkingmachine.setCowTank(cowTank);
        this.milkingmachine.setGoatTank(goatTank);
        this.animals = animals;
        idCount++;
    }

    public Shed() {
        this.id = "shed "+idCount;
        this.animals = new ArrayList<Animal>();
        idCount++;
    }

    public Shed(ArrayList<Animal> animals) {
        this.id = "shed " +idCount;
        this.animals = animals;
        idCount++;
    }


    public Shed(MilkTank cowTank, MilkTank goatTank) {
        this.cowTank = cowTank;
        this.milkingmachine.setCowTank(cowTank);
        this.goatTank = goatTank;
        this.milkingmachine.setGoatTank(goatTank);
    }


    public void installMilkingMachine(MilkingMachine milkingMachine){
        this.milkingmachine = milkingMachine;
        //installing milking machine means conencting machine to the shed's tanks
        this.milkingmachine.setCowTank(this.getCowTank());
        this.milkingmachine.setGoatTank(this.getGoatTank());
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

    public MilkTank getCowTank() {
        return cowTank;
    }


    public void setCowTank(MilkTank cowTank) {
        this.cowTank = cowTank;

    }

    public MilkTank getGoatTank() {
        return goatTank;

    }

    public void setGoatTank(MilkTank goatTank) {
        this.goatTank = goatTank;

    }
    public ArrayList<Milkable> makeListMilkable(){
        ArrayList<Milkable> milkables = new ArrayList<>();
        for (int i = 0; i< this.animals.size();i++){
            if (this.animals.get(i) instanceof Milkable){
                milkables.add((Milkable) this.animals.get(i));
            }
        }
        return milkables;
    }
    public ArrayList<Animal> makeListNonMilkable(){
        ArrayList<Animal> nonMilkables = new ArrayList<>();
        for (int i = 0; i< this.animals.size();i++){
            if (this.animals.get(i) instanceof Milkable == false){
                nonMilkables.add(this.animals.get(i));
            }
        }
        return nonMilkables;
    }

    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }

    public void milkAnimal(Animal animal) {
        for (int i = 0; i < this.animals.size(); i++) {
            if (animal.getId() == this.animals.get(i).getId()) {
                if (animal instanceof DairyCow){
                    if (this.cowTank != null) {
                        this.cowTank.addToTank(((DairyCow) animal).milk());
                    } else {
                        throw new IllegalStateException();
                    }}
                else if (animal instanceof Goat){
                    if (this.goatTank != null) {
                        this.goatTank.addToTank(((Goat) animal).milk());
                    } else {
                        throw new IllegalStateException();
                    }
                }else{
                    System.out.println("not milkable");
                }
            }


            }
        }

    public void milkAllAnimal(){
        for (int i =0; i<animals.size(); i++){
            if (animals.get(i) instanceof DairyCow){
                if (this.cowTank != null) {
                    this.cowTank.addToTank(((DairyCow) animals.get(i)).milk());
                } else {
                    throw new IllegalStateException();
                }
            }else if (animals.get(i) instanceof Goat){
                if (this.goatTank != null) {
                    this.goatTank.addToTank(((Goat) animals.get(i)).milk());
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }
    public ArrayList<Milkable> sortMilkables(){
        ArrayList<Milkable>milkables = new ArrayList<>();
        for (int i = 0; i<animals.size();i++){
            if (animals.get(i) instanceof Milkable){
                milkables.add((Milkable) animals.get(i));
            }
        }
        Collections.sort(milkables);
        return milkables;
    }
    public ArrayList<NonMilkable> sortNonMilkables(){
        ArrayList<NonMilkable>nonMilkables = new ArrayList<>();
        for (int i = 0; i<animals.size();i++){
            if (animals.get(i) instanceof NonMilkable){
                nonMilkables.add((NonMilkable) animals.get(i));
            }
        }
        Collections.sort(nonMilkables);
        return nonMilkables;
    }

    public void death(Animal animal){
        animals.remove(animal);
    }


    @Override
    public String toString() {
        return "Shed{" +
                "id='" + id + '\'' +
                ", milkingmachine=" + milkingmachine +
                ", cowTank=" + cowTank +
                ", goatTank=" + goatTank +
                ", animals=" + animals +
                '}';
    }
}
