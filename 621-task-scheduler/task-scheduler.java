class Solution {
    public int leastInterval(char[] tasks, int n) {
        //1.cal freq count of each char 
        int count[]=new int[26];
        for(int i=0;i<tasks.length;i++){
            count[tasks[i]-'A']++;
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
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