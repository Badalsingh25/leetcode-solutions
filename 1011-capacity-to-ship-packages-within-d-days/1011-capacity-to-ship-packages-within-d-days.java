class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int sum = 0, max = Integer.MIN_VALUE;
        for (int val : weights) {
            sum += val;
            max = Math.max(max, val);
        }
        if (weights.length == days)
            return max;

        int low = max, high = sum, ans = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(weights, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    private boolean isPossible(int[] weights, int capacity, int days) {
        int dayUsed = 1;
        int sum = 0;

        for (int weight : weights) {
            sum += weight;

            if (sum > capacity) {
                sum = weight;
                dayUsed++;

                if (dayUsed > days)
                    return false;
            }
        }
        return dayUsed <= days;
    }
}