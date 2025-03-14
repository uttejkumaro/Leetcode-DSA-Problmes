/**
// Prim’s algorithm builds the MST by:

// Starting from any vertex.
// Repeatedly adding the smallest edge that connects a visited vertex to an unvisited one.
// Growing the tree until all vertices are included.
// For this problem:

// Use a priority queue to always pick the smallest edge to an unvisited point.
// Track visited points and accumulate the cost. 

// Time Complexity
// O (ELogE)   
// Spaca O (E) 
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int m=points[0].length;
        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);//store cost,node value
        
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
 */
//  Kruskal’s Algorithm
// Intuition
// Kruskal’s algorithm builds the MST by:

// Considering all possible edges.
// Sorting them by weight (smallest first).
// Adding edges to the MST if they connect two disconnected components, using a Union-Find data structure to detect cycles.
// For this problem:

// Generate all edges (pairs of points) and their Manhattan distances.
// Sort edges by cost.
// Use Union-Find to union points, adding edge weights until all points are connected.
/**
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int []>edges=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cost=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{i,j,cost});
            }
        }
        edges.sort((a,b)->a[2]-b[2]);
        //union find intliasation
        int []parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        //mst build
        int totalCost=0;
        int edgesUsed=0;
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int cost=edge[2];
            if(find(parent,u)!=find(parent,v)){
                union(parent,u,v);
                totalCost+=cost;
                edgesUsed++;
                if(edgesUsed==n-1)break;
            }
        }
        return totalCost;
    }
    //union find
    int find(int parent[],int u){
        if(parent[u]!=u){
            parent[u]=find(parent,parent[u]);
        }
        return parent[u];

    }
    void union(int parent[],int u,int v){
        parent[find(parent,u)]=find(parent,v);
        
    }
}

//  */
//  class Solution {

//     class DSU {
//         int[] parent;
//         int[] rank;
//         int n;

//         public DSU(int n) {
//             this.n = n;
//             this.parent = new int[n];
//             this.rank = new int[n];
//             for (int node = 0; node < n; node++) {
//                 this.parent[node] = node;
//                 this.rank[node] = 1;
//             }
//         }

//         public int find(int node) {
//             if (parent[node] == node) {
//                 return node;
//             }

//             int parentLevelComponent = find(parent[node]);
//             // Path compression
//             parent[node] = parentLevelComponent;
//             return parentLevelComponent;
//         }

//         public void union(int node1, int node2) {
//             int parentOfNode1 = find(node1);
//             int parentOfNode2 = find(node2);
             
//             if (parentOfNode1 == parentOfNode2) return;

//             if (rank[parentOfNode1] > rank[parentOfNode2]) {
//                  parent[parentOfNode2] = parentOfNode1;
//                  rank[parentOfNode1] += rank[parentOfNode2];
//             } else {
//                 parent[parentOfNode1] = parentOfNode2;
//                 rank[parentOfNode2] += rank[parentOfNode1];
//             }


//         }
//     }

//     class Edge {
//         int source;
//         int destination;
//         int weight;

//         public Edge (int source, int destination, int weight) {
//             this.source = source;
//             this.destination = destination;
//             this.weight = weight;
//         }
//     }

//     public int minCostConnectPoints(int[][] points) {
//         int n = points.length;
//         List<Edge> edges = new ArrayList<>();

//         for (int point1 = 0; point1 < n; point1++) {
//             for (int point2 = point1 + 1; point2 < n; point2++) {
//                 int xDiff = Math.abs(points[point1][0] - points[point2][0]);
//                 int yDiff = Math.abs(points[point1][1] - points[point2][1]);
//                 int currDistance = xDiff + yDiff;
//                 edges.add(new Edge(point1, point2, currDistance));
//             }
//         }

//         Collections.sort(edges, (obj1, obj2) -> obj1.weight-obj2.weight);

//         DSU dsu = new DSU(n);
//         int remainingEdges = n - 1;
//         int mstCost = 0;


//         for (Edge edge: edges) {
//             // System.out.println(edge.weight);

//             int parentOfA = dsu.find(edge.source);
//             int parentOfB = dsu.find(edge.destination);

//             if (parentOfA == parentOfB) continue;
//             // System.out.println("Adding: " + edge.source + " --> " + edge.destination);
//             mstCost += edge.weight;
//             dsu.union(edge.source, edge.destination);
//             remainingEdges--;
//             if (remainingEdges == 0)    break;

//         }

//         return mstCost;
//     }
// }
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int m=points[0].length;
        int minCost=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean vis[]=new boolean[n];
        int vertices=0;        
      
        for(int i=1;i<n;i++){
            int cost=Math.abs( points[0][0]- points[i][0])+Math.abs( points[0][1]- points[i][1]);
            pq.add(new int []{cost,i});           
        }
          vis[0]=true;
        while(!pq.isEmpty() && vertices<n){
            int []curr=pq.poll();
            int cos=curr[0];
            int node=curr[1];
            if(vis[node]) continue;
            vis[node]=true;
            minCost+=cos;
            vertices++;
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    int newCost=Math.abs( points[i][0]- points[node][0])+Math.abs( points[i][1]- points[node][1]);
                    pq.offer(new int[]{newCost,i});
                }
            }
            
        }
        return minCost;
    }
}

