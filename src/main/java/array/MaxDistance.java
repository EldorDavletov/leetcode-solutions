package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDistance {
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1,5));
        arrays.add(Arrays.asList(3,4));

        System.out.println(maxDistance(arrays));
    }

    public static int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.getFirst().getFirst();
        int max = arrays.getFirst().getLast();
        int result = 0;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int first = array.getFirst();
            int last = array.getLast();

            result = Math.max(result, Math.max(Math.abs(first - max), Math.abs(last - min)));

            min = Math.min(min, first);
            max = Math.max(max, last);
        }
        return result;
    }
}
