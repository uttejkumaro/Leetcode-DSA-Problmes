class Solution {
    public int minCost(int n, int[] cuts) {
        int total []=new int[cuts.length+2];
        total[0]=0;
        total[total.length-1]=n;
        for(int i=0;i<cuts.length;i++){
            total[i+1]=cuts[i];
        }
        Arrays.sort(total);
        int memo[][]=new int[total.length][total.length];
        return helper(total,0,total.length-1,memo);                
    }
    int helper(int cuts[],int left,int right,int memo[][]){
        if(left+1==right){
            return 0;
        }
        if(memo[left][right]!=0){
            return memo[left][right];
        }
        int min=Integer.MAX_VALUE;
        for(int i=left+1;i<right;i++){
            int cost=cuts[right]-cuts[left]+helper(cuts,left,i,memo)+helper(cuts,i,right,memo);
            min=Math.min(min,cost);
        }
        return memo[left][right] =min;
    }
}