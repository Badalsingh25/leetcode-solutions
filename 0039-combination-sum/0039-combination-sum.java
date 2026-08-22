class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), list);
        return list;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] > target)
                continue;

            current.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}