package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] topK = topKFrequent(nums, k);
        System.out.print("Top " + k + " frequent elements: ");
        for (int num : topK) {
            System.out.print(num + " ");
        }
    }

    /**
     * This method finds the k most frequent elements in the given array.
     * The algorithm works as below:
     * 1. Create a frequency map to count occurrences of each element.
     * 2. Use a min-heap (priority queue) to keep track of the top k elements based on their frequency.
     * 3. Iterate through the frequency map and maintain the size of the heap to be at most k.
     * 4. Extract the elements from the heap to get the k most frequent elements.
     * 
     * @param nums
     * @param k
     * @return
     */
    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] topK = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            topK[i] = minHeap.poll().getKey();
        }
        return topK;
    }
}
