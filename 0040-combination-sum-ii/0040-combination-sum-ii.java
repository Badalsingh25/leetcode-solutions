class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> list = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), list);
        return list;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] > target)
                break;
            // if (i > start && candidates[i] == candidates[i - 1])
            //     continue;
            if(used.contains(candidates[i])) continue;
            used.add(candidates[i]);

            current.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}