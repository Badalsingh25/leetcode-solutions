class Solution {
    public int[] sortArray(int[] nums) {

        int left = 0, right = nums.length - 1;
        mergeSort(nums, left, right);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = nums[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = nums[mid + 1 + i];
        }
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j])
                nums[k++] = leftArr[i++];
            else
                nums[k++] = rightArr[j++];
        }
        while (i < n1)
            nums[k++] = leftArr[i++];
        while (j < n2)
            nums[k++] = rightArr[j++];
    }
}