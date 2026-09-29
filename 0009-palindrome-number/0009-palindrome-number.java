class Solution {
    public boolean isPalindrome(int x) {

        int original = x;
        int reverse = 0;


        while (original > 0) {
            int digit = original % 10;
            reverse = reverse * 10 + digit;
            original = original / 10;
        }

        return x == reverse;
    }
}