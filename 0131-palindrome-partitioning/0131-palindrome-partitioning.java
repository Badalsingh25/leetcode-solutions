class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> list = new ArrayList<>();
        generatePalindrome(s, 0, new ArrayList<>(), list);
        return list;
    }

    private void generatePalindrome(String s, int start, List<String> temp, List<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < s.length(); i++) {

            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                generatePalindrome(s, i + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}