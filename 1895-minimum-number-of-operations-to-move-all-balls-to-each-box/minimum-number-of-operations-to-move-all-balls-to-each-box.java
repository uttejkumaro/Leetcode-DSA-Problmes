// class Solution {
//     public int[] minOperations(String boxes) {
//         int n=boxes.length();
//         int res[]=new int[boxes.length()];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
                
//                     if(boxes.charAt(j)=='1'){
//                         res[i]+=Math.abs(i-j);

                    
//                 }
//             }
//         }
//         return res;

        
//     }
// }
class Solution {
 public int[] minOperations(String boxes) {
    int n=boxes.length();
    //prefix sum from l-r
    int  res[]=new int[n];
    int ones=0;
    int moves=0;
    for(int i=0;i<n;i++){
        res[i]+=moves;
        ones+=boxes.charAt(i)=='1'?1:0;
        moves+=ones;
    }
    //prefix sum from r-l
     ones=0;
     moves=0;
    for(int i=n-1;i>=0;i--){
        res[i]+=moves;
        ones+=boxes.charAt(i)=='1'?1:0;
        moves+=ones;


    }
    return res;

 }
}
