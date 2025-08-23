class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]<=k)k++;
            else break;
        }
        return k;
    }
}
/**
Intuition Behind "Shifting"

Think of k as a moving target:

Initially, k means "the k-th missing if there were no array elements."

Each time you see an element ≤ k, it means your target got pushed further ahead (because one potential missing number is "used up" by this present element).

So you move k one step forward.

In other words:

Array elements "consume" one missing number each time they are ≤ current k.

Shifting keeps track of the "true" k-th missing */