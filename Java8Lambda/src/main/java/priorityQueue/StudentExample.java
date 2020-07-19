package priorityQueue;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hackerrank solution
 */
/*
 * Create the Student and Priorities classes here.
 */

class Student {
    private int id;
    private String name;
    double cgpa;

    Student(int id, String name, double cgpa){
        this.id= id;
        this.name= name;
        this.cgpa = cgpa;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getCgpa(){
        return this.cgpa;
    }
}

class Priorities{
    public List<Student> getStudents(List<String> events){
        List<Student> students = new ArrayList<Student>();

        PriorityQueue<Student> stdPQ = new PriorityQueue<Student>( (s1, s2) -> {
            if(s1.getCgpa() < s2.getCgpa()){
                return 1;
            }else if(s1.getCgpa() > s2.getCgpa()){
                return -1;
            }else {
                if(s1.getName().compareTo(s2.getName()) > 0){
                    return 1;
                }else if(s1.getName().compareTo(s2.getName()) < 0){
                    return -1;
                }else {
                    if(new Integer(s1.getId()).compareTo(new Integer(s2.getId())) < 0){
                        return 1;
                    }else if(new Integer(s1.getId()).compareTo(new Integer(s2.getId())) > 0){
                        return -1;
                    }else {
                        return 0;
                    }
                }
            }
        });

        for(String event:events){
            String e[] = event.split(" ");
            switch(e[0]){
                case "ENTER":
                    Student student = new Student(Integer.parseInt(e[3]),e[1],Double.parseDouble(e[2]));
                    stdPQ.add(student);
                    //System.out.println(student.getName());
                    break;
                case "SERVED":
                    if(!stdPQ.isEmpty()){
                        Student severedStudent = stdPQ.remove();
                    }

                    break;
            }


        }
        return Stream.generate(stdPQ::poll)
                .limit(stdPQ.size())
                .collect(Collectors.toList());
        // System.out.println(event);
        // return students;
    }
}


public class StudentExample {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}