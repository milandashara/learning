import java.util.function.BiConsumer;

/**
 * Exception handling using wrapper lambda and use of BiConsumer Function
 */
public class BiConsumerExample {

    public static void main(String args[]){
        int a[]={1,2,3,4,5};
        int key = 0;

        process(a,key, (num,k) -> {
            try {
                System.out.println(num/k);
            }catch (ArithmeticException e){
                System.out.println("ArithmeticException "+ e.getMessage());
            }
        });

        // simplified usage
        process(a,key,(num,k)->System.out.println(num/k));

    }

    public static void process(int a[], int key, BiConsumer<Integer,Integer> consumer){

        for (int num:a){
            consumer.accept(num,key);
        }
    }

    public static BiConsumer<Integer,Integer> wrapperBiConsumerLamda(BiConsumer<Integer,Integer> consumer){
        return (v,k) -> {
            try {
                System.out.println("wrapperBiConsumerLamda for exception handling");
                consumer.accept(v,k);
            }catch (ArithmeticException e){
                System.out.println("ArithmeticException "+ e.getMessage());
            }

        };
    }

}
