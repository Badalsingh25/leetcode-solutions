class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        generateCombinations(s, 0, new ArrayList<>(), result);
        return result;
    }

    public void generateCombinations(String s, int start, List<String> current, List<List<String>> result) {

        if (s.length() == start) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (palindromeCheck(s, start, i)) {
                current.add(s.substring(start, i + 1));
                generateCombinations(s, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean palindromeCheck(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}