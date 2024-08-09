class Solution {
    public int maximumSum(int[] arr) {
        int n =arr.length;
        if(n==0)return 0;
        int max=arr[0];
        int pick=arr[0];
        int delete=0;
        for(int i=1;i<n;i++){
            delete=Math.max(pick,delete+arr[i]);
            pick=Math.max(arr[i],pick+arr[i]);
            max=Math.max(max,Math.max(delete,pick));

        }
        return max;

    }
}