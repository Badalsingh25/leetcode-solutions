class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), list);
        return list;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}