class Solution {
    public void sortColors(int[] nums) {

        int left = 0, mid = 0, right = nums.length - 1;

        while (mid <= right) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[left];
                nums[left] = temp;

                left++;
                mid++;
            } else if (nums[mid] == 1)
                mid++;
            else {
                int temp = nums[right];
                nums[right] = nums[mid];
                nums[mid] = temp;

                right--;
            }
        }
    }
}