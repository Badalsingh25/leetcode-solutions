class Solution {
    public int splitArray(int[] nums, int k) {

        int max = Integer.MIN_VALUE, sum = 0;
        for (int val : nums) {
            max = Math.max(max, val);
            sum += val;
        }
        int low = max, high = sum, ans = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int capacity, int k) {
        int sa = 1;
        int sum = 0;

        for (int val : nums) {
            sum += val;
            if (sum > capacity) {
                sa++;
                sum = val;
            }
            if (sa > k)
                return false;
        }
        return sa <= k;
    }
}