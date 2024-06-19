class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        // Initialize the first element of res array
        res[0] = 1;
        
        // Calculate left products and store in res
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        // Calculate right products and update res
        int rightprd = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= rightprd;
            rightprd *= nums[i];
        }
        
        return res;
    }
}

/*
nums = [1, 2, 3, 4]
n = 4 (length of the array)
result = [1, 1, 1, 1] (initialize the result array with 1s)
leftProduct = 1
rightProduct = 1
Calculating Left Products:
First iteration (i = 0):

result[0] = leftProduct → result[0] = 1
leftProduct *= nums[0] → leftProduct = 1 * 1 = 1
result now is [1, 1, 1, 1]
Second iteration (i = 1):

result[1] = leftProduct → result[1] = 1
leftProduct *= nums[1] → leftProduct = 1 * 2 = 2
result now is [1, 1, 1, 1]
Third iteration (i = 2):

result[2] = leftProduct → result[2] = 2
leftProduct *= nums[2] → leftProduct = 2 * 3 = 6
result now is [1, 1, 2, 1]
Fourth iteration (i = 3):

result[3] = leftProduct → result[3] = 6
leftProduct *= nums[3] → leftProduct = 6 * 4 = 24
result now is [1, 1, 2, 6]
Calculating Right Products:
First iteration (i = 3):

result[3] *= rightProduct → result[3] = 6 * 1 = 6
rightProduct *= nums[3] → rightProduct = 1 * 4 = 4
result now is [1, 1, 2, 6]
Second iteration (i = 2):

result[2] *= rightProduct → result[2] = 2 * 4 = 8
rightProduct *= nums[2] → rightProduct = 4 * 3 = 12
result now is [1, 1, 8, 6]
Third iteration (i = 1):

result[1] *= rightProduct → result[1] = 1 * 12 = 12
rightProduct *= nums[1] → rightProduct = 12 * 2 = 24
result now is [1, 12, 8, 6]
Fourth iteration (i = 0):

result[0] *= rightProduct → result[0] = 1 * 24 = 24
rightProduct *= nums[0] → rightProduct = 24 * 1 = 24
result now is [24, 12, 8, 6]
Final Result:
The final result array is [24, 12, 8, 6].*/