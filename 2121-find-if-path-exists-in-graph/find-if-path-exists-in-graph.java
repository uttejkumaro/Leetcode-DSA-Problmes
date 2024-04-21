class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] visited = new int[n];

        for(int i : visited) i = 0;

       return  bfs(n,source, destination, edges,visited);

    }


    boolean bfs(int n, int source, int destination , int[][] edges,int[] visited){
        Queue<Integer> q = new LinkedList();
        q.add(source);
        visited[source] = 1;

        while(!q.isEmpty()){
            int node = q.peek();
            if(node == destination)
                return true;
            q.remove();
            for(int[] i : edges){
                if(node == i[0] || node == i[1]){
                    int temp = (node == i[0]) ? i[1] : i[0];
                    if(visited[temp] != 1){
                            visited[temp] = 1;
                            q.add(temp);
                    }
                }
            }
        }


        return false;
    }
}