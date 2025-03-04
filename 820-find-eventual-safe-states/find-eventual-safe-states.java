class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
         List<Integer>  safeNodes =new ArrayList<>();
        int n=graph.length;
        int[]inDegree=new int[n];
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int node:graph[i]){
                adj.get(node).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        boolean[]safe=new boolean[n];
        while(!q.isEmpty()){
            int node =q.poll();
            safe[node]=true;
            for(int neigh:adj.get(node)){
                inDegree[neigh]--;
                if(inDegree[neigh]==0)q.add(neigh);
            }
        }
        for(int i=0;i<n;i++){
            if(safe[i]) safeNodes.add(i);
        }
       
        return safeNodes;
        
    }
}