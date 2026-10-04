class Solution {
    public String removeDuplicates(String s) {

        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            if (top >= 0 && stack[top] == s.charAt(i))
                top--;
            else
                stack[++top] = s.charAt(i);
        }
        return new String(stack, 0, top + 1);
    }
}