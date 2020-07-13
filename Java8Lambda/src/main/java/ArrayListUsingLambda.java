import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class ArrayListUsingLambda {
    public static void main(String a[]){

        List<Person> personList = Arrays.asList(
                new Person("milan", 31),
                new Person("shilpa", 32),
                new Person("parth", 33),
        new Person("fatu", 34),
        new Person("yogi", 35)
         );


        // sort by name using Java 8
        Collections.sort(personList,(p1,p2) -> p1.name.compareTo(p2.name));

        //print conditionally all
        printConditionally(personList,p -> true);
        printConditionallyUsingPredicate(personList,p -> true);
        printConditionallyUsingConsumer(personList,p -> true,p -> System.out.println(p));

        //print only milan
        printConditionally(personList,p -> p.name.equalsIgnoreCase("milan"));
        printConditionallyUsingPredicate(personList,p -> p.name.equalsIgnoreCase("milan"));
        printConditionallyUsingConsumer(personList,p -> p.name.equalsIgnoreCase("milan"),p->System.out.println(p));

        // for each usage of collection
        personList.forEach(person -> System.out.println(person));

        // stream is used to process collection of object
        // A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.
        personList.stream().filter(person -> person.name.equalsIgnoreCase("milan")).forEach(person -> System.out.println());

        // multicore processing
        personList.parallelStream().filter(person -> person.name.equalsIgnoreCase("milan")).forEach(person -> System.out.println());




    }

    public static void printConditionally(List<Person> personList, Condition condition){
        for (Person p:personList){
            if (condition.test(p)){
                System.out.println(p);
            }
        }
    }

    //java.util.Funtion has inbuild function
    public static void printConditionallyUsingPredicate(List<Person> personList, Predicate<Person> predicate){
        for (Person p:personList){
            if (predicate.test(p)){
                System.out.println(p);
            }
        }
    }
    public static void printConditionallyUsingConsumer(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer){
        for (Person p:personList){
            if (predicate.test(p)){
                consumer.accept(p);
            }
        }
    }



}
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

@FunctionalInterface
interface Condition{
    boolean test(Person person);
}