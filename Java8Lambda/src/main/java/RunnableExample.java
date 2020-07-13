public class RunnableExample {
    public static void main(String a[]){

        // Old way Java 7
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run using java7 old way using Inner class");
            }
        });

        thread.start();

        Thread usingLembdaThread = new Thread(() -> System.out.println("run using Java8 Lembda"));
        usingLembdaThread.start();


    }
}
