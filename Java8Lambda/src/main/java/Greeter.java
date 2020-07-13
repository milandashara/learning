import java.util.function.Function;

public class Greeter {

    public void greet(GreetingInterface greetingInterface){
        greetingInterface.greeting();
    }

    public static void main(String args[]){

        // Java 7 way
        GreetingInterface greetingInterface = new HelloWorldGreetingImpl();
        Greeter greeter = new Greeter();
        greeter.greet(greetingInterface);

        // Java 7 annonymus
        GreetingInterface innerClassGreeting = new GreetingInterface() {
            @Override
            public void greeting() {
                System.out.println("Inner Class Hello World");
            }
        };
        greeter.greet(innerClassGreeting);

        // Java 8 way
        GreetingInterface helloWorldGreetFuntion = () -> System.out.println("Hello World");
        greeter.greet(helloWorldGreetFuntion);




    }

    // must have exact on method.
    // Optional but recommended for declaring Lembda funtion
    @FunctionalInterface
    interface MyLambda{
        void foo();
    }
}

