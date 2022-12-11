
import java.util.Objects;

public class BeefCow extends Animal implements NonMilkable, Comparable<NonMilkable>{
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeefCow beefCow = (BeefCow) o;
        return Double.compare(beefCow.weight, weight) == 0 && age == beefCow.age && Objects.equals(pedigree, beefCow.pedigree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, age, pedigree);
    }

    @Override
    public String toString() {
        return "BeefCow{" +"name=" + super.getName() +
                ", weight=" + weight +
                ", age=" + age +
                ", pedigree='" + pedigree + '\'' +
                '}';
    }

    //ranking weight, age, pedigree
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
