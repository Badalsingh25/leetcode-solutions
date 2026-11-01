class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0, maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right)))
                left = Math.max(left, map.get(s.charAt(right)) + 1);

            map.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}