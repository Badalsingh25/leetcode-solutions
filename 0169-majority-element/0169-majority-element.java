class Solution {
    public int majorityElement(int[] nums) {

        // Arrays.sort(nums);
        // int n = nums.length;
        // return nums[n / 2];

        int count = 0, candidate = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0)
                candidate = nums[i];
            if (candidate == nums[i])
                count++;
            else
                count--;
        }
        return candidate;
    }
}