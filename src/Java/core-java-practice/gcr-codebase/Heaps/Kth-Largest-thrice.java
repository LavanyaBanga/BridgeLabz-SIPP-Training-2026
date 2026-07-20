import java.util.*;

public class TopKLargest {

  
    public static List<Integer> topKLargest(int[] transactions, int k) {

       
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int amount : transactions) {

         
            if (minHeap.size() < k) {
                minHeap.offer(amount);
            }

         
            else if (amount > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(amount);
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {

        int[] transactions = {1200, 5000, 3000, 7000, 2500, 9000, 6500};
        int k = 3;

        List<Integer> result = topKLargest(transactions, k);

        System.out.println("Top " + k + " Largest Values: " + result);
    }
}
