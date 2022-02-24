import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainLibrary {
    static ArrayList<Book> books = new ArrayList<Book>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        ;

        boolean quit = false;
        while (!quit) {
            System.out.println("Alegeti o optiune: \n 1. Add\n 2. Delete\n 3. List\n 4. Exit");
            String input = reader.readLine();
            int intInput = Integer.parseInt(input);
            switch (intInput) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    list();
                    break;
                case 4:
                    System.out.println("4");
                    quit = true;
                    break;
                default:
                    System.out.println("Alegeti o optiune din meniu");
                    break;
            }
        }

    }

    public static void add() {
        Novel novel = new Novel("Numele", 57, "Tipul");
        books.add(novel);
        Album album1 = new Album("Numele", 60, "Calitate 1");
        books.add(album1);
    }

    public static void delete() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Alegeti o carte pentru a fi stearsa ");
        list();
        String input = reader.readLine();
        int intInput = Integer.parseInt(input);

        books.remove(intInput);
    }


    public static void list() {
        System.out.println("-----Start of list----");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + "." + books.get(i).toString());
        }
        System.out.println("-----End of list----");

    }
}
