

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> Count = new HashMap<>();
        for (int num : nums) {
            Count.put(num, Count.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        maxHeap.addAll(Count.entrySet());
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().getKey();
        }
        
        return res;
    }
}
