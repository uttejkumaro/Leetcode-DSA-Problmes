//import java.util.Stack;

 class Solution {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Initialize result array with -1
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }
        
        // Iterate over the array twice
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            
            // Check for the next greater element
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            // Push the current index onto the stack
            if (i < n) {
                stack.push(i);
            }
        }
        
        return result;
    }
    /*

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] result = nextGreaterElements(nums);
        for (int res : result) {
            System.out.print(res + " ");
        }
        // Output: 2 -1 2
        
    }*/
}
