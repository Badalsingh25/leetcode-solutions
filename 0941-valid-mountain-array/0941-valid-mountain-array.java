class Solution {
    public boolean validMountainArray(int[] arr) {
/*
        int n = arr.length, i = 0;

        if (n < 3)
            return false;
       
        while (i + 1 < n && arr[i] < arr[i + 1]) { //climb up
            i++;
        }

        //peak cannot be first or last
        if (i == 0 || i == n - 1)
            return false;
        
        while (i + 1 < n && arr[i] > arr[i + 1]) { //climb down
            i++;
        }
        return i == n - 1;
*/

    if(arr.length < 3) return false;
        int l = 0;
        int r = arr.length - 1;
        while(l + 1 < arr.length - 1 && arr[l] < arr[l + 1]) l++;
        while(r - 1 > 0 && arr[r] < arr[r - 1]) r--;
        return l == r;
}}