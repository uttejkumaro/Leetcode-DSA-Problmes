//maximum score = total sum - minimum sum of the middle block

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        int n=cardPoints.length;
        for(int s:cardPoints){
            sum+=s;
        }
        int winddowSize=n-k;
        int winddowSum=0;
        for(int i=0;i<winddowSize;i++){
            winddowSum+=cardPoints[i];
        }
        int minSum=winddowSum;
        for(int i=winddowSize;i<n;i++){
            winddowSum+=cardPoints[i]-cardPoints[i-winddowSize];
            minSum=Math.min(winddowSum,minSum);
        }
        return sum-minSum;
    }
}
/***/