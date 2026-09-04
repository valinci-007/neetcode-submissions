class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
            last[chars[i]-'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i=0; i<chars.length; i++){
            end = Math.max(end, last[chars[i]-'a']);

            if(end == i){
                res.add(i-start+1);
                start = i+1;
            }
        }

        return res;
    }
}
