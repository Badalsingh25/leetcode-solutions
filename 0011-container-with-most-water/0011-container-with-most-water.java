class Solution {
    public int maxArea(int[] height) {

        int maxArea = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[right], height[left]);

            maxArea = Math.max(maxArea, width * h);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}