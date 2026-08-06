class Solution {
    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1, pos = nums.length - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare >= rightSquare) {
                result[pos--] = leftSquare;
                left++;
            } else {
                result[pos--] = rightSquare;
                right--;
            }
        }
        return result;
    }
}