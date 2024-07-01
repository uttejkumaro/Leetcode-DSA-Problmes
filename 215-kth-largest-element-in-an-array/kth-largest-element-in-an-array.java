/* class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length -k];        
    }
}*/
//we can use minheap to find largest by removing less than thta largerst elemrnt
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i:nums){
            minHeap.add(i);
        
        if(minHeap.size()>k){
            minHeap.poll();
            }
        }
        return minHeap.peek();

    } 
}
