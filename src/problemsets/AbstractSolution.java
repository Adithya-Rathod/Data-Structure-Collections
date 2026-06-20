package problemsets;

import math.TimeDecorator;
import problemsets.utils.UtilityHelper;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;

public abstract class AbstractSolution<T> implements ISolution<T> {
    // AbstractSolution.run(SubclassSolution.class) ----> this method is only exposed outside.
    public static <T> void run(Class<? extends AbstractSolution<T>> clazz){
        try{
            clazz.getDeclaredConstructor().newInstance().run();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    // everything below this is inaccessible to outside world. :)
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";
    private final String PROBLEM_NAME = this.getClass().getSimpleName();
    private String rawInput;
    private PrintWriter out;
    protected Scanner SCANNER;
    protected abstract void setInput();

    protected final void run(){
        try (FileInputStream fis = new FileInputStream(INPUT_FILE);
             PrintWriter pw = new PrintWriter((new FileWriter(OUTPUT_FILE)))) {
            rawInput = new String(fis.readAllBytes());
            this.out = pw;
            runApproach("brute", this::brute);
            runApproach("better", this::better);
            runApproach("optimized", this::optimized);
        } catch (IOException e) {
            if(e instanceof FileNotFoundException)
                System.err.println("file not found..." + e.getMessage());
            else
                System.err.println("i/o exception..." + e.getMessage());
        }
    }

    private void runApproach(String label, Supplier<T> approach) {
        try {
            SCANNER = new Scanner(rawInput);
            setInput();
            if (approach.get() instanceof Runnable) { // use this for void return types
                TimeDecorator.measure(PROBLEM_NAME + " [" + label + "]", (Runnable) approach.get());
            } else {
                T x = TimeDecorator.measure(PROBLEM_NAME + " [" + label + "]", approach);
                print(x);
            }
        } catch (UnsupportedOperationException ignored) {
        }
    }

    protected final void print(Object x){
        out.println(format(x));
    }

    private String format(Object x) {
        return switch (x) {
            case null -> "null";
            case int[] ints -> Arrays.toString(ints);
            case long[] longs -> Arrays.toString(longs);
            case Object[] objects -> Arrays.deepToString(objects);
            default -> x.toString();
        };
    }

    // helper for setting inputs
    protected final int readInt(){ return SCANNER.nextInt();}
    protected final long readLong(){return SCANNER.nextLong();}
    protected final long[] readLongArr(){
        int n = SCANNER.nextInt();
        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            arr[i] = SCANNER.nextLong();
        }
        return arr;
    }
    protected final int[] readIntArr(){
        int n = SCANNER.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = SCANNER.nextInt();
        }
        return arr;
    }
    protected final Integer[] readIntegerArr(){
        int n = SCANNER.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++){
            arr[i] = SCANNER.nextInt();
        }
        return arr;
    }
    protected final String readText(){
        return SCANNER.nextLine();
    }
    protected final int[][] readMatrix(){
        int n = SCANNER.nextInt(), m = SCANNER.nextInt();
        int[][] mat = new int[n][m];
        for(int i=0 ;i <n ;i++)
            for(int j=0; j<m; j++)
                mat[i][j] = SCANNER.nextInt();

        return mat;
    }
}
