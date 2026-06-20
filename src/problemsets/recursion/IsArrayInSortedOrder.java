package problemsets.recursion;

public final class IsArrayInSortedOrder {
    public static boolean isArrayInSortedOrder(int[] arr, int n){
        if(n == 1)
            return true;
        return arr[n - 1] >= arr[n - 2] && isArrayInSortedOrder(arr, n - 1);
        // return (arr[n-1] < arr[n-2] ? false : isArrayInSortedOrder(arr, n-1);
    }
}
