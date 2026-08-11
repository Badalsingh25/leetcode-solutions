class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int max = Integer.MIN_VALUE;
        for (int val : nums) {
            max = Math.max(val, max);
        }
        int low = 1, high = max, ans = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, mid, threshold)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int div, int threshold) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] + div - 1) / div;
            if (sum > threshold)
                return false;
        }
        return sum <= threshold;
    }
}