public class Goat extends Animal implements Milkable{

   private int udderCap = 3;

    public Goat(String name, int id) {
        super(name, id);

    }

    public Goat() {

    }
    public int getUdderCap() {
        return udderCap;
    }

    @Override
    public void death() {

    }

    @Override
    public int milk() {
        return 0;
    }
}
