class Solution {
    public long continuousSubarrays(int[] nums) {
        long count=0;
        int st=0;
        int e=0;//end
        int n=nums.length;  
        PriorityQueue<Integer>minHeap=new PriorityQueue<>(
            (a,b)->nums[a]-nums[b]
        );
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(
            (a,b)->nums[b]-nums[a] );
        while(e<n){
            minHeap.add(e);
            maxHeap.add(e);
            while(st<e && nums[maxHeap.peek()]-nums[minHeap.peek()]>2){//inavlid clase and out of bounds cases
                st++;
        while(!maxHeap.isEmpty()&& maxHeap.peek()<st) maxHeap.poll();
        while(!minHeap.isEmpty()&& minHeap.peek()<st) minHeap.poll();
            }
            count+=e-st+1;
            e++;
        }
        return count;


        
    }
}