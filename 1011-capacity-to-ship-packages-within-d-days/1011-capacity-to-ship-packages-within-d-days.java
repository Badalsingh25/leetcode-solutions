class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int max = 0;
        int sum = 0;

        for(int num : weights){
            sum += num;
            max = Math.max(max, num);
        }
        int low = max, high = sum, ans = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isPossible(weights, mid, days)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[] weights, int capacity, int days){
        int dayUsed = 1;
        int sum = 0;

        for(int num : weights){
            sum += num;
            if(sum > capacity){
                dayUsed++;
                sum = num;
                if(dayUsed > days){
                    return false;
                }
            }
        }
        return dayUsed <= days;
    }
}