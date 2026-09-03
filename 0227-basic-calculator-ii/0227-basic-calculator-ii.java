class Solution {
    public int calculate(String s) {

        int lastNumber = 0, num = 0, result = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch))
                num = num * 10 + (ch - '0');
            if ((ch != ' ' && !Character.isDigit(ch)) || i == s.length() - 1) {

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