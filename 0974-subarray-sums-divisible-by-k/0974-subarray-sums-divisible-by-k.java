class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0, count = 0;

        for(int i = 0; i < nums.length;i++){
            prefixSum += nums[i];
            int reminder = (prefixSum % k + k) % k;

            if(map.containsKey(reminder)) count += map.get(reminder);

            map.put(reminder, map.getOrDefault(reminder, 0) + 1);
        }
        return count;
    }
}