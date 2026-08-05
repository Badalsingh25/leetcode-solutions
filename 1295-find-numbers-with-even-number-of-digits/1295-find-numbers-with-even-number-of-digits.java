class Solution {
    public int findNumbers(int[] nums) {

        int count = 0;
        for (int num : nums) {

            int nod = 0;
            while (num > 0) {
                num /= 10;
                nod++;
            }
            if (nod % 2 == 0)
                count++;
        }
        return count;
    }
}