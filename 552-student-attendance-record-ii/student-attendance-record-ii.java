class Solution {
    public int checkRecord(int n) {
        final int mod=1000000007;
        int [][][] arr=new int[n+1][2][3];
          arr[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
        for(int i=1;i<=n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    int val=arr[i-1][j][2];
                    if(j>0) val =(val +arr[i-1][j-1][2])%mod;
                    if  (k>0) val =(val +arr[i-1][j][k-1])%mod;
                arr[i][j][k]=val;;
                }
              
            }
        }
          return arr[n][1][2];
        
    }
}