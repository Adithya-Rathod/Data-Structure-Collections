package problemsets.utils;

public final class UtilityHelper {

    private UtilityHelper(){}

    public static void reverse(Integer[] nums, int start, int end) {
        int n = nums.length;
        if (start < 0 || end >= n || end < 0 || start > end) {
            throw new RuntimeException("index out of bounds!");
        }
        while (start <= end) {
            swap(nums, start++, end--);
        }
    }

    public static void swap(Integer[] nums, int a, int b){
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
}
