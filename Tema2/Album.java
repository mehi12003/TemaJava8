public class Album extends Book {

    String paperQuality;

    public Album(String name, int pages, String paperQuality) {
        super(name, pages);
        this.paperQuality = paperQuality;
    }

    public String toString() {
        return super.toString() + "Paper quality: " + this.paperQuality;

    }
}
