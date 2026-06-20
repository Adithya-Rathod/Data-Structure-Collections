package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;

import java.util.HashMap;
import java.util.Map;

@ProblemClass(difficulty = ProblemClass.Difficulty.EASY,
        topic = ProblemClass.Topic.ARRAYS,
        tags = {ProblemClass.Tag.HASHMAP, ProblemClass.Tag.MISCELLANEOUS},
        url = "https://leetcode.com/problems/two-sum/description/",
        leetCodeNumber = 1)
public class TwoSum extends AbstractSolution<Integer[]> {
    int[] nums;
    int target;
    @Override
    protected void setInput() {
        nums = readIntArr();
    }

    @Override
    public Integer[] brute() {
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j= i+1; j<n ; j++){
                if(nums[i] + nums[j] == target){
                    return new Integer[]{i, j};
                }
            }
        }
        return new Integer[]{-1,-1};
    }

    @Override
    public Integer[] optimized(){
        int n = nums.length;
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i <n ; i++){
            if(hash.containsKey(target - nums[i])){
                return new Integer[]{hash.get(target - nums[i]), i};
            }else{
                hash.put(nums[i], i);
            }
        }
        return new Integer[]{-1,-1};
    }
}
