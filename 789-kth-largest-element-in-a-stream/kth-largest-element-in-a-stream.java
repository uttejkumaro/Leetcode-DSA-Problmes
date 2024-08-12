class KthLargest {
    PriorityQueue<Integer>minHeap;
    int k;


    public KthLargest(int k, int[] nums) {
       this.k=k;
       minHeap= new PriorityQueue<>(k);
       for(int num:nums){
        add(num);
       }        
    }    
    public int add(int val) {
        if(minHeap.size()<k){
            minHeap.offer(val);
        }else if(val>minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
 /*
 k = 3
Initial array nums = [4, 5, 8, 2]
Operations: add(3), add(5), add(10), add(9), add(4)
Step-by-Step Dry Run:
Initialization:

k = 3
nums = [4, 5, 8, 2]
Initialize minHeap with a capacity of k:
minHeap = new PriorityQueue<>(3);
Constructor Execution:

Iterate through the initial array nums and add elements to the minHeap using the add method:
First element 4:
minHeap.size() is less than k, so add 4 to the heap:
minHeap = [4]
Second element 5:
minHeap.size() is less than k, so add 5 to the heap:
minHeap = [4, 5]
Third element 8:
minHeap.size() is less than k, so add 8 to the heap:
minHeap = [4, 5, 8]
Fourth element 2:
minHeap.size() is equal to k, compare 2 with the smallest element (4). 2 is not larger than 4, so no change.
Operations:add(3):

minHeap.size() is equal to k, compare 3 with the smallest element (4). 3 is not larger than 4, so no change.
minHeap = [4, 5, 8]
Return 4.
add(5):
minHeap.size() is equal to k, compare 5 with the smallest element (4). 5 is larger than 4, replace 4 with 5:
minHeap.poll(); // removes 4
minHeap.offer(5); // adds 5
minHeap = [5, 5, 8]
Return 5.
add(10):
minHeap.size() is equal to k, compare 10 with the smallest element (5). 10 is larger than 5, replace 5 with 10:
minHeap.poll(); // removes 5
minHeap.offer(10); // adds 10
minHeap = [5, 8, 10]
Return 5.
add(9):
minHeap.size() is equal to k, compare 9 with the smallest element (5). 9 is larger than 5, replace 5 with 9:
minHeap.poll(); // removes 5
minHeap.offer(9); // adds 9
minHeap = [8, 9, 10]
Return 8.
*/