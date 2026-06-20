package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;
import problemsets.utils.UtilityHelper;

@ProblemClass(difficulty = ProblemClass.Difficulty.MEDIUM,
        topic = ProblemClass.Topic.ARRAYS,
        tags = {ProblemClass.Tag.MISCELLANEOUS},
        url = "https://leetcode.com/problems/rotate-array/",
        leetCodeNumber = 189)
public class RotateArray extends AbstractSolution<Integer[]> {

    private Integer[] nums;
    private int k;
    @Override
    protected void setInput() {
        nums = readIntegerArr();
        k = readInt();
    }

    @Override
    public Integer[] brute() {
        int n = nums.length;
        for(int i = 0; i< k; i++){
            int temp = nums[n - 1];
            for(int j =n-1; j>0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
        return nums;
    }
//    @Override // mirroring method.
//    public Integer[] better() {
//        int n = nums.length;
//        k = k % n;
//        k = n - k;
//        UtilityHelper.reverse(nums, 0, k - 1);
//        UtilityHelper.reverse(nums, k, n - 1);
//        UtilityHelper.reverse(nums, 0, n - 1);
//        return nums;
//    }
//
//    @Override // using math B[i] = A[(i+x) % n]
//    public Integer[] optimized(){
//        int n = nums.length;
//        Integer[] temp = nums.clone();
//        k = k % n;
//        k = n - k;
//        for(int i=0; i<n; i++){
//            temp[i] = nums[(i + k) % n];
//        }
//        return temp;
//    }
//

}
