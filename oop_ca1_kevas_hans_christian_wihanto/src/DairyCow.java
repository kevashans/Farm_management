import java.util.Random;
public class DairyCow extends Animal implements Milkable, Comparable<DairyCow> {

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
        this.udderCap = 0;
        return milk;

    }

    @Override
    public void setUdderCap(int editCap) {
        if (udderCap > 40){
            this.udderCap = 40;
        }
        this.udderCap = udderCap;
    }

    @Override
    public int compareTo(DairyCow o) {
        if(this.udderCap < o.udderCap){
            return -1;
        }else if(this.udderCap> o.udderCap){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "DairyCow{" +
                " name=" + super.getName() +
                " udderCap=" + udderCap +
                '}';
    }
}
