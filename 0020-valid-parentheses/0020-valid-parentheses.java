class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(')
                stack.push(')');
            else if (ch == '{')
                stack.push('}');
            else if (ch == '[')
                stack.push(']');
            else {
                // stack.pop();
                if (stack.isEmpty() || ch != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}