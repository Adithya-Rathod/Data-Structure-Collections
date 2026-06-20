package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// booyer-moore voting algo
@ProblemClass(difficulty = ProblemClass.Difficulty.EASY, topic = ProblemClass.Topic.ARRAYS, tags = {ProblemClass.Tag.BOYER_MOORE_VOTING_ALGORITHM, ProblemClass.Tag.HASHMAP}, url = "https://leetcode.com/problems/majority-element/description/", leetCodeNumber = 169)
public class MajorityElement1 extends AbstractSolution<Integer> {

    int[] nums;
    @Override
    protected void setInput() {
        nums = readIntArr();
    }

    @Override
    public Integer brute(){
        int n = nums.length;
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i : nums){
            int fre = hash.getOrDefault(i, 0);
            hash.put(i, ++fre);
        }
        int target = n / 2;
        return hash.entrySet().stream().filter((kv) -> kv.getValue().equals(target)).map(Map.Entry::getKey).findFirst().orElse(0);
    }

    @Override
    public Integer optimized() {
        int n = nums.length;
        int cnt=0, ele = nums[0];
        for(int i=1; i<n; i++){
            if(ele == nums[i]){
                cnt++;
            }else{
                cnt--;
                if(cnt <= 0){
                    cnt = 1;
                    ele = nums[i];
                }
            }
        }
        return ele;
    }
}
