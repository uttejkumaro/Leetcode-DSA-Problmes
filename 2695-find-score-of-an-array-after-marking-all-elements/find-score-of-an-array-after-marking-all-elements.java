// class Solution {
//     public long findScore(int[] nums) {
//         long ans=0;
//         int n=nums.length;
//         int sort[][]=new int[n][2];
//         boolean mark[]=new boolean[n];
//         for(int i=0;i<n;i++){
//             sort[i][0]=nums[i];//val
//             sort[i][1]=i;//index
//         }
//         Arrays.sort(sort,(a,b)->a[0]-b[0]);
//         for(int i=0;i<n;i++){
//             int num=sort[i][0];
//             int idx=sort[i][1];
//             if(!mark[idx]){
//                 ans+=num;
//                 mark[idx]=true;
//                 if(idx-1>=0) mark[idx-1]=true;
//                 if(idx+1<n) mark[idx+1]=true;
//             }
//         }
//         return ans;
       
    
//     }
// }
class Solution {
     public long findScore(int[] nums) {
          long ans=0;
       int n=nums.length;
       boolean mark[]=new boolean[n];
       PriorityQueue<int []>minHeap=new PriorityQueue<>((a,b)->
      {
        if(a[0]!=b[0]) return a[0]-b[0];
       return  a[1]-b[1];
       });
       for(int i=0;i<n;i++){
        minHeap.add(new int[]{nums[i],i});
       }
        while(!minHeap.isEmpty()){
            int sort[]=minHeap.remove();
            int num=sort[0];
            int idx=sort[1];
            if(!mark[idx]){
                ans+=num;
                mark[idx]=true;
                if(idx-1>=0) mark[idx-1]=true;
                if(idx+1<n) mark[idx+1]=true;
            }
        }
        return ans;
     }
}