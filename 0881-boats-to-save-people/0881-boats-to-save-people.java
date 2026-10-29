class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int left = 0, right = people.length - 1, boat = 0;

        while (left <= right) {
            int weight = people[left] + people[right];
            if (weight <= limit) {
                left++;
            }
            boat++;
            right--;
        }
        return boat;
    }
}