class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;

        for (int num : piles) {
            max = Math.max(max, num);
        }
        int low = 0, high = max, speed = max;

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

    public boolean canEat(int[] piles, int sp, int h) {
        long time = 0;
        for (int num : piles) {
            time += Math.ceil((num * 1.0) / sp);

            if (time > h)
                return false;
        }
        return time <= h;
    }
}