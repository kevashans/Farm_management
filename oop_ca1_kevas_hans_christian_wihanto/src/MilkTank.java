public class MilkTank  {
    private int capacity;
    private String name;
    private double content = 0;

    public MilkTank(String name,int capacity) {

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

    public String getName() {
        return name;
    }

    public double getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double freeSpace(){
        return this.capacity - this.content;
    }
    public void getFromtank() {
        this.content = 0;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "{" +
                "capacity=" + capacity +
                ", name='" + name + '\'' +
                ", content=" + content +
                '}';
    }
}
