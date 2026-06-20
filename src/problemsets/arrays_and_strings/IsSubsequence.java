package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;

@ProblemClass(difficulty = ProblemClass.Difficulty.EASY,
        url = "https://neetcode.io/problems/is-subsequence/question?list=allNC",
        topic = ProblemClass.Topic.STRINGS,
        tags = {ProblemClass.Tag.TWO_POINTER}
)
public class IsSubsequence extends AbstractSolution<Boolean> {
    private String s;
    private String t;
    @Override
    protected void setInput() {
        s = readText();
        t = readText();
    }

    @Override
    public Boolean brute() {
        int prev = 0;
        for(char c : s.toCharArray()){
            int curr = t.indexOf(c,prev);
            if(curr == -1) return false;
            if(curr>=prev)
                prev = curr + 1; // need to incr or else will be at the same index forever if there are multiple occurences of the same char
            else
                return false;
        }
        return true;
    }

    @Override
    public Boolean optimized(){
      int sPtr = 0;
      int tPtr =0;
      while(sPtr< s.length() && tPtr < t.length()){
          if(s.charAt(sPtr) == t.charAt(tPtr)){
              sPtr++;
          }

          tPtr++;
      }

      return sPtr == s.length();
    }
}
