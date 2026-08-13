class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int totalSum = n * (n + 1) / 2;
        int arraySum = 0;

        for (int val : nums) {
            arraySum += val;
        }
        return totalSum - arraySum;
    }
}