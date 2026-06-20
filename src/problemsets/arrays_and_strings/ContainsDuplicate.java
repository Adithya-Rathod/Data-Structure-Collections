package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;

import java.util.Arrays;
import java.util.HashSet;

@ProblemClass(difficulty = ProblemClass.Difficulty.EASY,
        url = "https://neetcode.io/problems/duplicate-integer/question?list=allNC",
        topic = ProblemClass.Topic.ARRAYS)
public class ContainsDuplicate extends AbstractSolution<Boolean> {


    private int[] nums;

    @Override
    protected void setInput() {
        nums= readIntArr();
    }


    // O(NLogN) tine and O(1) space
    @Override
    public Boolean brute() {
        int n = nums.length;
        Arrays.sort(nums);
        int i =1;
        while(i<n){
            if(nums[i-1] == nums[i]) return true;
            i++;
        }
        return false;
    }

    // O(N) Time and O(N) space
    @Override
    public Boolean better(){
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums){
            if(set.contains(i)) return true;
            else set.add(i);
        }
        return false;
    }
}
