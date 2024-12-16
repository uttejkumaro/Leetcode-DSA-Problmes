class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int []>minHeap=new PriorityQueue<>((a,b)->{
            if(a[0]-b[0]!=0) return a[0]-b[0];
            return a[1]-b[1];
        });
        for(int i=0;i<nums.length;i++ ){
            minHeap.add(new int[]{nums[i],i});
        }
        while(k-->0){
            int first[]=minHeap.poll();
            int idx=first[1];
            nums[idx]*=multiplier;
            minHeap.add(new int[]{nums[idx],idx});
            

        }
        return nums;
        
    }
}