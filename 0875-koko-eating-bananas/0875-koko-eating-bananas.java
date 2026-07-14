class Solution {
    public int minEatingSpeed(int[] piles, int h) {

       int max = Integer.MIN_VALUE;
        for (int val : piles) {
            max = Math.max(max, val);
        }
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
        long time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += (piles[i] + sp - 1) / sp;
            // time += Math.ceil(piles[i] * 1.0/sp);
            if (time > h)
                return false;
        }
        return time <= h;
    }
}