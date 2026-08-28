class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
       if(s.length() < p.length()) return list;

        int[] countP = new int[26];
        int[] countS = new int[26];

        for(int i = 0; i < p.length(); i++){
            countS[s.charAt(i) - 'a']++;
            countP[p.charAt(i) - 'a']++;
        }
        if(isMatch(countP, countS)) list.add(0);

        for(int i= p.length(); i < s.length();i++){
            countS[s.charAt(i) - 'a']++;
            countS[s.charAt(i - p.length()) - 'a']--;

            if(isMatch(countP, countS)) list.add(i - p.length() + 1);
        }
        return list;
    }
    private boolean isMatch(int[] a, int[] b){
        for(int i = 0; i < 26; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}