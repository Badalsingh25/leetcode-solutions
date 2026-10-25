class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;

        for (int val : piles) {
            max = Math.max(max, val);
        }
        if (piles.length == h)
            return max;

        int low = 1, high = max, speed = max;

        while (low <= high) {
            int sp = low + (high - low) / 2;

            if (canEat(piles, sp, h)) {
                speed = sp;
                high = sp - 1;
            } else {
                low = sp + 1;
            }
        }
        return speed;
    }

    private boolean canEat(int[] piles, int sp, int h) {
        int time = 0;

        for (int pile : piles) {
            // time += Math.ceil((piles[i] * 1.0) / sp);
            time += (pile + sp - 1) / sp;

            if (time > h)
                return false;
        }
        return time <= h;
    }
}