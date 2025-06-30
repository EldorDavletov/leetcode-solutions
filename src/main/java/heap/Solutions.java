package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solutions {
    public static void main(String[] args) {

    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size()>1){
            int x = queue.poll();
            int y = queue.poll();
            if (x != y) queue.offer(Math.abs(x-y));
        }

        if (queue.isEmpty()) return 0;
        return queue.poll();
    }
}
