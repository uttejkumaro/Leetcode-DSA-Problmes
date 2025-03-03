/**

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
 */
 //khans topo bfs

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int n=prerequisites.length;
        int inDegree[]=new int [numCourses];
        List<List<Integer>>graph=new ArrayList<>();//adjancy List
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int pre[]:prerequisites){
            graph.get(pre[1]).add(pre[0]);// b->a
            inDegree[pre[0]]++;
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
           count++;
            for(int neigh:graph.get(curr)){
                inDegree[neigh]--;
                if(inDegree[neigh]==0){q.add(neigh);}

            }
        }
        return count==numCourses;
    }
}