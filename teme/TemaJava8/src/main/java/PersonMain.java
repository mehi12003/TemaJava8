
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Set;


public class PersonMain {

    public static void main(String... args) {

        // 1
        //Add the instances to a list
        System.out.println("\n1.");

        Person person1 = new Person("Mircea", 33, 177);
        Person person2 = new Person("Monica", 25, 160);
        Person person3 = new Person("Anca", 26, 162);
        Person person4 = new Person("Mutu", 35, 174);
        Person person5 = new Person("Elena", 23, 157);

        List<Person> myList = Arrays.asList(person1, person2, person3, person4, person5);

        myList.forEach(e -> System.out.println(e.toString()));


        // 2) Find the elements containing the letter "a" that start with "M" and print them out.
        System.out.println("\n2.");

        // Find elm starts with 'M' containing 'a'
        myList.stream()
                .filter(person -> person.getName().startsWith("M") & person.getName().contains("a"))
                .collect(Collectors.toList())
                .forEach(person -> System.out.println(person.getName()));


        Set<String> set = new HashSet<>();

        for (String str : set) {
            System.out.println(str);
        }


        // 3) Find the 'min' using a custom comparing criteria
        System.out.println("\n3.");

        List<Integer> myListAge = Arrays.asList(person1.getAge(),
                person2.getAge(), person3.getAge(), person4.getAge(), person5.getAge());

        Integer var = myListAge.stream().min(Integer::compare).get();

        System.out.println(var);


        // 4) Generate 5 random Strings and add them to a Set
        System.out.println("\n4.");

        HashSet<String> randomStrings = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            randomStrings.add(randomString(1 + (int) (Math.random() * 10)));
        }

        for (int i = 0; i < randomStrings.size(); i++) {
            System.out.println(Array.get(randomStrings.toArray(), i));
        }

        System.out.println("max string: " + randomStrings
                .stream()
                .max(new StringComparator())
                .get());

        // 5) Generate a random number of Integers and then count them. "Map" the exponential to the numbers and then print them out.
        System.out.println("\n5.");

        List<Integer> intList = new ArrayList<>();

        int n = 1 + (int) (Math.random() * 5);
        for (int i = 0; i < n; i++) {
            int x = (int) (Math.random() * 5);
            intList.add(x);
            System.out.println(x);
        }

        intList.stream()
                .map(Math::exp)
                .forEach(System.out::println);


        // 6) MAP K,V
        System.out.println("\n6.");

        Map<Integer, Integer> intMap = new HashMap<>();
        intMap.put(0, 2);
        intMap.put(1, 50);
        intMap.put(2, 1);
        intMap.put(3, 30);

        long count = intMap.entrySet()
                .stream()
                .filter(x -> x.getValue() > 10)
                .count();
        System.out.println("Nr elem > 10:  " + count);

        // 7) Sort the above Set<String>
        System.out.println("\n7.");

        System.out.println("list of strings sorted in reverse order: ");
        randomStrings.stream()
                .sorted(new StringComparator().reversed())
                .forEach(System.out::println);

        // 8) Sort the above List of custom objects (used for filter) in an order you consider
        System.out.println("\n8.");

        myList.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(e -> System.out.println(e.toString()));

        // 9) Check if any of your instances "match" a condition based on an Integer field (of your choice). What does it return ? Print it out.
        System.out.println("\n9.");

        myList.stream()
                .filter(e -> e.getAge() < 30)
                .forEach(e -> System.out.println(e.toString()));

        //10) What does Optional represent ? Explain through an example on your custom object
        System.out.println("\n10.");

        //Wrap an existing instance
        Optional<Person> opt = Optional.of(person1);
        System.out.println(opt);

        //Wrap an null
        Optional<Person> opt1 = Optional.ofNullable(null);
        System.out.println(opt1);

        //Check value using ifPresent or isPresent
        System.out.println("opt.isPresent() = " + opt.isPresent()
                + "\nopt1.isPresent() = " + opt1.isPresent());
        opt.ifPresent(System.out::println);
        opt1.ifPresent(System.out::println);


        //11)Fastest way to find the shortest String in a List (take the 5 random Strings generated above and find the shortest one).
        System.out.println("\n11.");

        String minstring = randomStrings.stream()
                .min(Comparator.comparing(String::length))
                .get();

        System.out.println(minstring);

    }


    /**
     * Compare strings by alphabetic order
     */
    public static class StringComparator implements Comparator<String> {


        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    static String randomString(int len) {
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt((int) Math.floor(Math.random() * AB.length())));
        return sb.toString();

    }
}

