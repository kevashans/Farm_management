import java.util.Comparator;

public class Sheep extends Animal implements NonMilkable, Comparable<NonMilkable>{
    private double weight;
    private int age;
    private String pedigree;

    public Sheep(String name, double weight, int age, String pedigree) {
        super(name);
        this.weight = weight;
        this.age = age;
        this.pedigree = pedigree;
    }

    public Sheep() {
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }


    public void setAge(int age) {
        if (age < 0){
            this.age = 0;
        }else{
        this.age = age;}
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }


    @Override
    public String toString() {
        return "Sheep{" +"name=" + super.getName() +
                ", weight=" + weight +
                ", age=" + age +
                ", pedigree='" + pedigree + '\'' +
                '}';
    }

    @Override
    public int compareTo(NonMilkable o) {
        int i = Double.compare(this.weight, o.getWeight());
        if (i != 0) return i;

        i = Double.compare(this.getAge(), o.getAge());
        if (i != 0) return i;

//         i = pedigree.compareTo(o.getPedigree());
//        if (i != 0) return i;



        return pedigree.compareTo(o.getPedigree());
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getPedigree() {
        return this.pedigree;
    }
}
