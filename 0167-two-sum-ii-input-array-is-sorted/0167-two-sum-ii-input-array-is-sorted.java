class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int low = 0, high = numbers.length - 1;

        while (low <= high) {

            int sum = numbers[low] + numbers[high];

            if (sum == target)
                return new int[] { low + 1, high + 1 };
            else if (sum < target)
                low++;
            else
                high--;
        }
        return new int[] { -1, -1 };
    }
}

/*
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] { map.get(target - numbers[i]) + 1, i + 1 };
            }
            map.put(numbers[i], i);
        }
        return new int[] { -1, -1 };
*/