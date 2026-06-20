package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;

@ProblemClass(difficulty = ProblemClass.Difficulty.EASY,
        url = "https://neetcode.io/problems/concatenation-of-array/question?list=allNC",
        topic = ProblemClass.Topic.ARRAYS)
public class ConcatenationOfArray extends AbstractSolution<Integer[]> {

    private Integer[] nums;
    @Override
    protected void setInput() {
        nums = readIntegerArr();
    }

    @Override
    public Integer[] brute() {
        int n = nums.length;
        Integer[] ans = new Integer[2*n];
        for(int i=0; i<2*n;i++){
            if(i<n)
                ans[i] = nums[i];
            else
                ans[i] = nums[i-n];
        }

        return ans;
    }
}
