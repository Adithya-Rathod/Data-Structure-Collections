package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;
import problemsets.utils.UtilityHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ProblemClass(difficulty = ProblemClass.Difficulty.EASY,
        topic = ProblemClass.Topic.ARRAYS,
        tags = {ProblemClass.Tag.SORTING},
        url = "https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/",
        leetCodeNumber = 1752
)
public class ArrayIsSortedAndRotated extends AbstractSolution<Boolean> {

    private Integer[] nums;
    @Override
    protected void setInput() {
        nums = readIntegerArr();
    }

    @Override
    public Boolean brute() {
        int n = nums.length;
        Integer[] b = new Integer[n];
        Integer[] temp = Arrays.copyOf(nums, n);
        Arrays.sort(temp);
        for(int x = 1; x<n ;x++) {
            for (int i = 0; i < n; i++) {
                b[i] = nums[(i + x)%n];
            }

            if(Arrays.mismatch(temp, b) == -1){
                return true;
            }
        }
        return false;
    }

    @Override // finding breakpoint first
    public Boolean better(){
        int n = nums.length;
        int i =1;
        Integer[] tmp = Arrays.copyOf(nums,n);
        Arrays.sort(tmp);
        while(i<n && nums[i-1] < nums[i]) i++; // gotten i is the breakpoint
        if(i == n) return true;
        try {
            UtilityHelper.reverse(nums, 0, i - 1);
            UtilityHelper.reverse(nums, i, n - 1);
            UtilityHelper.reverse(nums, 0, n - 1);
        }catch (RuntimeException ignored){}
        for(int j=0; j<n; j++){
            if(tmp[j].equals(nums[j]))return false;
        }
        return true;
    }

}
