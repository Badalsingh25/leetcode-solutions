class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Step 1: Count the frequency of each task (A-Z)
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Create a Max Heap to always execute the task
        // with the highest remaining frequency.
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Insert only non-zero frequencies into the heap.
        for (int f : freq) {
            if (f > 0)
                maxHeap.offer(f);
        }

        // Queue stores:
        // [remaining frequency, next available time]
        Queue<int[]> queue = new ArrayDeque<>();

        int time = 0;

        // Continue until both heap and queue become empty.
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {

            // One CPU interval passes.
            time++;

            // Check whether the first cooling task
            // has completed its cooldown.
            if (!queue.isEmpty() && queue.peek()[1] <= time) {

                // Move it back into the heap
                // so it can be scheduled again.
                maxHeap.offer(queue.poll()[0]);
            }
            // Execute the highest-frequency task if available.
            if (!maxHeap.isEmpty()) {

                int remainingFreq = maxHeap.poll();

                // One occurrence has been executed.
                remainingFreq--;

                // If this task still has remaining occurrences,
                // put it into the cooling queue.
                if (remainingFreq > 0) {
                    queue.offer(new int[] {
                            remainingFreq,
                            time + n + 1
                    });
                }
            }

            
        }
        return time;
    }
}