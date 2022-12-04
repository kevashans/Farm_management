public class Goat extends Animal implements Milkable, Comparable<Goat>{

   private int udderCap = 3;

    public Goat(String name) {
        super(name);

    }

    public Goat() {

    }
    public int getUdderCap() {
        return udderCap;
    }

    @Override
    public void setUdderCap(int udderCap) {
        this.udderCap = udderCap;
    }

    @Override
    public int milk() {
        int milk = this.udderCap;
        this.udderCap = 0;
        return milk;

    }



    @Override
    public String toString() {
        return "Goat{" +
                " name=" + super.getName() +
                "udderCap=" + udderCap +
                '}';
    }

    @Override
    public int compareTo(Goat o) {
        if(this.udderCap < o.udderCap){
            return -1;
        }else if(this.udderCap> o.udderCap){
            return 1;
        }
        return 0;
    }
}
