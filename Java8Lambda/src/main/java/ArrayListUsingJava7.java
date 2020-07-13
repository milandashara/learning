import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListUsingJava7 {

    public static void main(String args[]){
        List<Person> personList = Arrays.asList(
                new Person("milan", 31),
                new Person("shilpa", 32),
                new Person("parth", 33),
                new Person("fatu", 34),
                new Person("yogi", 35)
        );

        //sort using Java 7 by name
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        printAll(personList);

        // print name which starts with m
        printConditionally(personList, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.name.startsWith("m");
            }
        });


    }

    private static void printConditionally(List<Person> people, Condition condition) {
        for (Person p : people) {
            if (condition.test(p)) {
                System.out.println(p);
            }

        }

    }

    private static void printAll(List<Person> people) {
        for (Person p : people) {
            System.out.println(p);
        }

    }

    interface Condition {
        boolean test(Person p);
    }

}
