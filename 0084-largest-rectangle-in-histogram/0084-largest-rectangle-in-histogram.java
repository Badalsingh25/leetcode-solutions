class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            // Process stack while current bar is smaller than top of stack
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int bar = stack.pop(); // Index of bar
                int pse = stack.isEmpty() ? -1 : stack.peek(); // Previous smaller element index
                int nse = i; // current element is next smaller element
                // width = nse - pse - 1;
                area = Math.max(area, heights[bar] * (nse - pse - 1));
            }
            stack.push(i);
        }
        
        // Process remaining bars in stack
        while (!stack.isEmpty()) {
            int bar = stack.pop();
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int nse = n;
            area = Math.max(area, heights[bar] * (nse - pse - 1));
        }
        return area;
    }
}