class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>al=new ArrayList<>();
        //int n=prerequisites.length;
        int inOrder[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            al.add(new ArrayList<>());
        }
        for(int preq[]:prerequisites){
            int u=preq[0];
            int v=preq[1];
            al.get(v).add(u);
            inOrder[u]++;
        }
        Set<Integer>st=new HashSet<>();
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inOrder[i]==0)q.add(i);
        }
        int[] res=new int[numCourses];
        int idx=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            res[idx++]=curr;
            for(int neigh:al.get(curr)){
                inOrder[neigh]--;
                if(inOrder[neigh]==0)q.add(neigh);

            }
        }
        return idx==numCourses?res:new int[]{};        
    }
}