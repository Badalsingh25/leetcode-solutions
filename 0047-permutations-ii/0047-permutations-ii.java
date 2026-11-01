class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> result) {

        if (start == nums.length) {
            List<Integer> current = new ArrayList<>();
            for (int num : nums) {
                current.add(num);
            }
            result.add(current);
        }
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            
            if(used.contains(nums[i])) continue;
            used.add(nums[i]);

            swap(nums, start, i);
            backtrack(start + 1, nums, result);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}