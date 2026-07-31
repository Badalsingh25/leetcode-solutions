class MedianFinder {

    // Max Heap stores the smaller half of the numbers.
    // The largest element of the smaller half is always at the top.
    PriorityQueue<Integer> maxHeap;

    // Min Heap stores the larger half of the numbers.
    // The smallest element of the larger half is always at the top.
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        // Max Heap (descending order)
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Min Heap (ascending order)
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // If maxHeap is empty OR the number belongs to the smaller half,
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        }
        // Otherwise, insert it into minHeap.
        else {
            minHeap.offer(num);
        }

        // Step 2: Balance the heaps.

        // If it has more than one extra element,
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }

        // If minHeap has more elements than maxHeap,
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        // case: 1 - Median is the average of the two middle elements(Even number of elements)
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        // Case 2: Odd number of elements.
        // so its top is the median.
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 *
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double median = obj.findMedian();
 */