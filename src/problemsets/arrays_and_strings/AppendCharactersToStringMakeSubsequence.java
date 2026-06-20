package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;

/**
 * Extension of {@link IsSubsequence} — instead of checking if t is a subsequence of s,
 * this finds how many characters need to be appended to s to make t a subsequence of it.
 */

@ProblemClass(difficulty = ProblemClass.Difficulty.MEDIUM,
                url = "https://neetcode.io/problems/append-characters-to-string-to-make-subsequence/question?list=allNC",
                topic =  ProblemClass.Topic.STRINGS,
                tags = {ProblemClass.Tag.TWO_POINTER})
public class AppendCharactersToStringMakeSubsequence extends AbstractSolution<Integer> {

    private String s;
    private String t;

    @Override
    protected void setInput() {
        s = readText();
        t = readText();
    }

    @Override
    public Integer brute() {
        int sPtr = 0;
        int tPtr = 0;
        while(sPtr < s.length() && tPtr < t.length()){
            if(s.charAt(sPtr) == t.charAt(tPtr)){
                tPtr++;
            }
            sPtr++;
        }

        return (tPtr == t.length()) ? 0 : (t.length() - tPtr);
    }
}
