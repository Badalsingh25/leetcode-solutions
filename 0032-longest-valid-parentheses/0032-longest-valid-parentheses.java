class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base Index

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // New invalid Boundary
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}