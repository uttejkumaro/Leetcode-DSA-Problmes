// class Solution {
//     public boolean checkIfExist(int[] arr) {
//         int n=arr.length;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(arr[i]==arr[j]*2 && i!=j){
//                     return true;
//                 }
//             }
//         }
//         return false;
        
//     }
// }
 class Solution {
  public boolean checkIfExist(int[] arr) {
    int n=arr.length;
    HashMap<Integer,Integer>mp=new HashMap<>();
    for(int i=0;i<n;i++){
        int num=arr[i];
        if(mp.containsKey(2*num) || ( num%2 ==0  &&mp.containsKey(num/2) )){
            return true;
        }
        mp.put(num,mp.getOrDefault(num,0)+1);
    }
    return false;
  }
 }
