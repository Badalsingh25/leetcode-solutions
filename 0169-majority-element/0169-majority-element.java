class Solution {
    public int majorityElement(int[] nums) {

        int candidate = -1, count = 0;

        for (int num : nums) {
            if (count == 0)
                candidate = num;
            else if (candidate == num)
                count++;
            else
                count--;
        }
        return candidate;
    }
}