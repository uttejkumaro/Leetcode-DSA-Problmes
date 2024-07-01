/* class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length -k];        
    }
}*/
//we can use minheap to find largest by removing less than thta largerst elemrnt

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : nums) {
            minHeap.add(i);
             // Print the entire minHeap
        //System.out.println("Contents of the minHeap:");
        //for (int num : minHeap) {
           // System.out.println(num);
        //}
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
       

        return minHeap.peek();
    }
    /*

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = sol.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }
    */
}
