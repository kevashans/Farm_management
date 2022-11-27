import java.util.ArrayList;

public class Farm {
    private int id;
    private String owner;
    private ArrayList<Shed> sheds;

    public Farm(int id, String owner, ArrayList sheds) {
        this.id = id;
        this.owner = owner;
        this.sheds = sheds;
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

    public void setSheds(ArrayList sheds) {
        this.sheds = sheds;
    }
}
