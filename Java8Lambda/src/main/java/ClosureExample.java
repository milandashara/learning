public class ClosureExample {

    public static void main(String args[]){
        int a = 4;
        int b = 8; // effectively final.. java will make this variable as final

        doProcess(a, num -> System.out.println(num+b));

    }

    public static void doProcess(int a, Process process){
        process.process(a);
    }


}

interface Process{
    void process(int a);
}