class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> wordSet = new HashSet<>(wordDict);

        int maxWordLen = 0;
        for (String word : wordDict) {
            maxWordLen = Math.max(maxWordLen, word.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            int start = Math.max(0, i - maxWordLen);

            for (int j = start; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}