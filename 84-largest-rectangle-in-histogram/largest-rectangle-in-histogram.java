class Solution {

    private int[] findRightSmaller(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        Arrays.fill(result, n);

        Stack<Integer> stack = new Stack<>();
        for (int index = n - 1; index >= 0; index--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[index]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[index] = stack.peek();
            }
            stack.push(index);

        }

        return result;
    }

    private int[] findLeftSmaller(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < n; index++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[index]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[index] = stack.peek();
            }
            stack.push(index);

        }

        return result;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int result = 0;

        int[] rightSmaller = findRightSmaller(heights);
        int[] leftSmaller = findLeftSmaller(heights);

        for (int pillar = 0; pillar < n; pillar++) {
            int height = heights[pillar];
            int width = 1;


            // right
            int rightContribution = rightSmaller[pillar] - pillar - 1;
        
            // left 
            int leftContribution =  pillar - leftSmaller[pillar] - 1;

            width += rightContribution;
            width += leftContribution;

            int area = height * width;
            result = Math.max(result, area);
        }

        return result;
    }
}