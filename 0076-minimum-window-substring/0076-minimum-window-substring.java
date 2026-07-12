class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> frequency = new HashMap<>();
        int left = 0;
        int required = t.length();
        int minLength = Integer.MAX_VALUE;
        String result = "";

        for (char ch : t.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            if (frequency.containsKey(c)) {
                if (frequency.get(c) > 0) {
                    required--;
                }
                frequency.put(c, frequency.get(c) - 1);
            }
            while (required == 0) {
                int currentLength = right - left + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    result = s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                if (frequency.containsKey(leftChar)) {
                    frequency.put(leftChar, frequency.get(leftChar) + 1);
                    if (frequency.get(leftChar) > 0) {
                        required++;
                    }
                }
                left++;
            }
        }
        return result;
    }
}