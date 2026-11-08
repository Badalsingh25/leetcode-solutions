class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        generateCombinations(0, s, new ArrayList<>(), result);
        return result;
    }

    private void generateCombinations(int start, String s, List<String> current, List<List<String>> result){

        if(start == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = start; i < s.length();i++){
            if(isPalindrome(s, start, i)){
                current.add(s.substring(start, i + 1));
                generateCombinations(i + 1, s, current, result);
                current.remove(current.size() - 1);
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