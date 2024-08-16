class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        if(n==0) return;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            if(board[i][0]=='O') bfs(board,i,0);
            if(board[i][m-1]=='O') bfs(board,i,m-1);
        }
          for(int j=0;j<m;j++){
            if(board[0][j]=='O') bfs(board,0,j);
            if(board[n-1][j]=='O') bfs(board,n-1,j);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='V'){
                    board[i][j]='O';
                }
                
            }
        }
             
    }
     void bfs(char board[][],int x,int y){
            int n=board.length;
            int m=board[0].length;
            Queue<int[]>Q=new LinkedList<>();
            Q.add(new int[]{x,y});
            board[x][y]='V';
            int [][]dir={{1,0},{-1,0},{0,1},{0,-1}};
            while(!Q.isEmpty()){
                int cell[]=Q.poll();
                int cx=cell[0];
                int cy=cell[1];
                for(int d[]:dir){
                    int n1=cx+d[0];
                    int n2=cy+d[1];
                     if(n1>=0 && n1<n && n2>=0 && n2<m && board[n1][n2]=='O'){
                         Q.add(new int[]{n1,n2});
                        board[n1][n2]='V';
                    }
                }
               

            }
        }
}