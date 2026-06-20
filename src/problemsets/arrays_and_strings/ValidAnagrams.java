package problemsets.arrays_and_strings;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;

import java.util.Arrays;

@ProblemClass(difficulty = ProblemClass.Difficulty.EASY,
        url = "https://neetcode.io/problems/is-subsequence/question?list=allNC",
        topic = ProblemClass.Topic.STRINGS
    )
public class ValidAnagrams extends AbstractSolution<Boolean> {


    private String s;
    private String t;
    @Override
    protected void setInput() {
        s = readText();
        t = readText();
    }

    @Override
    public Boolean brute() {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        if(arr1.length != arr2.length) return false;
        int n = arr1.length;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i=0;
        for(;i<n; i++){
            if(arr1[i] != arr2[i])return false;
        }
        return true;
    }

    @Override
    public Boolean better(){
        int[] set1 = new int[26];
        int[] set2 = new int[26];
        if(s.length() != t.length()) return false;
        int n = s.length();
        for(int i=0; i<n; i++){
            set1[s.charAt(i) - 'a']++;
            set2[t.charAt(i) - 'a']++;
        }

        for(int i=0 ;i<26;i++){
            if(set1[i] != set2[i]) return false;
        }

        return true;
    }
}
