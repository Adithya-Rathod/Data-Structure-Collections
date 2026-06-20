import datastructures.lists.singlyll.SinglyLL;
import datastructures.lists.singlyll.SinglyLLNode;
import problemsets.AbstractSolution;
import problemsets.ProblemClass;
import problemsets.ProblemRepository;
import problemsets.arrays_and_strings.LongestSubarrayWithSumK;
import problemsets.arrays_and_strings.MaximumSubarraySum;

import java.util.Arrays;
import java.util.function.Supplier;


public class Main {

    public static void main(String[] args) {
    }

    private static void print(Object x){
        System.out.println(format(x));
    }
    private static String format(Object x) {
        return switch (x) {
            case null -> "null";
            case int[] ints -> Arrays.toString(ints);
            case long[] longs -> Arrays.toString(longs);
            case Object[] objects -> Arrays.deepToString(objects);
            default -> x.toString();
        };
    }
}