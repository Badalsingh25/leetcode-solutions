class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        generate(0, 0, n, new StringBuilder(), result);

        return result;
    }

    private void generate(int open, int close, int n, StringBuilder str, List<String> result) {

        if (str.length() == 2 * n) {
            result.add(str.toString());
            return;
        }

        if (open < n) {
            generate(open + 1, close, n, str.append("("), result);
            str.deleteCharAt(str.length() - 1);
        }
        if (close < open) {
            generate(open, close + 1, n, str.append(")"), result);
            str.deleteCharAt(str.length() - 1);
        }
    }
}