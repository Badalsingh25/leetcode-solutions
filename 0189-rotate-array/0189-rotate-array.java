class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1); // Reverse whole Array once
        reverse(nums, 0, k - 1); // revese 0 to first k element
        reverse(nums, k, n - 1); // reverse the rest part
    }

    private void reverse(int[] nums, int left, int right) {

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}