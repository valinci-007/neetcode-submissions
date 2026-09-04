class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // cat -> bat -> bag -> sag
    
        Set<String> words = new HashSet<>(wordList);

        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        words.remove(beginWord);
        
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String word = q.poll();

                if(word.equals(endWord)){
                    return level;
                }

                char[] chars = word.toCharArray();
                for(int j=0; j<chars.length; j++){
                    char original = chars[j];

                    for(char c ='a'; c <= 'z'; c++){
                        chars[j] = c;
                        String newWord = new String(chars);
                        if(!words.contains(newWord)) continue;
                        q.add(newWord);
                        words.remove(newWord);
                    }

                    chars[j] = original;
                }
            }
            level++;
        }

        return 0;
    }
}
