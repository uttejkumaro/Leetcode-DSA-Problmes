class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod=1_000_000_007;
        List<List<long []>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road:roads){
            int u=road[0];
            int v=road[1];
            int time=road[2];
            adj.get(u).add(new long[]{v,time});
            adj.get(v).add(new long[]{u,time});
        }
        long[] distTime=new long[n];
        int[] ways=new int [n];
        Arrays.fill(distTime,Long.MAX_VALUE);
        distTime[0]=0;
        ways[0]=1;
        PriorityQueue<long[]>pq=new PriorityQueue<>((a,b)->(Long.compare(a[1],b[1])));
        pq.offer(new long[]{0,0});//node,time
        while(!pq.isEmpty()){
            long[] curr=pq.poll();
            int u=(int)curr[0];
            long  timeSoFar=curr[1];
            if(timeSoFar>distTime[u]) continue;//skip
            for(long []neigh:adj.get(u)){
                int v=(int)neigh[0];
                long newTime=neigh[1]+timeSoFar;
               if(newTime<distTime[v]){
                distTime[v]=newTime;
                ways[v]=ways[u];
                 pq.offer(new long[] {v,newTime});
               }
               else if(newTime==distTime[v]) {
                ways[v]=(ways[u]+ways[v])%mod;
               }

            }

        }
        return ways[n-1];        
    }
}