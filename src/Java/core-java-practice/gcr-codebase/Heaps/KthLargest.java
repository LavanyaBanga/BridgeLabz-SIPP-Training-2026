import java.util.PriorityQueue;

public class KthLargest {
    public static int findKthLargest(int[] scores, int k) {

     
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int score : scores) {

          
            if (minHeap.size() < k) {
                minHeap.offer(score);
            }

           
            else if (score > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(score);
            }
        }

      
        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] scores = {85, 92, 78, 96, 88, 91, 75};
        int k = 3;

        int result = findKthLargest(scores, k);

        System.out.println("The " + k + "rd largest score is: " + result);
    }
}
