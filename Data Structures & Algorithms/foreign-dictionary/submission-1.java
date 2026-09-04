class Solution {
    public String foreignDictionary(String[] words) {

        Set<Character> unique = new HashSet<>();

        // Set prevents duplicate edges
        Map<Character, Set<Character>> graph = new HashMap<>();

        Map<Character, Integer> indegree = new HashMap<>();

        // 1. Collect ALL unique characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                unique.add(c);
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // 2. Build ordering constraints
        for (int i = 0; i < words.length - 1; i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            // Invalid case: ["abc", "ab"]
            if (word1.length() > word2.length()
                    && word1.startsWith(word2)) {
                return "";
            }

            int len = Math.min(word1.length(), word2.length());
            int j = 0;

            // Find first differing character
            while (j < len &&
                   word1.charAt(j) == word2.charAt(j)) {
                j++;
            }

            // No different character
            // Example: "ab", "abc"
            if (j == len) {
                continue;
            }

            char from = word1.charAt(j);
            char to = word2.charAt(j);

            // Add edge only if it doesn't already exist
            if (graph.get(from).add(to)) {
                indegree.put(to, indegree.get(to) + 1);
            }
        }

        // 3. Kahn's Algorithm
        Queue<Character> q = new ArrayDeque<>();

        for (char c : unique) {
            if (indegree.get(c) == 0) {
                q.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {

            char curr = q.poll();
            sb.append(curr);

            for (char nei : graph.get(curr)) {

                indegree.put(nei, indegree.get(nei) - 1);

                if (indegree.get(nei) == 0) {
                    q.offer(nei);
                }
            }
        }

        // If not all characters were processed → cycle
        return sb.length() == unique.size()
                ? sb.toString()
                : "";
    }
}