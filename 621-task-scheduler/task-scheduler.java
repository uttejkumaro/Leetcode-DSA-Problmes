class Solution {
    public int leastInterval(char[] tasks, int n) {
        //1.cal freq count of each char 
        int count[]=new int[26];
        for(int i=0;i<tasks.length;i++){
            count[tasks[i]-'A']++;
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());//max heap 
        for(int c:count){
            if(c>0){
            pq.add(c);
            }
        }
        int intervals=0;
        while(!pq.isEmpty()){
            List<Integer>temp=new ArrayList<>();
            int time=0;
            for(int i=0;i<=n;i++){
                if(!pq.isEmpty()){
                    temp.add(pq.poll());
                    time++;
                }
            }
                for(int freq:temp){
                    if(freq-1>0){
                        pq.add(freq-1);
                    }
                }
            
            intervals+=pq.isEmpty()?time:n+1;
        }
        
        return intervals;
        
    }
}
/**Why time vs n+1?

Case 1: pq.isEmpty() (all tasks done)

Example: In the last round, suppose only 2 tasks remain.

We only need the actual number of tasks executed (time).

No need to pad with idle slots because we’re finished.

✅ Example: n=2, last cycle has just A and B.
We execute 2 tasks → only 2 intervals needed (not 3).

Case 2: !pq.isEmpty() (more tasks left)

We must assume a full cycle of n+1 intervals (tasks + possible idle).

This ensures that the next same task has waited n intervals before reuse.

Even if some slots are idle, they still count toward time.

✅ Example: n=2, still tasks left, we process A, B → that cycle costs 3 intervals (n+1). */