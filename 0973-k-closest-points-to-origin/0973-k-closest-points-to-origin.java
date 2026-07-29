/*
class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {

            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];

            return Integer.compare(distB, distA);
        });

        for (int[] point : points) {
            maxHeap.offer(point);

            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
*/
class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((b, a) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for (int[] point : points) {
            minHeap.offer(point);
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}