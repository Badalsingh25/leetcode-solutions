class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int bar = stack.pop();
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int nse = i;

                area = Math.max(area, heights[bar] * (nse - pse - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int bar = stack.pop();
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int nse = n;
            area = Math.max(area, heights[bar] * (nse - pse - 1));
        }
        return area;
    }
}