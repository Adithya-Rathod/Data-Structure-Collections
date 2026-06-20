package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;

@ProblemClass(difficulty = ProblemClass.Difficulty.EASY, topic = ProblemClass.Topic.ARRAYS, tags = {ProblemClass.Tag.GREEDY}, url = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock/", leetCodeNumber = 121)
public class BestTimeToBuyAndSellStock extends AbstractSolution<Integer> {

    int[] prices;
    @Override
    protected void setInput() {
        prices = readIntArr();
    }

    @Override
    public Integer brute() {
        int res = 0;
       for(int i=0 ; i< prices.length; i++){
           for(int j=i+1; j<prices.length; j++){
               res = Math.max(res, prices[j]-prices[i]);
           }
       }
       return res;
    }

    @Override
    public Integer optimized(){
        int mini = Integer.MAX_VALUE;
        int result = 0;
        for(int price : prices){
            if(price < mini){
                mini = price;
            }else{
                result = Math.max(result, price - mini);
            }
        }
        return result;
    }
}
