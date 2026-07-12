class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length())
            return "";

        int[] frequency = new int[128];

        for (char ch : t.toCharArray()) {
            frequency[ch]++;
        }
        int left = 0;
        int required = t.length();
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);
            if (frequency[current] > 0) {
                required--;
            }
            frequency[current]--;

            while (required == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                frequency[leftChar]++;

                if (frequency[leftChar] > 0) {
                    required++;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}