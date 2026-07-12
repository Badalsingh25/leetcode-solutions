class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] frequency = new int[128];

        // Store frequency of characters in t
        for (char ch : t.toCharArray()) {
            frequency[ch]++;
        }

        int left = 0;
        int required = t.length();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            // If this character is still required
            if (frequency[current] > 0) {
                required--;
            }

            // Include current character in window
            frequency[current]--;

            // Try to shrink the window
            while (required == 0) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                // Remove left character from window
                frequency[leftChar]++;

                // If it becomes required again
                if (frequency[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}