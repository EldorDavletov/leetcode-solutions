package backtracking;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
//        System.out.println(generateParenthesis(3));
        dfs(5);


//        System.out.println(Math.log10(16)/Math.log10(4));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,"",0,0,n);
        return result;
    }

    private static void backtrack(List<String> result,String current, int open, int close, int max){
        System.out.println("enter current = "+current);
        if (current.length()==max*2){
            result.add(current);
            return;
        }
        if (open<max){
            backtrack(result,current+"(", open+1,close,max);
        }
        if (close<open){
            backtrack(result,current+")",open,close+1,max);
        }

        System.out.println("exit current = "+current);
    }

    private static void dfs(int n){
        if (n==0){
            return;
        }
        System.out.println("entering: n = "+n);
        dfs(n-1);
        System.out.println("exiting n = "+n);
    }





}
