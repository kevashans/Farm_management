import java.util.Comparator;

public class Sheep extends Animal implements Comparable<Sheep>{
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }



    @Override
    public String toString() {
        return "Sheep{" +
                "weight=" + weight +
                ", age=" + age +
                ", pedigree='" + pedigree + '\'' +
                '}';
    }

    @Override
    public int compareTo(Sheep o) {
        int i = pedigree.compareTo(o.pedigree);
        if (i != 0) return i;

        i = Double.compare(this.weight, o.weight);
        if (i != 0) return i;

        return Integer.compare(age, o.age);
    }
}
