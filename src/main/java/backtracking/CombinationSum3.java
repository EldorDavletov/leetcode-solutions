package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(9,45));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k,n,1,result,new ArrayList<>(),0);
        return result;
    }

    private static void backtrack(int k, int n, int i,List<List<Integer>> result, List<Integer> current, int sum){
        if (sum == n && current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }
        if (i > 9 || current.size() > k || sum > n){
            return;
        }
        for (int j = i; j <= 9; j++) {
            current.add(j);
            backtrack(k,n,j+1,result,current,sum+j);
            current.removeLast();
        }

    }
}
