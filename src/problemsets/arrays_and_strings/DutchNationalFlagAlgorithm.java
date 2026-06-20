package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;
import problemsets.utils.UtilityHelper;

import java.util.Arrays;


@ProblemClass(difficulty = ProblemClass.Difficulty.EASY,
        topic = ProblemClass.Topic.ARRAYS,
        tags = {ProblemClass.Tag.MISCELLANEOUS, ProblemClass.Tag.SORTING, ProblemClass.Tag.DUTCH_NATIONAL_FLAG},
        url = "https://leetcode.com/problems/sort-colors/",
        leetCodeNumber = 75)
public class DutchNationalFlagAlgorithm extends AbstractSolution<Integer[]> {

    Integer[] nums;
    @Override
    protected void setInput() {
        nums= readIntegerArr();
    }

    // sort the array O(NLogN) time and constant space;
    @Override
    public Integer[] brute() {
        Arrays.sort(nums);
        return nums;
        // count 0s 1s and 2s in one pass and paste them in nums in order :shrug:
    }

    // JUST A FUN METHOD :(0)
    @Override
    public Integer[] better(){
        int zero = 0, one = 0, two = 0;
        for(int i: nums){
            switch (i){
                case 0: zero++;break;
                case 1: one++;break;
                case 2: two++;break;
            }
        }
        int i =0, n = nums.length;
        while(i<n && zero-->0) nums[i++] = 0;
        while(i<n && one-->0) nums[i++] = 1;
        while(i<n && two-->0) nums[i++] = 2;
        return nums;
    }

    // single pass O(N) of solution with O(1) space
    @Override
    public Integer[] optimized(){
        int n = nums.length;
        int l = 0, r = n-1;
        int i = 0;
        while(i<=r){
            if(nums[i] == 2){
                UtilityHelper.swap(nums, i, r--);
            }else if(nums[i] == 0){
                UtilityHelper.swap(nums, i++, l++);
            }else{
                i++;
            }
        }
        return nums;
    }
}
