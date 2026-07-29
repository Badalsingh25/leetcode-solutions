class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            bucket[freq].add(num);
        }
        int[] result = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {

            for (int number : bucket[i]) {
                result[index] = number;
                index++;
                if (index == k) {
                    return result;
                }
            }
        }  
        return result;   
    }
}