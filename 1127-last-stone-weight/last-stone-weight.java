class Solution {
    public int lastStoneWeight(int[] stones) {
      PriorityQueue<Integer>maxHeap=new PriorityQueue<>();
      for(int stone:stones){
        maxHeap.add(-stone);
      }
      while(maxHeap.size()>1){
        int max1=maxHeap.remove();
        int max2=maxHeap.remove();
        if (max1!=max2){
            maxHeap.add(max1-max2);
        }
      }
      return maxHeap.size()!=0?(-maxHeap.remove()):0;
        
    }
}