class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        Map<String, List<String>> adj = new HashMap<>();

        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);
        Set<String> visited = new HashSet<>();
        int count=1;
        while(!que.isEmpty()){
            int size = que.size();
            for (int q = 0; q < size; q++) {
                String cur = que.poll();
                if(cur==endWord) return count;
                if (cur.equals(endWord)) {
                    return count;
                }

                for (String w : wordList) {
                    if (visited.contains(w)) continue;

                    int diff = 0;

                    for (int i = 0; i < cur.length(); i++) {
                        if (cur.charAt(i) != w.charAt(i)) {
                            diff++;
                        }
                    }

                    if (diff == 1) {
                        visited.add(w);
                        que.offer(w);
                    }
                }
            }
            count++;
        }
        return 0;
    }
}
