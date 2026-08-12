class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            int n = i;
            for (int j = i + 1; j <= 9; j++) {
                n = n * 10 + j;
                if (n >= low && n <= high) {
                    list.add(n);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}