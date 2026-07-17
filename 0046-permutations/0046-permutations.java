/*
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, new ArrayList<>(), list, used);
        return list;
    }
    public static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if(used[i]) continue;

            current.add(nums[i]);
            used[i] = true;

            backtrack(nums, current, result,used);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {

       List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> result) {

        if (start == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) {
                perm.add(num);
            }
            result.add(perm);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i); // place a new number at position "start" (choose)
            backtrack(nums, start + 1, result); // Now fix the next position (Explore)
            swap(nums, start, i); // Restore the Array to it's original state (Undo)
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
