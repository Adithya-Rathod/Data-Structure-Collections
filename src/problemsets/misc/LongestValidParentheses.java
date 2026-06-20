package problemsets.misc;

import problemsets.AbstractSolution;
import problemsets.ProblemClass;

import java.util.Stack;

@ProblemClass(difficulty = ProblemClass.Difficulty.HARD,
        topic = ProblemClass.Topic.STACK,
        tags = {ProblemClass.Tag.MISCELLANEOUS, ProblemClass.Tag.TWO_POINTER},
        url = "https://leetcode.com/problems/longest-valid-parentheses",
        leetCodeNumber = 32)
public class LongestValidParentheses extends AbstractSolution<Integer> {

    String s;
    @Override
    protected void setInput() {
        s = readText();
    }


    // O(N^2) time and O(
    @Override
    public Integer brute() {
        Stack<Character> STACK = new Stack<>();
        char[] seq = s.toCharArray();
        int n = seq.length;
        int len, maxLen =0;
        for(int i=0;i<n; i++){
            for(int j=i; j<n ;j++){
                if(isValidParenthesis(seq, i, j, STACK)){
                    len = j - i + 1;
                    if(len > maxLen)
                        maxLen = len;
                }
            }
        }
        return maxLen;
    }

    private boolean isValidParenthesis(char[] seq, int start, int end, Stack<Character> st){
        st.clear();
        for(int i=start ; i<=end; i++){
            if(seq[i] == '('){
                st.push('(');
            }else{
                if(st.empty())
                    return false;
                st.pop();
            }
        }
        return st.empty();
    }

    // O(2N) time and O(2N) space
    @Override
    public Integer better(){
        Stack<Integer> st = new Stack<>();
        char[] seq = s.toCharArray();
        int n = seq.length;
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            if(seq[i] == '('){
                st.push(i);
            }else {
                if(!st.empty()){
                    vis[i] = true;
                    vis[st.peek()] = true;
                    st.pop();
                }
            }
        }
        int lenMax = 0;
        int currLen = 0;
        for(boolean i : vis){
            if(i){
                currLen++;
                lenMax = Math.max(lenMax, currLen);
            }else{
                currLen = 0;
            }
        }
        return lenMax;
    }

    @Override
    public Integer optimized(){
        Stack<Integer> st = new Stack<>();
        char[] seq = s.toCharArray();
        int n = seq.length;
        int maxLen = 0;
        st.push(-1); // anchor
        for(int i =0; i<n; i++){
            if(seq[i] == '(')
                st.push(i);
            else {
                st.pop();
                if(!st.empty())
                    maxLen = Math.max(maxLen, i - st.peek());
                else
                    st.push(i); // new anchor
            }
        }
        return maxLen;
    }

}
