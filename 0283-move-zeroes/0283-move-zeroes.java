class Solution {
    public void moveZeroes(int[] nums) {

        /*
        int k = 0;
        for(int i = 0;i<nums.length;i++){
        
            // Step 1: Move non-zero to front
            if(nums[i] != 0){
                nums[k] = nums[i];
                k++;
            }
        }
        
        // step 2: Fill rest with Zero
        while(k < nums.length){
            nums[k++] = 0;
        }
        */
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }
    }
}