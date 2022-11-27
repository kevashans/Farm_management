public class MilkTank {
    private int capacity;
    private double content;

    public MilkTank(int capacity) {
        this.capacity = capacity;
    }
    public MilkTank() {
        this.capacity = 2000;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addToTank(int liters) {
        this.content += liters;
    }
    public double freeSpace(){
        return this.capacity - this.content;
    }
    public void getFromtank() {
        this.content = 0;
    }

    @Override
    public String toString() {
        return "MilkTank{" +
                "capacity=" + capacity +
                ", content=" + content +
                '}';
    }
}
