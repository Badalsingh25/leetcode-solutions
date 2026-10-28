class Solution {
    public int missingNumber(int[] nums) {

        int arraySum = 0, n = nums.length;

        for(int num : nums){
            arraySum += num;
        }
        int total = n * (n + 1) / 2;

        return total - arraySum;
    }
}