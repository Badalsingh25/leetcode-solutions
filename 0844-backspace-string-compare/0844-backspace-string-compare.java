class Solution {
    public boolean backspaceCompare(String s, String t) {

        return build(s).equals(build(t));
    }

    private String build(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!sb.isEmpty() && s.charAt(i) == '#') {
                sb.deleteCharAt(sb.length() - 1);
            }
            else if(s.charAt(i) != '#'){
            sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}