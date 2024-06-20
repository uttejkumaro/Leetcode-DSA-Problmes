/*class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;  // Define the length of the array
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {  // Start j from i + 1 to avoid duplicates
                if(numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};  // Return 1-based indices
                }
            }
        }
        return new int[]{-1, -1};  // Return an array indicating no solution found
    }
}
*/
/*
//time complexity:O(n)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            int complement=target-numbers[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement)+1,i+1};

            }
            map.put(numbers[i],i);
        }
        return null;
    }
}
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;
        while(l<r){
            if(numbers[l]+numbers[r]==target){
                return new int[]{l+1,r+1};
            }
            else if(numbers[l]+numbers[r]>target){
                r-=1;
            }
            else{
                l+=1;
            }
        }
        return null;

    }
}

