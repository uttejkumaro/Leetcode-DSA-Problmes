class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int [][] projects=new int [n][2];
        for(int i=0;i<n;i++){
            projects[i][0]=capital[i];
            projects[i][1]=profits[i];            
            
             }
             Arrays.sort(projects,(a,b)->a[0]-b[0]);
            // Min-heap for capital requirements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        // Max-heap for profits
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int i=0; 
      while (k > 0) {
            // Push all projects we can afford into the max-heap
            while (i < n && projects[i][0] <= w) {
                maxHeap.offer(projects[i][1]);
                i++;
            }
            // If we can't afford any project, break
            if (maxHeap.isEmpty()) break;
            // Select the project with the maximum profit
            w += maxHeap.poll();
            k--;
        }
        return w;

    }
}