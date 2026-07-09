class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int buttom = matrix.length - 1;

        while (left <= right && top <= buttom) {

            // Traverse Left -> Right
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            // Traverse Top -> Buttom
            for (int i = top; i <= buttom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (top <= buttom) {
                // Traverse Right -> Left
                for (int i = right; i >= left; i--) {
                    list.add(matrix[buttom][i]);
                }
                buttom--;
            }

            // Traverse Buttom -> Top
            if (left <= right) {
                for (int i = buttom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }

        }
        return list;
    }
}