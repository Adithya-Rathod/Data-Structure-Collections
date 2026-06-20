package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;
import problemsets.utils.UtilityHelper;

@ProblemClass(difficulty = ProblemClass.Difficulty.EASY, topic = ProblemClass.Topic.ARRAYS, tags = {ProblemClass.Tag.TWO_POINTER, ProblemClass.Tag.MISCELLANEOUS}, url = "https://leetcode.com/problems/move-zeroes/", leetCodeNumber = 283)
public class MoveZeroes extends AbstractSolution<Integer[]> {

    Integer[] nums;
    @Override
    protected void setInput() {
        nums = readIntegerArr();
    }

    @Override // in place operation in O(n)
    public Integer[] brute() {
        int n = nums.length;
        int i, z = 0;
        while (z < n && nums[z] != 0) { // -> first zero;
            z++;
        }
        i = z + 1;
        while (i < n) {
            if (nums[i] != 0) { // swap the non zero ith term with the zero one.
                UtilityHelper.swap(nums, i++, z++);
            } else {
                i++; // continue till next non zero i is found.
            }
        }
        return nums;
    }
}
