class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;
        for (int num : piles) {
            max = Math.max(num, max);
        }
        int low = 1, high = max, ans = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEat(piles, mid, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canEat(int[] piles, int sp, int h) {

        long time = 0;

        for (int i = 0; i < piles.length; i++) {
            time += (piles[i] + sp - 1) / sp;

            if (time > h)
                return false;
        }
        return time <= h;
    }
}