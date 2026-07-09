class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // Add all elements before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge every interval that overlaps with newInterval.
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // Add the merged interval
        result.add(newInterval);

        // Add all remaining intervals.
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}