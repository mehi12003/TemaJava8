public class Book {

    String name;
    int pages;

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public String toString() {
        return "name: " + this.name + "; Pages: " + this.pages;
    }
}
