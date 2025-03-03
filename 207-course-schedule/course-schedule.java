class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        List<List<Integer>>graph=new ArrayList<>();//adjancy List
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int pre[]:prerequisites){
            graph.get(pre[1]).add(pre[0]);// b->a
        }
        boolean vis[]=new boolean[numCourses];
        boolean path[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(hasCycle(graph,i, vis,path)){
                        return false;
                }                
            }
        }
        return true;    
        
    }
    boolean hasCycle(List<List<Integer>>graph,int node,boolean vis[],boolean path[]){
        vis[node]=true;
        path[node]=true;
        for(int neigh:graph.get(node)){
            if(!vis[neigh]){
                if(hasCycle(graph, neigh, vis,path)){
                    return true;
                }

            }
            else if(path[neigh]){
                return true;
                }
        }
        path[node]=false;
        return false;


    }
}