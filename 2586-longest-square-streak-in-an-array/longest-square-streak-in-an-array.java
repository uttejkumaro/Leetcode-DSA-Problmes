// class Solution {
//     public int longestSquareStreak(int[] nums) {
//         int n=nums.length;
//         ArrayList<Integer>res=new ArrayList<>();
//         Arrays.sort(nums);
//         for(int i=0;i<n;i++){
//             for(int j=i;j<n;j++){
//                 if(nums[j]==(int)Math.pow(nums[i],2)){
//                      res.add(nums[i]);
//                     res.add(nums[j]);
//                 }
//             }

//         }
//         Set<Integer>set=new HashSet<>();
//         for(int i:res){
//             set.add(i);
//         }
//         return (set.size()!=0) ? set.size():-1;

        
//     }
// }
class Solution {
public int longestSquareStreak(int[] nums) {
        Set<Long> st=new HashSet<>();
        for(int i:nums) st.add((long)i);
        int res=-1;
        for(int i:nums){
            int len=1;
            long val=i;
            while(st.contains(val*val)){
                len++;
                val=val*val;
            }
            if(len>=2) res=Math.max(len,res);
        }
        return res;
}
}