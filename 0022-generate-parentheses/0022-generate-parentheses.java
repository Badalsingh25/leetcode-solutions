class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        generate(n, 0, 0, new StringBuilder(), list);
        return list;
    }

    private void generate(int n, int open, int close, StringBuilder str, List<String> result) {

        if (str.length() == 2 * n) {
            result.add(str.toString());
            return;
        }
        if (open < n) {
            generate(n, open + 1, close, str.append('('), result);
            str.deleteCharAt(str.length() - 1);
        }
        if (close < open) {
            generate(n, open, close + 1, str.append(')'), result);
            str.deleteCharAt(str.length() - 1);
        }
    }
}