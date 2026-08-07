class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        if (nums.length == threshold)
            return max;

        int low = 1, high = max, mdiv = max;

        while (low <= high) {
            int div = low + (high - low) / 2;

            if (isPossible(nums, div, threshold)) {
                mdiv = div;
                high = div - 1;
            } else {
                low = div + 1;
            }
        }
        return mdiv;
    }

    private boolean isPossible(int[] nums, int div, int threshold) {

        long result = 0;

        for (int i = 0; i < nums.length; i++) {
            result += Math.ceil(nums[i] * 1.0 / div);
            if (result > threshold)
                return false;
        }
        return result <= threshold;
    }
}