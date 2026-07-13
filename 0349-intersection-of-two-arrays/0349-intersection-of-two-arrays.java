class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            return intersection(nums2, nums1);
        }
        Set<Integer> set = new HashSet<>();
        // Set<Integer> result = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums1)
            set.add(num);

        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
                set.remove(num);
            }
        }

        int[] arr = new int[result.size()];
        int i = 0;
        for (int num : result) {
            arr[i++] = num;
        }
        return arr;
    }
}