//dfs

// class Solution {
//     public int regionsBySlashes(String[] grid) {
//         int n=grid.length;
//         int size=n*3;
//         int region[][]=new int[size][size];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){ 
//                 if(grid[i].charAt(j)=='/'){
//                     region[i*3][j*3+2]=1;
//                     region[i*3+1][j*3+1]=1;
//                     region[i*3+2][j*3]=1;
//                 }
//                 else if(grid[i].charAt(j)=='\\'){
//                     region[i*3][j*3]=1;
//                     region[i*3+1][j*3+1]=1;
//                     region[i*3+2][j*3+2]=1;

//                 }
//             }
//         }
//         int regions=0;
//         for(int i=0;i<size;i++){
//             for(int j=0;j<size;j++){
//                 if(region[i][j]==0){
//                     regions++;
//                     dfs(region,i,j);
//                 }
//             }
            
//         }
//         return regions;
        
//     }
//     void dfs(int [][]grid,int i,int j){
//         int n=grid.length;
//         if(i<0 || i>=n ||j<0 || j>=n || grid[i][j]!=0){
//           return;        
//         }
//           //mark ggrid visited
//             grid[i][j]=1;
//             dfs(grid,i-1,j);
//             dfs(grid,i,j-1);
//             dfs(grid,i+1,j);
//             dfs(grid,i,j+1);

//     }
// }
//union_find
class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        unionFind uf = new unionFind(4 * n * n);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                char c = grid[i].charAt(j);
                
                if (c == '/') {
                    // Connect / character regions
                    uf.union(index + 0, index + 3); // top-right
                    uf.union(index + 1, index + 2); // bottom-left
                } else if (c == '\\') {
                    // Connect \ character regions
                    uf.union(index + 0, index + 1); // top-left
                    uf.union(index + 2, index + 3); // bottom-right
                } else {
                    // Connect all regions in an empty cell
                    uf.union(index + 0, index + 1);
                    uf.union(index + 1, index + 2);
                    uf.union(index + 2, index + 3);
                }

                // Connect adjacent cells
                if (i > 0) {
                    uf.union(index + 0, (index - 4 * n) + 2);
                }
                if (j > 0) {
                    uf.union(index + 3, (index - 4) + 1);
                }
            }
        }
        
        return uf.getCount();
    }
}

class unionFind {
    private int[] parent;
    private int[] rank;
    private int count;
    
    public unionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
            count--;
        }
    }
    
    int getCount() {
        int distinctRegions = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                distinctRegions++;
            }
        }
        return distinctRegions;
    }
}
