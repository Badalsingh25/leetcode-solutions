class Solution {
    public int maxSubArray(int[] nums) {

        // int currentSum = Integer.MIN_VALUE, maxSum = 0;
        int currentSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}