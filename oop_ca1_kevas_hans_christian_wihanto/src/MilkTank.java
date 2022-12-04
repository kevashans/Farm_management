public class MilkTank extends Equipment {
    private int capacity;
    private String name;
    private double content = 0;

    public MilkTank(String name,int capacity,String type) {
        super(type);
        this.capacity = capacity;
        this.name = name;

    }

    public MilkTank( int capacity) {
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
        if (this.content + liters > this.capacity){
            this.content = this.capacity;
        }
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
                ", type=" + super.getType()+
                '}';
    }
}
