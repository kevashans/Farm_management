import java.util.Random;
public class DairyCow extends Animal implements Milkable {

    private int udderCap;
   private Random rand = new Random();
   private String[] names ={"random1","random2","random3"};
//    public DairyCow(int udderCap) {
//        this.udderCap = udderCap;
//    }
//


    public DairyCow(String name, int id) {
        super(name, id);


       this.udderCap = rand.nextInt(20,40);
    }

    public DairyCow() {
        int num = rand.nextInt(names.length);
        this.setName(names[num]);

    }
    public int getUdderCap() {
        return udderCap;
    }


    @Override
    public void death() {

    }

    @Override
    public int milk() {
        int milk = this.udderCap;
        this.udderCap = 0;
        return milk;

    }
}
