class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> patternMap = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if(!patternMap.containsKey(sorted)){
                patternMap.put(sorted, new ArrayList<>());
            }
            patternMap.get(sorted).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> list : patternMap.values()){
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
