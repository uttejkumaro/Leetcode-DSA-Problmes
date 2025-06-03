// class Solution {
//     public int candy(int[] ratings) {
//         int n=ratings.length;
//         int left[]=new int[n];         
//         Arrays.fill(left,1);   
//         for(int i=1;i<n;i++){
//             if(ratings[i-1]<ratings[i]){
//                 left[i]=left[i-1]+1;
//             }
//         }
//         int total = left[n - 1];
//         int right = 1;
//         for(int i=n-2;i>=0;i--){
//             if(ratings[i]>ratings[i+1]){
//                 right++;
//             }
//             else{
//                 right=1;
//             }
//         left[i]=Math.max(left[i],right);
//         total+=left[i];
//         }        
//         return total;        
//     }
// }
//to optimise wecan use slope aproc 
class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        if(n==0 ) return 0;
        int total=1;
        int up=0,down=0,peak=0;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                up+=1;
                peak=up;
                down=0;
                total+=1+up;
            }
            else if(ratings[i]<ratings[i-1]){
                down+=1;
                up=0;
                total+=1+down-(peak>=down?1:0);//to avoid doublw ounting the peak node
            }
            else{
                up=down=peak=0;
                total+=1;
            }
        }
        return total;
    }
}