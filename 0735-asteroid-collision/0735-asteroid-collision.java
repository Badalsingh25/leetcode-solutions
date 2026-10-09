class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        int[] stack = new int[asteroids.length];
        int top = -1;

        for (int i = 0; i < asteroids.length; i++) {
            boolean destroyed = false;
            int curr = asteroids[i];
            while (top >= 0 && stack[top] > 0 && curr < 0) {
                if (Math.abs(curr) > stack[top]) {
                    top--;
                    continue;
                } else if (Math.abs(curr) == stack[top]) {
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