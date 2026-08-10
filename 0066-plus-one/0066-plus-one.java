class Solution {
    public int[] plusOne(int[] digits) {

        int i = digits.length - 1;
        int carry = 1;
        int pos = digits.length;
        int[] result = new int[pos + 1];

        while (i >= 0 || carry > 0) {
            if (i >= 0)
                carry += digits[i--];

            result[pos--] = carry % 10;
            carry /= 10;
        }
        int[] ans = new int[digits.length];
        if (result[0] == 0) {
            System.arraycopy(result, 1, ans, 0, ans.length);
            return ans;
        }
        return result;
    }
}