public class BeefCow extends Animal{
    private double weight;
    private int age;
    private int pedigree;


    public BeefCow(String name, int id, double weight, int age, int pedigree) {
        super(name, id);
        this.weight = weight;
        this.age = age;
        this.pedigree = pedigree;
    }

    public BeefCow(double weight, int age, int pedigree) {
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

    public int getPedigree() {
        return pedigree;
    }

    public void setPedigree(int pedigree) {
        this.pedigree = pedigree;
    }

    @Override
    public void death() {

    }
}
