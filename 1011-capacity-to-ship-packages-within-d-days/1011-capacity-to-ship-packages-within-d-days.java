class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : weights) {
            sum += val;
            max = Math.max(val, max);
        }
        int low = max, high = sum, ans = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(weights, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] weights, int mid, int days) {
        int sum = 0;
        int dayUsed = 1;

        for (int weight : weights) {
            sum += weight;
            if (sum > mid) {
                dayUsed++;
                sum = weight;
            }
            if (dayUsed > days)
                return false;
        }
        return dayUsed <= days;
    }
}