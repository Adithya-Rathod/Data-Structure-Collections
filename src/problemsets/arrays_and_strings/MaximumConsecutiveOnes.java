package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;

@ProblemClass(difficulty = ProblemClass.Difficulty.EASY, topic = ProblemClass.Topic.ARRAYS, url = "https://leetcode.com/problems/max-consecutive-ones/description/", leetCodeNumber = 485)
public class MaximumConsecutiveOnes extends AbstractSolution<Integer> {

    Integer[] nums;
    @Override
    protected void setInput() {
        nums =readIntegerArr();
    }

    @Override
    public Integer brute() {
        int res = 0;
        int cnt =0;
        for(int i=0 ; i<nums.length; i++){
            if(nums[i] != 1){
                cnt = 0;
            }else{
                cnt++;
                res = Math.max(res,cnt);
            }
        }
        return res;
    }
}
