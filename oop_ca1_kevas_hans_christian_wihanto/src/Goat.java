import java.util.Objects;

public class Goat extends Animal implements Milkable, Comparable<Milkable>{

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
        if(udderCap < 0){
            this.udderCap =0;
        }else{
        this.udderCap = udderCap;}
    }

    @Override
    public double getUdderCapacity() {
        return this.udderCap;
    }

    @Override
    public int milk() {
        int milk = this.udderCap;
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
    public int compareTo(Milkable o) {
        if(this.udderCap < o.getUdderCapacity()){
            return -1;
        }else if(this.udderCap> o.getUdderCapacity()){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goat goat = (Goat) o;
        return udderCap == goat.udderCap;
    }

    @Override
    public int hashCode() {
        return Objects.hash(udderCap);
    }
}
