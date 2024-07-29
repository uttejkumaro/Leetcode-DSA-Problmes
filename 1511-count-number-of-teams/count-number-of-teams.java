/*
// brute -O(n^3)
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) || 
                        (rating[i] > rating[j] && rating[j] > rating[k])) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
*/
// DP =O(N^2)
// another efficient approch -o(nlogn)
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count=0;
        for(int j=0;j<n;j++){
            //left
            int lLess=0,rLess=0,lMore=0,rMore=0;
            for(int i=0;i<j;i++){
                if(rating[i]<rating[j]) lLess ++;
                if(rating[i]>rating[j]) lMore ++;
            }
             for(int k=j+1;k<n;k++){
                if(rating[k]<rating[j]) rLess ++;
                if(rating[k]>rating[j]) rMore ++;
            }
            count+=lLess*rMore +rLess*lMore;
        }
        return count;
    }
}
