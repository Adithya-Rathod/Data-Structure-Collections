package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sorting {

    // to suppress the def pub no args constructor, to serve only a utility class purpose :)
    private Sorting(){}

    // 2 passes replacing the immediate element if the ith > i+1th.
    // optimization for best case:
    // if the none of the elements in the inner loop are swapped we can infer that all the elements are already sorted
    public static <T extends Comparable<T>> void bubble(T[] arr){bubble(arr, false);}
    public static <T extends Comparable<T>> void bubble(T[] arr, boolean dsc){
        int n = arr.length;
        boolean swapped =true;
        for(int i=0 ; i<n && swapped;i++){
            swapped = false;
            for(int j=0; j<n-i-1; j++){
                int cmp = arr[j].compareTo(arr[j+1]);
                if(dsc ? cmp < 0 : cmp > 0){
                    swap(arr,j, j+1);
                    swapped= true;
                }
            }
        }
    }
    // selecting a minimum element and replacing it with the beginning of the list.
    public static <T extends Comparable<T>> void selection(T[] arr){selection(arr, false);}
    public static <T extends Comparable<T>> void selection(T[] arr, boolean dsc){
        int n = arr.length;
        for(int i=0; i< n;i++){
            int key = i;
            for(int j = i+1; j<n; j++){
                int cmp =arr[key].compareTo(arr[j]);
                if(dsc ? cmp<0 : cmp > 0){
                    key = j;
                }
            }
            if(key!=i){
                swap(arr, i, key);
            }
        }
    }
    // slice array into two views, sorted and unsorted, at t0 only first element is assumed to be sorted and then \
    // once u find an element which is smaller than the key then keep moving it to its correct position
    public static <T extends Comparable<T>> void insertion(T[] arr){insertion(arr, false);}
    public static <T extends Comparable<T>> void insertion(T[] arr, boolean dsc){
        int n = arr.length;
        for(int i=1 ; i<n; i++){
            T key = arr[i];
            int j = i;
            while(j>=0 && (dsc ? arr[j-1].compareTo(key) < 0 : arr[j-1].compareTo(key) > 0)) { // shift to make space for putting in the key because bro has to move back ;) comparison step
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = key; //insertion step
        }
    }

    // shell sort ( diminishing increment sort) \ extended insertion sort
    // using an increment sequence (used here is knuth's sequence h = 3*h + 1 i.e. 1, 4, 13, 40, 121, 364
    // can also use a normal n/2, n/4, n/8 gp too
    // good for smaller input size performs better than all the n square sorting algos, (n<5000)
    /*
    next_gap   = gap * 3 + 1 < n
               = gap * 3 < n - 1
               = gap < (n-1) / 3
               ≈ gap < n/3
   */
    public static <T extends Comparable<T>> void shell(T[] arr){shell(arr, false);}
    public static <T extends Comparable<T>> void shell(T[] arr, boolean dsc){
        int gap=1, n = arr.length;
        while(gap<n/3) gap=gap*3+1; // precomputing the highest the gap can go,
        boolean shouldSort = true;
        for(; gap >= 1; gap /= 3){
            for(int i=1 ; i<n; i++){
                T key = arr[i];
                int j = i;
                while(j>=gap && (dsc ? arr[j-gap].compareTo(key) < 0 : arr[j-gap].compareTo(key) > 0)) { // shift to make space for putting in the key because bro has to move back ;) comparison step
                    arr[j] = arr[j-gap];
                    j-=gap;
                }
                arr[j] = key; //insertion step
            }
        }
    }

    // classic divide and conqueer divide into smaller lists and sort them merge those sorted lists.
    public static <T extends Comparable<T>> void merge(T[] arr){
        recursiveMergeDivide(arr, 0, arr.length-1);
    }
    private static <T extends Comparable<T>> void recursiveMergeDivide(T[] arr,int left, int right){
        if(left >= right)
            return;

        int mid = (left + right)/2;

        recursiveMergeDivide(arr, left, mid);
        recursiveMergeDivide(arr, mid+1, right);
        merge(arr, left, mid, right);
    }
    private static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right){
        int l = left;
        int r = mid +1;
        List<T> temp =new ArrayList<>();
        while(l <= mid && r <= right){
            if(arr[l].compareTo(arr[r]) < 0)
                temp.add(arr[l++]);
            else
                temp.add(arr[r++]);
        }
        while(l<=mid)
            temp.add(arr[l++]);

        while(r<=right)
            temp.add(arr[r++]);

        for(T i : temp){
            arr[left++] = i;
        }
    }

    // worst case for quick sort is when already sorted and chosen pivot is last element gives, n sq complexity
    // average and best  -> O(NLogN)
    // making choosing pivot has randomized but that also might not fix n sq worst case!
    // one way to make it better is choosing median of a set of three elements chose at random from the array.
    public static <T extends Comparable<T>> void quick(T[] arr){quickSort(arr, 0, arr.length-1);}
    private static <T extends Comparable<T>> void quickSort(T[] arr, int left, int right){
        if(left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }
    private static <T extends Comparable<T>> int partition(T[] arr, int left, int right){
        int pivot = left;
        T pivotItem = arr[pivot];
        while(left <= right){
            while(arr[left].compareTo(pivotItem) <= 0) left++;
            while(arr[right].compareTo(pivotItem) > 0) right--;
            if(left < right){
                swap(arr, left, right);
            }
        }
        // found a split point, i.e. right is the final postiion for the pivot element
        arr[pivot] = arr[right];
        arr[right] = pivotItem;
        return right; // return the split point
    }

    // assumption that the range of values of the array are between 1 to K
    // O(N)
    public static void counting(int[] arr, int K){
        int[] countingArray = new int[K];
        int n =arr.length;

        // record count of each element
        for(int i=0;i<n; i++) countingArray[arr[i]]+=1;

        // making count as a linear function so every i has the count till <=i
        for(int i=1 ;i<K;i++) countingArray[i] += countingArray[i-1];

        //based on the count we can find the original position of the an element in the original array.
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[countingArray[arr[i]]-1] = arr[i];
            countingArray[arr[i]]--;
        }
        System.arraycopy(result, 0, arr, 0, n);
    }


    private static <T extends Comparable<T>> void swap(T[] arr, int a, int b){
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
