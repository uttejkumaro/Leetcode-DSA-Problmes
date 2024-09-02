//time complexity:O(n)
class Solution {
    public int maxProfit(int[] prices) {
    int minPrice=Integer.MAX_VALUE;
    int profit=0;
    for(int i=0;i<prices.length;i++){
        if(prices[i]<minPrice){
            minPrice=prices[i];
        }
        else if(prices[i]-minPrice>profit){
            profit=prices[i]-minPrice;
        }
    }
    
        


    return profit;
    }
}
// //int maxProfit = 0;
// 	int mini = Arr[0];
	
// 	for(int i=1;i<Arr.length;i++){
//         int curProfit = Arr[i] - mini;
//         maxProfit = Math.max(maxProfit,curProfit);
//         mini = Math.min(mini,Arr[i]);
//         }