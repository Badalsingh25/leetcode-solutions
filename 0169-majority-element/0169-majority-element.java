class Solution {
    public int majorityElement(int[] nums) {

        int count = 0, candidates = -1;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0)
                candidates = nums[i];
            if (candidates == nums[i])
                count++;
            else
                count--;
        }
        return candidates;
    }
}