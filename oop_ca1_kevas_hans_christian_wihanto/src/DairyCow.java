import java.util.Objects;
import java.util.Random;
public class DairyCow extends Animal implements Milkable, Comparable<Milkable> {

    private int udderCap;
//   private Random rand = new Random();
//   private String[] names ={"random1","random2","random3"};
//    public DairyCow(int udderCap) {
//        this.udderCap = udderCap;
//    }
//


    public DairyCow(String name) {
        super(name);
       this.udderCap = Utility.getRandom(20,40);
    }

    public DairyCow() {
        int num = Utility.getRandom(0,Animal.names.length);
        this.setName(Animal.names[num]);

    }
    public int getUdderCap() {
        return udderCap;
    }




    @Override
    public int milk() {
        int milk = this.udderCap;
        return milk;

    }

    @Override
    public void setUdderCap(int editCap) {
        if (editCap > 40){
            this.udderCap = 40;
        }else if(editCap <0){
            this.udderCap =0;
        }else{
        this.udderCap = editCap;}
    }


    @Override
    public double getUdderCapacity() {
        return this.udderCap;
    }

    @Override
    public int compareTo(Milkable o) {
        if(this.udderCap < o.getUdderCapacity() ){
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
        DairyCow dairyCow = (DairyCow) o;
        return udderCap == dairyCow.udderCap;
    }

    @Override
    public int hashCode() {
        return Objects.hash(udderCap);
    }

    @Override
    public String toString() {
        return "DairyCow{" +
                " name=" + super.getName() +
                " udderCap=" + udderCap +
                '}';
    }
}
