class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        // reverse(nums, 0, k);
        // reverse(nums, k + 1, n - 1);
        // reverse(nums, 0, n - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        // i = 0;
        // j = nums.length - 1;

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}