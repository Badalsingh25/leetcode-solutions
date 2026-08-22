class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), list);
        return list;
    }

    private void backtrack(String digits, int index, StringBuilder str, List<String> result) {

        String[] map = { " ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        if (index == digits.length()) {
            result.add(str.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = map[digit];

        for (char c : letters.toCharArray()) {
            str.append(c);
            backtrack(digits, index + 1, str, result);
            str.deleteCharAt(str.length() - 1);
        }
    }
}