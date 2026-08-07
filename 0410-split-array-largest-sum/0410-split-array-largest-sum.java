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
            if (isPossible(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int result, int k) {

        int count = 1;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > result) {
                count++;
                sum = nums[i];
            }
            if (count > k)
                return false;
        }
        return count <= k;
    }
}