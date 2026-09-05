class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        int[] stack = new int[asteroids.length];
        int top = -1;

        for (int curr : asteroids) {

            Boolean destroyed = false;
            while (top >= 0 && stack[top] > 0 && curr < 0) {
                if (stack[top] < Math.abs(curr)) {
                    top--;
                    continue;
                } else if (stack[top] == Math.abs(curr)) {
                    top--;
                }
                destroyed = true;
                break;
            }
            if (!destroyed) {
                stack[++top] = curr;
            }
        }
        return Arrays.copyOf(stack, top + 1);
    }
}