class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int num = 0, lastNumber = 0, result = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch))
                num = num * 10 + (ch - '0');

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (op == '+') {
                    result += lastNumber;
                    lastNumber = num;
                } else if (op == '-') {
                    result += lastNumber;
                    lastNumber = -num;
                } else if (op == '*') {
                    lastNumber *= num;
                } else if (op == '/') {
                    lastNumber /= num;
                }
                op = ch;
                num = 0;
            }
        }
        return result + lastNumber;
    }
}