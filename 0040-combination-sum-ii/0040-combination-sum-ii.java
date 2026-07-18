class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), list);
        return list;
    }

    public void backtrack(int start, int[] candidates, int target, List<Integer> temp, List<List<Integer>> result){

        if(target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < candidates.length;i++){
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i] > target) break;

            temp.add(candidates[i]);
            backtrack(i + 1, candidates, target - candidates[i], temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}