class Solution {
    public int splitArray(int[] nums, int k) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            max = Math.max(max, val);
            sum += val;
        }
        int low = max, high = sum, ans = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canSplit(int[] nums, int mid, int k) {

        int sum = 0;
        int sa = 1;

        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                sa++;
                sum = num;
            }
            if (sa > k)
                return false;
        }
        return sa <= k;
    }
}