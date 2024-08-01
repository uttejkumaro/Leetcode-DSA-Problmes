class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] res=new int[n];
        HashMap<Integer,Integer>map=new HashMap<>();
        Arrays.fill(res,-1);
        for(int i=0;i<n;i++){
            map.put(nums1[i],i);
        }
        
        Stack<Integer>stack=new Stack<>();
        for(int num:nums2){
            while(!stack.isEmpty() && num>stack.peek()){
                int num1 =stack.pop();
                if(map.containsKey(num1)){
                    int id=map.get(num1);
                    res[id]=num;
                }
            }  
            stack.push(num);          

        }
        return res;


        
    }
}