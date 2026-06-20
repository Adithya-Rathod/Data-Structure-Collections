package math;

import java.util.function.Supplier;

public final class TimeDecorator {
    //for functions which will return something
    public static <T> T measure(String name , Supplier<T> func){
        long start = System.nanoTime();
        T result = func.get();
        long end = System.nanoTime();
        System.out.println(name + " took " + (float)(end-start) + " ns");
        return result;
    }
    //for void functions
    public static void measure(String name , Runnable func){
        long start = System.nanoTime();
        func.run();
        long end = System.nanoTime();
        System.out.println(name + " took " + (float)(end-start) + " ns");
    }
}
