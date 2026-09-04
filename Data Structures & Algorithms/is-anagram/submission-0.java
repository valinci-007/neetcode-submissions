class Solution {
    private String getKey(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder key = new StringBuilder();
        for(int f : freq){
            key.append(f);
            key.append("#");
        }
        return key.toString();
    }

    public boolean isAnagram(String s, String t) {
        return getKey(s).equals(getKey(t));
    }
}
