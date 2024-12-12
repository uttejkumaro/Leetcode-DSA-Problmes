/* max heap -priority queue in reverse order
if minheapwant -same order
insetion/deletion-o(logn)
getting ele-o(n)
build heap-o(n)
*/ 

class Solution {
    public long pickGifts(int[] gifts, int k) {
        int n=gifts.length;
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:gifts){
            maxHeap.add(i);
        }
        while(k-->0){
            int curr=maxHeap.poll();
            maxHeap.add((int)Math.sqrt(curr));
        }
        //gifts[i]<=10*9
        long  sum=0;
        while(!maxHeap.isEmpty()){
            sum+=maxHeap.poll();
        }
        return sum;


        
    }
}