// class Solution {

//     private int[] findRightSmaller(int[] heights) {
//         int n = heights.length;
//         int[] result = new int[n];
//         Arrays.fill(result, n);

//         Stack<Integer> stack = new Stack<>();
//         for (int index = n - 1; index >= 0; index--) {
//             while (!stack.isEmpty() && heights[stack.peek()] >= heights[index]) {
//                 stack.pop();
//             }
//             if (!stack.isEmpty()) {
//                 result[index] = stack.peek();
//             }
//             stack.push(index);

//         }

//         return result;
//     }

//     private int[] findLeftSmaller(int[] heights) {
//         //This function finds the index of the nearest smaller element to the left of each index.
//         int n = heights.length;
//         int[] result = new int[n];
//         Arrays.fill(result, -1);

//         Stack<Integer> stack = new Stack<>();
//         for (int index = 0; index < n; index++) {
//             while (!stack.isEmpty() && heights[stack.peek()] >= heights[index]) {
//                 stack.pop();
//             }
//             if (!stack.isEmpty()) {
//                 result[index] = stack.peek();
//             }
//             stack.push(index);
//         }

//         return result;
//     }

//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;
//         int result = 0;

//         int[] rightSmaller = findRightSmaller(heights);
//         int[] leftSmaller = findLeftSmaller(heights);

//         for (int pillar = 0; pillar < n; pillar++) {
//             int height = heights[pillar];
//             int width = 1;
//                         // right
//             int rightContribution = rightSmaller[pillar] - pillar - 1;
        
//             // left 
//             int leftContribution =  pillar - leftSmaller[pillar] - 1;
//             width += rightContribution;
//             width += leftContribution;

//             int area = height * width;
//             result = Math.max(result, area);
//         }
      

//         return result;
//     }
// }
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i]; // Handle last element
            while (!stack.isEmpty() && heights[stack.peek()] >= h) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
