import java.util.Comparator;

public class BeefCow extends Animal implements Comparable<BeefCow>{
    private double weight;
    private int age;
    private String pedigree;


    public BeefCow(String name,  double weight, int age, String pedigree) {
        super(name);
        this.weight = weight;
        this.age = age;
        this.pedigree = pedigree;
    }

    public BeefCow(double weight, int age, String pedigree) {
        this.weight = weight;
        this.age = age;
        this.pedigree = pedigree;
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
    public int compareTo(BeefCow o) {
        int i = pedigree.compareTo(o.pedigree);
        if (i != 0) return i;

        i = Double.compare(this.weight, o.weight);
        if (i != 0) return i;

        return Integer.compare(age, o.age);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "BeefCow{" +
                "weight=" + weight +
                ", age=" + age +
                ", pedigree='" + pedigree + '\'' +
                '}';
    }
}
