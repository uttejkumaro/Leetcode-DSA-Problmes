class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int []{0,0,0});
        boolean visited[][] =new boolean[n][m];
        int dirs[][]={{1,0},{-1,0},{0,-1},{0,1}};
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int x=curr[0];
            int y=curr[1];
            int diff=curr[2];
            if (!visited[x][y])
            visited[x][y]=true;
            if(x==n-1  &&  y==m-1) return diff;
            for(int d[]:dirs){
                int x1=x+d[0];
                int y1=y+d[1];
                if(x1>=0 && y1>=0 && x1<n && y1<m && !visited[x1][y1]){
                    pq.add(new int[]{x1,y1,Math.max(diff,Math.abs(heights[x][y]-heights[x1][y1]))});

                }
            }

        }
        return -1;

        
    }
}