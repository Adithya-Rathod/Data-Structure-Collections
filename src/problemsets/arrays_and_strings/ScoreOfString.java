package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;

@ProblemClass(difficulty = ProblemClass.Difficulty.EASY, url = "https://neetcode.io/problems/score-of-a-string/question?list=allNC", topic = ProblemClass.Topic.STRINGS, tags = {ProblemClass.Tag.MISCELLANEOUS})
public class ScoreOfString extends AbstractSolution<Integer> {

    private String s;
    @Override
    protected void setInput() {
        s = readText();
    }

    @Override
    public Integer brute() {
        int res = 0;
        for(int i=1; i<s.length(); i++){
            res+= Math.abs(s.charAt(i) - s.charAt(i-1));
        }
        return res;
    }
}
