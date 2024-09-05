class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=0;
        int m=rolls.length;
        for(int roll:rolls)sum+=roll;
        int terms=m+n;
        int actualSum=(m+n)*mean;
        int diff=actualSum-sum;
        if(diff>6*n || diff <n) return new int[0];
        int mod=diff%n;
        int newMean=diff/n;
        int res[]=new int[n];
        Arrays.fill(res,newMean);
        for(int i=0;i<mod;i++){
            res[i]++;
        } 
        return res;
        
    }
}