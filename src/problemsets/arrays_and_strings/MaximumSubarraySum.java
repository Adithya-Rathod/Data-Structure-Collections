package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;


@ProblemClass(difficulty = ProblemClass.Difficulty.EASY, topic = ProblemClass.Topic.ARRAYS, tags = {ProblemClass.Tag.TWO_POINTER, ProblemClass.Tag.SLIDING_WINDOW, ProblemClass.Tag.GREEDY})
public final class MaximumSubarraySum extends AbstractSolution<Long> {

    private long[] arr;
    @Override
    protected void setInput() {
        arr = readLongArr();
    }

    // O(n^3) , O(1)
    @Override
    public Long brute() {
        int n = arr.length;
        long maxSum = Long.MIN_VALUE;
        for(int i=0 ;i<n ;i++){
            for(int j=i ; j<n ; j++){
                long sum = 0;
                int k =i;
                while(k<n && k <= j){
                    sum+=arr[k];
                    k++;
                }
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    // O(n^2), O(1)
    @Override
    public Long better(){
        int n = arr.length;
        long maxSum = Long.MIN_VALUE;
        for(int i=0; i<n; i++){
            int start =i;
            int sum =0;
            for(int j=i; j<n; j++){
                sum+=arr[j];
                if(maxSum < sum) maxSum = sum;
            }
        }
        return maxSum;
    }

    // kadane's algorithm O(n) , O(1).
    @Override
    public Long optimized(){
        int n = arr.length;
        long maxSum = 0;
        long sum =0;
        for(int i=0 ;i <n ;i++){
            sum = Math.max(arr[i], sum+arr[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
