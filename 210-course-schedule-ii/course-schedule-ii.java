class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        int idx=0;
        Set<Integer>set=new HashSet<>();
        int[] courseOrder=new int[numCourses];
        int inDegree[]=new int[numCourses];
        List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        } 
        for( int preq[]:prerequisites){
            graph.get(preq[1]).add(preq[0]);
            inDegree[preq[0]]++;

        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
            
        }
        int count=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            courseOrder[idx++] = curr;
           
            count++;
            for(int neigh:graph.get(curr)){
                inDegree[neigh]--;
                if(inDegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
       
        return count==numCourses?courseOrder:new int[]{};

        
        
    }
}