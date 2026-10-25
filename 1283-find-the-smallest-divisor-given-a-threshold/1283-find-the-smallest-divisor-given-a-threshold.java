class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int max = Integer.MIN_VALUE;
        for (int val : nums) {
            max = Math.max(val, max);
        }

        if (nums.length == threshold)
            return max;

        int low = 1, high = max, mdiv = max;

        while (low <= high) {
            int div = low + (high - low) / 2;

            if (isDivisible(nums, div, threshold)) {
                mdiv = div;
                high = div - 1;
            } else
                low = div + 1;
        }
        return mdiv;
    }

    private boolean isDivisible(int[] nums, int div, int threshold) {
        int result = 0;

        for (int val : nums) {
            result += (val + div - 1) / div;

            if (result > threshold)
                return false;
        }
        return result <= threshold;
    }
}