class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();

        int width = 1;
        int maxArea = 0;
        int currentArea = 0;
        int[] leftSmaller = new int[heights.length];
        int[] rightSmaller = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            leftSmaller[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            rightSmaller[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < heights.length; i++) {
            width = rightSmaller[i] - leftSmaller[i] - 1;
            currentArea = heights[i] * width;
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }
}