class Solution {
    public int maxProduct(int[] nums) {

     int maxSoFar = nums[0];
     int minSoFar = nums[0];
     int maxProduct = nums[0];

     for(int i = 1; i < nums.length;i++){
        if(nums[i] < 0){
            int temp = maxSoFar;
            maxSoFar = minSoFar;
            minSoFar = temp;
        }
        maxSoFar = Math.max(maxSoFar * nums[i], nums[i]);
        minSoFar = Math.min(minSoFar * nums[i], nums[i]);

        maxProduct = Math.max(maxProduct, maxSoFar);
     } 
     return maxProduct;
    }
}