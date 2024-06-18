class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //2d array
        int n=difficulty.length;
        int jobs[][]=new int [n][2];
        for(int i=0;i<n;i++){
            jobs[i][0]=difficulty[i];
            jobs[i][1]=profit[i];
        }
       
        //sort jobs by  diiffucty
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);
        //iterating thw worker array
        Arrays.sort(worker);
        int maxProfit=0;
        int bestProfit=0;
        int jobindex=0;
        int m=worker.length;
        for(int i=0;i<m;i++){
            while(jobindex<n && worker[i]>=jobs[jobindex][0]){
                bestProfit=Math.max(bestProfit,jobs[jobindex][1]);
                jobindex++;
            }
            maxProfit+=bestProfit;

        }
        return maxProfit;
        
        
    }
}