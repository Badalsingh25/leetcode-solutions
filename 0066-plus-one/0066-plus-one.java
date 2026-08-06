class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length - 1;
        int pos = digits.length;
        int[] result = new int[pos + 1];
        int carry = 1;

        while (n >= 0 || carry > 0) {

            if (n >= 0)
                carry += digits[n--];
            result[pos--] = carry % 10;
            carry /= 10;
        }
        int[] ans = new int[result.length - 1];
        if (result[0] == 0) {
            System.arraycopy(result, 1, ans, 0, result.length - 1);
            return ans;
        }
        return result;
    }
}