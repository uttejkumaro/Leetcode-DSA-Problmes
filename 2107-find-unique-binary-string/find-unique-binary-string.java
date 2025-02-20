// class Solution {
//     public String findDifferentBinaryString(String[] nums) {
//         List<String>res=new ArrayList<>();
//         int n=nums.length;
//         generate("",n,res);
//         res.removeAll(Arrays.asList(nums));
//         return res.get(0);
        
//     }
//     void generate(String curr,int n,List<String>res){
//         if(curr.length()==n){
//             res.add(curr);
//             return ;
//         }
//         generate(curr+"0",n,res);
//         generate(curr+"1",n,res);
//     }
// }
//Cantor's diagonalization
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb=new StringBuilder();
        int n=nums.length;
        for(int i=0;i<n;i++){
            sb.append(nums[i].charAt(i)=='0'?'1':'0');
        }
        return sb.toString();
    }}