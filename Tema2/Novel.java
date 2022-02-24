public class Novel extends Book {

    String type;

    public Novel(String name, int pages, String type) {
        super(name, pages);
        this.type = type;
    }

    public String toString() {
        return super.toString() + "Tipul: " + this.type;
    }
}
