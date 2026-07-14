class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int sum = 0;
        int max = 0;
        for (int val : weights) {
            sum += val;
            max = Math.max(max, val);
        }
        int low = max;
        int high = sum;
        int ans = 0;
        if (weights.length == days)
            return max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(weights, mid, days) == true) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] weights, int capacity, int days) {
        int sum = 0;
        int dayUsed = 1;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > capacity) {
                dayUsed++;
                sum = weights[i];
                if (dayUsed > days)
                    return false;
            }
        }
        return dayUsed <= days;
    }
}