// //https://www.youtube.com/watch?v=gdBsvEOeYho&t=1248s
// //line sweep algo
// class Solution {
//     public int maxTwoEvents(int[][] events) {
//         ArrayList<int[]>al=new ArrayList<>();
//         for(int i[]:events){
//             al.add(new int[]{i[0],1,i[2]});
//             al.add(new int[]{i[1]+1,-1,i[2]});

//         }
//        // al.sort((a,b)->(a[0]-b[0]));
//        //if both same
//        al.sort((a,b)->(a[0] !=b[0]?a[0]-b[0]:a[1]-b[1]));
 
//         int max=0,maxSoFar=0;
//         for(int []i:al){
//             int st=i[0];
//             int e=i[1];
//             int val=i[2];
//             if(e==1){
//                 max=Math.max(max,maxSoFar+val);

//             }
//             else{
//                 maxSoFar=Math.max(maxSoFar,val);
//             }

//            }
//            return max;


        
//     }
// }
//b.s+sorting
class Solution {
     public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)->(a[1]-b[1]));
        int arr[]=new int[events.length];
        arr[0]=events[0][2];//max value intial
        for(int i=1;i<arr.length;i++){
            arr[i]=Math.max(arr[i-1],events[i][2]);
        }
        int sum=0;
        for(int i=0;i<events.length;i++){
            int l=0;
            int r=i-1;
            int flag=-1;//falg for non overlapping
            while(l<=r){
                int mid=l+(r-l)/2;
                if(events[mid][1]<events[i][0]){
                    flag=mid;
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
            int cur=events[i][2];
            if(flag!=-1){
                cur+=arr[flag];;

            }
            sum=Math.max(sum,cur);
        }
        return sum;
     }
}
