/*
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
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

            if (used[i])
                continue;
            if(i > 0 && nums[i] == nums[i-1] && used[i -1] == false) continue;

            current.add(nums[i]);
            used[i] = true;

            backtrack(nums, current, result, used);
            current.remove(current.size() - 1);
            used[i] = false;
        }

    }
}
*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, 0, list);
        return list;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> list) {

        if (start == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) {
                perm.add(num);
            }
            list.add(perm);
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (used.contains(nums[i]))
                continue;
            used.add(nums[i]);

            swap(nums, start, i);
            backtrack(nums, start + 1, list);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}