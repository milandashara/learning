
/*
Learn how the Java compiler and runtime infers type information about a lambda expression based on the type it is assigned to.
 */
public class TypeInferenceExample {

    public static void main(String args[]){
        printStringLength((s) -> s.length());
        printStringLength((String s) -> s.length());
        printStringLength((String s) -> s.length());
    }

    private static void printStringLength(StringInterfaceLambda stringInterfaceLambda){
        System.out.println(stringInterfaceLambda.getLength("Hello World!"));
    }

    interface StringInterfaceLambda{
        int getLength(String s);
    }
}


