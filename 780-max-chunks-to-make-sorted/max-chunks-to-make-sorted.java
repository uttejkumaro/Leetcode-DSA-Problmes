class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count=0,max_seen=0;
        for(int i=0;i<arr.length;i++){
            max_seen=Math.max(max_seen,arr[i]);
            if(max_seen==i) count++;

        }
        return count;
        
    }
}