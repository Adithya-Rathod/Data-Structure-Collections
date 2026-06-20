package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;

@ProblemClass(difficulty = ProblemClass.Difficulty.MEDIUM,
topic = ProblemClass.Topic.ARRAYS, tags = {ProblemClass.Tag.TWO_POINTER})
public class LongestSubarrayWithSumK extends AbstractSolution<Integer> {
    Integer[] arr;
    int k;
    @Override
    protected void setInput() {
        arr = readIntegerArr();
        k = readInt();
    }

    @Override // O(N^2)
    public Integer brute() {
        int n = arr.length;
        int len = -1;
        for(int i=0 ;i<n; i++){
            int sum = 0;
            for(int j =i; j<n; j++) {
                sum += arr[j];
                if (sum == k && len < (j - i + 1)) {
                    len  = j - i + 1;
                }
            }
        }
        return len;
    }

    @Override // two pointers.
    public Integer better(){
        int n = arr.length;
        int len = -1;
        int sum =0;
        int l =0, r =0;
        int start=-1, end=-1;
        while(r < n){
            sum += arr[r];

            while(l <= r && sum > k) {
                sum -=arr[l];
                l++;
            }
            if(sum == k && len < (r - l + 1)){
                len = r - l + 1;
                start = l;
                end = r;
            }
            r++;
        }
        return len;
    }
}
