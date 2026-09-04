class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] freq = new int[26];
            for(char c : s.toCharArray()){
                freq[c-'a']++;
            }

            StringBuilder key = new StringBuilder();
            for(int i : freq){
                key.append(i);
                key.append("#");
            }
            
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
