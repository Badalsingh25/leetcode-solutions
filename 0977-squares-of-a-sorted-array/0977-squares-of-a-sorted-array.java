class Solution {
    public int[] sortedSquares(int[] nums) {

        int left = 0, right = nums.length - 1;
        int[] ans = new int[nums.length];
        int pos = nums.length - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                ans[pos--] = leftSquare;
                left++;
            } else {
                ans[pos--] = rightSquare;
                right--;
            }
        }
        return ans;
    }
}