class Solution {
    public int[] plusOne(int[] digits) {

        int i = digits.length - 1;
        int carry = 1;
        int[] result = new int[digits.length + 1];
        int s = result.length - 1;

        while (i >= 0 || carry > 0) {

            if (i >= 0)
                carry += digits[i--];
            result[s--] = (carry % 10);
            carry /= 10;
        }
        if (result[0] == 0) {
            int[] ans = new int[result.length - 1];
            System.arraycopy(result, 1, ans, 0, ans.length);
            return ans;
        }
        return result;
    }
}