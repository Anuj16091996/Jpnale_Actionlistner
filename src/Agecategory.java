public class Agecategory {
    private int id;
    private String text;

    public Agecategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
