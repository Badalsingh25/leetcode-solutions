class Solution {
    public int[] nextGreaterElements(int[] nums) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        int n = nums.length;

        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                // int idx = stack.pop();
                // ans[idx] = nums[i % n];
                ans[stack.pop()] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return ans;
    }
}