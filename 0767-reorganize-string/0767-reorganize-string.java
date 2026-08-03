class Solution {
    public String reorganizeString(String s) {

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                maxHeap.offer(new int[] { i, freq[i] }); // [characterIndex, frequency]
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = null;

        while (!maxHeap.isEmpty()) {

            int[] curr = maxHeap.poll();
            int index = curr[0];
            int frequency = curr[1];

            char ch = (char) (index + 'a');
            sb.append(ch);
            curr[1]--;

            if (prev != null)
                maxHeap.offer(prev);

            if (curr[1] > 0)
                prev = new int[] { index, curr[1] };
                // prev = curr;
            else
                prev = null;
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
