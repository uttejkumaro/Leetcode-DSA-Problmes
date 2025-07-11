class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>res=new ArrayList<>();
        int arr[]={1,2,3,4,5,6,7,8,9};
        List<Integer>curr=new ArrayList<>();
        helper(res,curr,arr,n,k,0);
        return res; 
    }
    void helper(List<List<Integer>>res,List<Integer>curr,int arr[],int n, int k,int i){
        if(n==0 && curr.size()==k){
            res.add(new  ArrayList<>(curr));
            return ;
        }
        if(i>=arr.length ||n<0) return;
       
        curr.add(arr[i]);
        helper(res,curr,arr,n-arr[i],k,i+1);
        curr.remove(curr.size()-1);
       helper(res,curr,arr,n,k,i+1);


    }
}