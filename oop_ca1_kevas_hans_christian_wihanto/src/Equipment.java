public abstract class Equipment {
    //helps enforce the different tanks needed for each type of milk
    private String type = null;

    public Equipment(String type) {
        this.type = type;
    }
    public Equipment() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "type='" + type + '\'' +
                '}';
    }
}
