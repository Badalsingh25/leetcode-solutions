class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> list = new ArrayList<>();
        String s = "123456789";

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j <= 9; j++) {
                int n = Integer.parseInt(s.substring(i, j));
                if (n >= low && n <= high) {
                    list.add(n);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}