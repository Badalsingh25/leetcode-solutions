class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0)
                maxHeap.offer(f);
        }

        // Queue stores: [remaining frequency, next available time]
        Queue<int[]> queue = new ArrayDeque<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {

            time++;

            if (!queue.isEmpty() && queue.peek()[1] <= time) {
                maxHeap.offer(queue.poll()[0]);
            }
            if (!maxHeap.isEmpty()) {
                int remainingFreq = maxHeap.poll();
                remainingFreq--;

                if (remainingFreq > 0) {
                    queue.offer(new int[] { remainingFreq, time + n + 1 });
                }
            }
        }
        return time;
    }
}