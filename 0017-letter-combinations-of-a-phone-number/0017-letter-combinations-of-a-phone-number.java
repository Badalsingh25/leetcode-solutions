class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        generateCombinations(digits, 0, new StringBuilder(), result);
        return result;
    }

    public void generateCombinations(String digits, int index, StringBuilder str, List<String> result) {

        if (index == digits.length()) {
            result.add(str.toString());
            return;
        }
        String[] map = { " ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        int digit = digits.charAt(index) - '0';
        String letter = map[digit];

        for (char c : letter.toCharArray()) {
            str.append(c);
            generateCombinations(digits, index + 1, str, result);
            str.deleteCharAt(str.length() - 1);
        }
    }
}