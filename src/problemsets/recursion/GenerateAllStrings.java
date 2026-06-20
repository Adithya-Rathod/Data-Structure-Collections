package problemsets.recursion;

import java.util.function.Supplier;

public final class GenerateAllStrings {
    private static void printArray(int[] arr){
        for(int x  : arr){
            System.out.print(x + " ");
        }
        System.out.println();
    }
    private static void rec(int n , int[] arr){
        if( n < 1) {
            printArray(arr);
            return;
        }
        //add 0
        arr[n-1] = 0;
        rec(n-1, arr);
        //remove 0 and other case
        arr[n-1] = 1;
        rec(n-1, arr);
    }
    public static void generateAllBinaryStrings(int n){
        rec(n, new int[n]);
//        generateAllKarryStrings(n, 2);
    }

    private static void rec2(int n , int[] arr, int k){
        if(n<1) {
            printArray(arr);
            return;
        }
        //for every k we will add it then remove it in the next iteration
        for(int i=0; i<k ;i++){
            arr[n-1] = i;
            rec2(n-1 , arr, k);
        }
    }
    public static void generateAllKarryStrings(int n , int k){
        rec2(n, new int[n], k);

    }
}
