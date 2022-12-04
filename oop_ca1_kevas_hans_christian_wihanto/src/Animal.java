import java.util.Comparator;

public abstract  class Animal {
    private String name;
    private String id;


    private static int idCount = 0;

    static String[] names ={"random1","random2","random3"};
    public Animal(String name) {
        this.name = name;
        this.id ="ANMl " + idCount;
        idCount++;
    }
    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = "ANMl " + id;
    }




    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                "," + this.getClass() +
                '}';
    }



}

