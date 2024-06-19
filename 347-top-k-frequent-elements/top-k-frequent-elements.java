/*
// 3 approaches
1.Hashmap nlogn,o(n)
2.heapify klogn
3.Bucket sort (n),o(n)

1. HashMap with Sorting
Algorithm:
Use a HashMap to count the frequency of each element.
Convert the entry set of the HashMap to a list and sort it based on the frequency values.
Extract the top K elements from the sorted list.
Time Complexity: O(n log n) (due to sorting)
Space Complexity: O(n)
*/

/* 
2.2. Min-Heap
Algorithm:
Use a HashMap to count the frequency of each element.
Use a Min-Heap to keep the top K elements based on their frequency.
If the heap size exceeds K, remove the smallest frequency element.
Extract elements from the heap.
Time Complexity: O(n log k)
Space Complexity: O(n)

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
*/
//buket sort(Stroing array with counta as index  & map.entry represents  the key and value of map
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        // Initialize buckets array with length nums.length + 1
        List<Integer> buckets[]=new List[nums.length+1];
        for(int i=0;i<=nums.length;i++){
            buckets[i]=new ArrayList<>();
        }
        for (Map.Entry<Integer,Integer>entry:map.entrySet()){
            int freq=entry.getValue();
            int num=entry.getKey();
            buckets[freq].add(num);
        }
        //  Collect top K frequent elements
        List<Integer> resultList = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && resultList.size() < k; i--) {
            if (!buckets[i].isEmpty()) {
                resultList.addAll(buckets[i]);
            }
        }
        List<Integer> topKList = resultList.subList(0, k);
        int[] resultArray = new int[k];
        for (int i = 0; i < k; i++) {
            resultArray[i] = topKList.get(i);
        }

        return resultArray;

      
    }
}

