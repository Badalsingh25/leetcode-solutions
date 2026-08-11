class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int max = Integer.MIN_VALUE, sum = 0;
        for (int val : weights) {
            sum += val;
            max = Math.max(max, val);
        }
        int low = max, high = sum, ans = sum;

        if(weights.length == days) return max;
        
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

    private boolean isPossible(int[] weights, int sum, int days) {
        int capacity = 0;
        int dayUsed = 1;

        for (int val : weights) {
            capacity += val;
            if (capacity > sum) {
                dayUsed++;
                capacity = val;
            }
            if (dayUsed > days)
                return false;
        }
        return dayUsed <= days;
    }
}