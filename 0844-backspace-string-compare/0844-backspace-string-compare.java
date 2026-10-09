class Solution {
    public boolean backspaceCompare(String s, String t) {

        return build(s).equals(build(t));
    }

    private String build(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#')
                sb.append(str.charAt(i));

            else if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
        }
        return sb.toString();
    }
}