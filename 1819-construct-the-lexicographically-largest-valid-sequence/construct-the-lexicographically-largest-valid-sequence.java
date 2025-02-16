class Solution {
    public int[] constructDistancedSequence(int n) {
        int res[]=new int[2*n-1];
        boolean vis[]=new boolean[n+1];
        backtrack(0,vis,res,n);
        return res;      
        
    }
    boolean backtrack(int idx,boolean[]vis,int res[],int n){
        if(idx==res.length) return true;
        if(res[idx]!=0) return backtrack(idx+1,vis,res,n) ;//skip
        for(int i=n;i>0;i--){
            if(vis[i]) continue;
            if(i==1){
                res[idx]=1;
                vis[i]=true;
                if(backtrack(idx+1,vis,res,n)) return true;
                res[idx]=0;
                vis[i]=false;

            }
            else{
                int nxtidx=idx+i;
                if(nxtidx<res.length && res[nxtidx]==0){
                    vis[i]=true;
                    res[idx]=res[nxtidx]=i;
                    if(backtrack(idx+1,vis,res,n)) return true;
                    res[idx]=res[nxtidx]=0;
                     vis[i]=false;
                }

            }
        }
        return false;


    }

}