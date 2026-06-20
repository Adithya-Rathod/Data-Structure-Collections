package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;

@ProblemClass(difficulty = ProblemClass.Difficulty.EASY,
        url = "https://neetcode.io/problems/replace-elements-with-greatest-element-on-right-side/question?list=allNC",
        topic =  ProblemClass.Topic.ARRAYS,
        tags = ProblemClass.Tag.GREEDY
)
public class ReplaceElementsWithGreatestElementOnRightSide extends AbstractSolution<Integer[]> {

    private Integer[] arr;
    @Override
    protected void setInput() {
        arr= readIntegerArr();
    }

    // O(N) -> time and const space
    @Override
    public Integer[] brute() {
        int n = arr.length;
        int max = arr[n-1];
        for(int i= n-1; i>=0;i--){
            if(i == n-1) arr[i] = -1;
            else{
                if(arr[i] <= max){
                    arr[i] = max;
                }else{
                    int temp = max;
                    max = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    // O(N) -> space for result array, O(N) -> time
    @Override
    public Integer[] better(){
        int n = arr.length;
        int max = -1;
        Integer[] res = new Integer[n];
        for(int i=n-1; i>=0; i--){
            res[i] = max;
            max = Math.max(arr[i],max);
        }
        return res;
    }

    @Override
    public Integer[] optimized(){
        int n = arr.length;
        int max = -1;
        for(int i=n-1; i>=0; i--){
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp,max);
        }
        return arr;
    }
}
