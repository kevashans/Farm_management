import java.util.ArrayList;

public class Farm {
    private int id;
    private String owner;
    private ArrayList<Shed> sheds;

    private static int idCount = 0;
    public Farm(String owner, ArrayList sheds) {
        this.id =  idCount;
        this.owner = owner;
        this.sheds = sheds;
        idCount++;
    }
    public Farm() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList getSheds() {
        return sheds;
    }

    public Shed getShed(int index) {
        return sheds.get(index);
    }

    public void setSheds(ArrayList sheds) {
        this.sheds = sheds;
    }

    public void addShed(Shed shed){
        this.sheds.add(shed);
    }
    public void deleteShed(Shed shed){
        this.sheds.remove(shed);
    }
}
