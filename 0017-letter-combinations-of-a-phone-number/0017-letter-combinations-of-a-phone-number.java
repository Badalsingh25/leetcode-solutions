class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        generateCombinations(0, digits, new StringBuilder(), result);
        return result;
    }

    private void generateCombinations(int index, String digits, StringBuilder str, List<String> result) {

        if (index == digits.length()) {
            result.add(str.toString());
            return;
        }

        String[] map = { " ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        int digit = digits.charAt(index) - '0';
        String letter = map[digit];

        for (char ch : letter.toCharArray()) {
            str.append(ch);
            generateCombinations(index + 1, digits, str, result);
            str.deleteCharAt(str.length() - 1);
        }
    }
}