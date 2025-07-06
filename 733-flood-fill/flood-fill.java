class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor=image[sr][sc];
        if(originalColor==color)return image;
        bfs(image,sr,sc,color,originalColor);
        return image;
    }
        void bfs(int[][] image, int sr, int sc, int color,int originalColor){
        int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
        int n=image.length;
        int m=image[0].length;
        Queue<int []>q=new LinkedList<>();
        q.add(new int []{sr,sc});
        image[sr][sc]=color;
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int x=curr[0];
            int y=curr[1];
            for(int dir[]:dirs){
                int newX=x+dir[0];
                int newY=y+dir[1];
                if(newX<n && newY<m && newX>=0 && newY>=0 && image[newX][newY]==originalColor){ image[newX][newY]=color;
                    q.add(new int[]{newX,newY});
                }
            }
        }
        
    }
}