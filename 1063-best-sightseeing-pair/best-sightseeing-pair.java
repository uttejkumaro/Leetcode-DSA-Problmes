// class Solution {
//     public int maxScoreSightseeingPair(int[] values) {
//         int max=0;
//         for(int i=0;i<values.length;i++){
//             for(int j=i+1;j<values.length;j++){
//                 max=Math.max(values[i]+values[j]+i-j,max);

//             }
//         }
//         return max;
        
//     }
// }
class Solution {
  public int maxScoreSightseeingPair(int[] values) {
    int max=0;
    int rem=values[0];
    for(int j=1;j<values.length;j++){
        max=Math.max(max,values[j]-j+rem);
        rem=Math.max(rem,values[j]+j);
    }
    return max;

  }
}