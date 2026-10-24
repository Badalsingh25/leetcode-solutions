class Solution {
    public int pivotIndex(int[] nums) {

        int leftSum = 0;
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < nums.length; i++) {
            int rightSum = 0;
            rightSum = total - nums[i] - leftSum;
            
            if (leftSum == rightSum)
                return i;

            leftSum += nums[i];
        }
        return -1;
    }
}