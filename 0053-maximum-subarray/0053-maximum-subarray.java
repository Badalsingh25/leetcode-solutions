class Solution {
    public int maxSubArray(int[] nums) {

        // int maxSum = Integer.MIN_VALUE;;
        // int currentSum = 0;
        int maxSum = nums[0];
        int currentSum = nums[0];

        // for (int i = 0; i < nums.length; i++) {
        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}