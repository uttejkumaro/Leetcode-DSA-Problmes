/**Prim’s algorithm builds the MST by:

Starting from any vertex.
Repeatedly adding the smallest edge that connects a visited vertex to an unvisited one.
Growing the tree until all vertices are included.
For this problem:

Use a priority queue to always pick the smallest edge to an unvisited point.
Track visited points and accumulate the cost. */
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int m=points[0].length;
        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean vis[]=new boolean[n];
        int total=0;
        int Verti=0;
        int cost;
        for(int i=1;i<n;i++){
            cost=Math.abs(points[0][0]-points[i][0])+Math.abs(points[0][1]-points[i][1]);
            pq.offer(new int[]{cost,i});
        }
        vis[0]=true;
        Verti++;
        //build MST
        while(!pq.isEmpty() && Verti<n){
            int[]edge=pq.poll();
            cost=edge[0];
            int v=edge[1];
            if(vis[v]) continue;
            vis[v]=true;
            total+=cost;
            Verti++;
            //add edges from v to all univisted vertices
            for(int u=0;u<n;u++){
                if(!vis[u]){
                     int newCost=Math.abs(points[v][0]-points[u][0])+Math.abs(points[v][1]-points[u][1]);
                        pq.offer(new int[]{newCost,u});
                }
            }

        }
        return total;
      

    }
}